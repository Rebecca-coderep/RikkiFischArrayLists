package arrayLists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestShoppingList {
   private ShoppingList<String> shoppingList;
	@BeforeEach
	void setUp() throws Exception {
		assertThrows(NullPointerException.class,
				()-> shoppingList.addItem("Bananas")
				);
		shoppingList = new ShoppingList<String>();
		
	}

	@Test
	void testShoppingList() {
		assertEquals(0, shoppingList.size());
	}

	@Test
	void testAddItem() {
		assertEquals(0, shoppingList.size());
		shoppingList.addItem("Apples");
		assertEquals(1, shoppingList.size());
		assertTrue(shoppingList.contains("Apples"));
		
	}
	
	@Test
	void testAddItemInt() {
		assertEquals(0, shoppingList.size());
		assertThrows(IndexOutOfBoundsException.class,
				()-> shoppingList.addItem("Apples",1));
		shoppingList.addItem("Apples",0);
		assertEquals(1, shoppingList.size());
		assertThrows(IndexOutOfBoundsException.class,
				()-> shoppingList.addItem("Bananas", 2));
		shoppingList.addItem("Bananas", 0);
		assertTrue(shoppingList.contains("Bananas"));
		shoppingList.remove(0);
		assertFalse(shoppingList.contains("Bananas"));
		shoppingList.addItem("Celery", 1);
		shoppingList.addItem("Figs", 2);
		assertThrows(IndexOutOfBoundsException.class,
				()->shoppingList.addItem("Watermelon",4)
				);
		assertTrue(shoppingList.contains("Figs"));
		shoppingList.remove(2);
		assertFalse(shoppingList.contains("Figs"));
		
	}

	@Test
	void testGetItem() {
		assertEquals(0, shoppingList.size());
		shoppingList.addItem("Apples");
		assertEquals(1, shoppingList.size());
		assertEquals("Apples", shoppingList.getItem(0));
		shoppingList.addItem("Carrots");
		assertEquals(2, shoppingList.size());
		assertEquals("Carrots",shoppingList.getItem(1));
		assertEquals("Apples", shoppingList.getItem(0));
		assertThrows(IndexOutOfBoundsException.class,
				()-> shoppingList.getItem(2));
	}

	@Test
	void testContains() {
		assertEquals(0, shoppingList.size());
		assertFalse(shoppingList.contains("Apples"));
		shoppingList.addItem("Apples");
		assertTrue(shoppingList.contains("Apples"));
		
		shoppingList.addItem("Carrots");
		assertTrue(shoppingList.contains("Carrots"));
		shoppingList.remove("Apples");
		assertFalse(shoppingList.contains("Apples"));
	}

	@Test
	void testAddItemInSortedOrder() {
		shoppingList.addItemInSortedOrder("Carrots");
		assertEquals("Carrots", shoppingList.getItem(0));
		shoppingList.addItemInSortedOrder("Apples");
		assertEquals("Apples",shoppingList.getItem(0));
		assertEquals("Carrots", shoppingList.getItem(1));
		shoppingList.addItemInSortedOrder("Bananas");
		assertEquals("Bananas", shoppingList.getItem(1));
		assertEquals("Apples", shoppingList.getItem(0));
		assertEquals("Carrots", shoppingList.getItem(2));
		shoppingList.addItemInSortedOrder("Berries");
		shoppingList.addItemInSortedOrder("Grapes");
		assertEquals("Grapes", shoppingList.getItem(4));
		assertEquals("Carrots", shoppingList.getItem(3));
		assertThrows(DuplicateDataException.class,
				()->shoppingList.addItemInSortedOrder("Berries")
				);
		
	}

	@Test
	void testRemoveInt() {
		shoppingList.addItemInSortedOrder("Carrots");
		shoppingList.addItemInSortedOrder("Apples");
		shoppingList.addItemInSortedOrder("Bananas");
		shoppingList.addItemInSortedOrder("Berries");
		shoppingList.addItemInSortedOrder("Grapes");
		
		assertEquals("Apples", shoppingList.getItem(0));
	    assertEquals("Bananas", shoppingList.getItem(1));
	    assertEquals("Berries", shoppingList.getItem(2));
	    shoppingList.remove(0);
	    assertEquals("Bananas", shoppingList.getItem(0));
	    assertEquals("Berries", shoppingList.getItem(1));
	    assertFalse(shoppingList.contains("Apples"));
	    assertThrows (IndexOutOfBoundsException.class,
	    		()-> shoppingList.remove(4)
	    		);
	    shoppingList.remove(3);
	    assertFalse(shoppingList.contains("Grapes"));
		
	}

	@Test
	void testRemoveT() {
		shoppingList.addItem("Berries");
		shoppingList.addItem("Carrots");
		shoppingList.addItem("Apples");
		shoppingList.addItem("Grapes");
		assertEquals(4,shoppingList.size());
		assertTrue(shoppingList.contains("Apples"));
		assertTrue(shoppingList.contains("Berries"));
		assertTrue(shoppingList.contains("Carrots"));
		assertTrue(shoppingList.contains("Grapes"));
		assertTrue(shoppingList.remove("Apples"));
		assertFalse(shoppingList.contains("Apples"));
		assertEquals(3, shoppingList.size());
		assertTrue(shoppingList.remove("Carrots"));
		assertFalse(shoppingList.contains("Carrots"));
		assertEquals(2, shoppingList.size());
		assertTrue(shoppingList.remove("Grapes"));
		assertFalse(shoppingList.contains("Grapes"));
		assertEquals(1, shoppingList.size());
		assertFalse(shoppingList.remove("Grapes"));
	}

	@Test
	void testToString() {
		shoppingList.addItem("Berries");
		shoppingList.addItem("Carrots");
		shoppingList.addItem("Apples");
		shoppingList.addItem("Grapes");
		assertEquals("[Berries, Carrots, Apples, Grapes]",
				shoppingList.toString());
		
		ShoppingList<String>aList =
				new ShoppingList<String>();
		aList.addItemInSortedOrder("Berries");
		aList.addItemInSortedOrder("Carrots");
		aList.addItemInSortedOrder("Apples");
		aList.addItemInSortedOrder("Grapes");
		assertEquals("[Apples, Berries, Carrots, Grapes]",
				aList.toString());
				
	}

}
