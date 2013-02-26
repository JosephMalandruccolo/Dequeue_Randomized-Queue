import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Joseph Malandruccolo
 * 
 * A randomized queue is similar to a stack or queue, except that the item removed is chosen 
 * uniformly at random from items in the data structure.
 *
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	
	//###########################################################################
	// =>	PROPERTIES
	//###########################################################################
	private ArrayList<Item> data;
	private int size;
	
	
	
	//###########################################################################
	// =>	CONSTRUCTOR
	//###########################################################################
	public RandomizedQueue(){
		this.data = new ArrayList<Item>();
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
	 * Returns the number of Item objects in the RandomizedQueue
	 * @return the number of Item objects in the RandomizedQueue
	 */
	public int size() { return this.size; }
	
	
	/**
	 * Insert an item to the RandomizedQueue
	 * @param item - the item to be added
	 * @throws NullPointerException if item is null
	 */
	public void enqueue(Item item) {
		
		if (item == null) throw new NullPointerException();
		this.data.add(item);
		this.size++;
	}
	
	
	/**
	 * Delete and return a random item from the RandomizedQueue
	 * @return a random Item
	 * @throws NoSuchElementException if called on an empty randomizedQueue
	 */
	public Item dequeue() {
		
		if (this.size <= 0) throw new NoSuchElementException();
		int randomIndex = StdRandom.uniform(this.size);
		Item item = this.data.remove(randomIndex);
		this.size--;
		
		return item;
		
	}
	
	
	/**
	 * Return a random item from the RandomizedQueue
	 * @return a random Item
	 * @throws NoSuchElementException if called on an empty randomizedQueue
	 */
	public Item sample() {
		
		if (this.size <= 0) throw new NoSuchElementException();
		int randomIndex = StdRandom.uniform(this.size);
		Item item = this.data.get(randomIndex);
		
		return item;
		
	}
	
	
	
	

	//###########################################################################
	// =>	ITERABLE
	//###########################################################################
	@Override
	public Iterator<Item> iterator() { return new RandomizedQueueIterator(); }
	
	
	private class RandomizedQueueIterator implements Iterator {

		
		ArrayList<Integer> availableIndices;
		
		
		private RandomizedQueueIterator(){
			this.availableIndices = new ArrayList<Integer>(size);
			for (int i : availableIndices) availableIndices.set(i, i);
		}
		
		
		
		@Override
		public boolean hasNext() { return this.availableIndices.size() > 0; }

		@Override
		//get a random index from our list of random indices, then remove that random index
		public Item next() {
			
			if (!this.hasNext()) throw new NoSuchElementException();
			int randomIndex = this.availableIndices.get(StdRandom.uniform(this.availableIndices.size()));
			this.availableIndices.remove(randomIndex);
			
			return data.get(randomIndex);
			
		}

		@Override
		public void remove() { throw new UnsupportedOperationException(); }
		
	}
	
	
	
	
}
