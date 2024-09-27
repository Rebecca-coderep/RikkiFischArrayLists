package arrayLists;

import java.util.ArrayList;

public class ShoppingList <T extends Comparable<T>>{
    private ArrayList<T> items;
    
    public ShoppingList() {
       items = new ArrayList<T>();
    }
    
    public void addItem(T item) {
    	items.add(item);
      //add a reference to 'item' to the ArrayList, 'items' , inserting the reference
      //in the next available position
    }
    
    public void addItem(T item, int position) {
    	items.add(position, item);
        //insert a reference to the item at the position 'position'
      
    }
    public T getItem(int index) {
    	return items.get(index);
        //return shallow copy of the reference to the element at position 'index'
      
    }
    
    public boolean contains(T item) {
    	return items.contains(item);
        //return true if the list contains 
        //a reference to the 'item'
        //else return false
        
    }
     public void addItemInSortedOrder(T item) {
    	 if(items.contains(item)) 
    		 throw new DuplicateDataException();
    	
    		 items.add(item);
    		 items.sort(null);
    	 
    
         //don't insert a duplicate value
         //insert the reference to the 'item' so that each 'item' appears sorted in natural order
      
                     
     }

     public void remove(int position) {
    	 items.remove(position);
        //remove the reference that appears in the element at index, 'position'
     }
     
     public boolean remove(T item) {
    	 return items.remove(item);
        //remove the reference of 'item'
     }
     
     @Override
	public String toString() {
    	 StringBuilder item = new StringBuilder("[");
    	 for(int i=0; i<items.size(); i++)
    		 item.append(items.get(i)+", ");
    	 item.append("]");
		return  item.toString();
				}
     
     public int size() {
    	 return items.size();
         //return how many elements of 'items' reference data
     }
      
    
}
