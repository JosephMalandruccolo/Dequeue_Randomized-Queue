import java.util.Iterator;

/**
 * 
 * @author Joseph Malandruccoo
 * 
 * Read a command-line integer k and reads N strings from StdIn.readString()
 * Print k Strings at random
 *
 */
public class Subset {
	
	
	//###########################################################################
	// =>	MAIN METHOD
	//###########################################################################
	public static void main(String[] args) {
		
		int k = Integer.parseInt(args[0]);
		
		RandomizedQueue<String> strings = new RandomizedQueue<String>();
		while (StdIn.hasNextLine()) strings.enqueue(StdIn.readString());
		
		Iterator iterator = strings.iterator();
		while (iterator.hasNext() && k > 0) {
			StdOut.println(iterator.next());
			k--;
		}
		
	}//end main
	
	

}
