import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;


/**
 * 
 * @author Joseph Malandruccolo
 *
 * Implementation of a double-ended queue, also known as a deque (pronounced "deck")
 * A deque supports inserting and removing items from either the front or the back of the data structure
 */
public class Deque<Item> implements Iterable<Item> {

	//###########################################################################
	// =>	PROPERTIES
	//###########################################################################
	
	private LinkedList<Item> data;	//data structure to represent the Deque
	private int size;				//the number of Item objects in the Deque
	
	
	
	//###########################################################################
	// =>	CONSTRUCTOR
	//###########################################################################
	
	/**
	 * Constructs an empty deque
	 */
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
	
	
	/**
	 * Remove the item at the front of the Deque
	 * @return the item at the front of the Deque
	 * @throws UnsupportedOperationException on an empty deque
	 */
	public Item removeFirst() {
		if (this.size <= 0) throw new UnsupportedOperationException();
		Item item = data.removeFirst();
		this.size--;
		return item;
	}
	
	
	/**
	 * Remove the item at the back of the Deque
	 * @return the item at the back of the Deque
	 * @throws UnsupportedOperationException on an empty deque
	 */
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
	public Iterator<Item> iterator() { return new DequeIterator(); }


	private class DequeIterator implements Iterator {
		
		private int next = 0;

		@Override
		public boolean hasNext() { return next < size; }

		@Override
		public Item next() {
			if (!this.hasNext()) throw new NoSuchElementException();
			Item item = data.get(this.next);
			next++;
			return item;
		}

		@Override
		public void remove() { throw new UnsupportedOperationException(); }
	
	}//end DequeIterator
	
}//end Deque
