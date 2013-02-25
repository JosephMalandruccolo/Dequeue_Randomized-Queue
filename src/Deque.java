import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {

	//###########################################################################
	// =>	PROPERTIES
	//###########################################################################
	
	private LinkedList<Item> data;	//data structure to represent the Deque
	private int size;				//the number of Item objects in the Deque
	
	
	
	//###########################################################################
	// =>	CONSTRUCTOR
	//###########################################################################
	
	public Deque() {
		this.data = new LinkedList<Item>();
		this.size = 0;
	}
	
	//###########################################################################
	// =>	PUBLIC API
	//###########################################################################
	
	/**
	 * Returns a boolean indicating whether or not the Deque is empty
	 * @return true if the Deque is empty, false otherwise
	 */
	public boolean isEmpty() { return this.size <= 0; }
	
	
	/**
	 * Returns the number of Item objects in the Deque
	 * @return the number of Item objects in the Deque
	 */
	public int size() { return this.size; }
	
	
	/**
	 * Insert an item at the front of the Deque
	 * @param item - the item to be added
	 * @throws NullPointerException if item is null
	 */
	public void addFirst(Item item) {
		if (item == null) throw new NullPointerException();
		this.data.addFirst(item);
		this.size++;
	}
	
	
	/**
	 * Insert an item at the back of the Deque
	 * @param item - the item to be added 
	 * @throws NullPointerException if item is null
	 */
	public void addLast(Item item) {
		if (item == null) throw new NullPointerException();
		this.data.addLast(item);
		this.size++;
	}
	
	public Item removeFirst() {
		if (this.size <= 0) throw new UnsupportedOperationException();
		Item item = data.removeFirst();
		this.size--;
		return item;
	}
	
	public Item removeLast() {
		if (this.size <= 0) throw new UnsupportedOperationException();
		Item item = data.removeLast();
		this.size--;
		return item;
	}
	
	
	
	//###########################################################################
	// =>	ITERATOR
	//###########################################################################
	
	@Override
	public Iterator iterator() { return new DequeIterator(); }


	private class DequeIterator implements Iterator {
		
		private int next = 0;

		@Override
		public boolean hasNext() { return next < size; }

		@Override
		public Item next() {
			if (!(next < size)) throw new NoSuchElementException();
			Item item = data.get(this.next);
			next++;
			return item;
		}

		@Override
		public void remove() { throw new UnsupportedOperationException(); }
	
	}//end DequeIterator
	
}//end Deque
