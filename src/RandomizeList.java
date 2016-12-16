// ==============================================================================
// | Daniel Spence
// | Arizona Holdem Project 2
// | Contains the RandomizeList class
// ==============================================================================

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Modified RandomizeList given to us on Piazza -- made it generic
 * and added some functionality
 * @author 
 *
 * @param <T> The type you would like to randomize in a list
 */
public class RandomizeList<T> {
	
	List<T> list;			// the list to hold all elements
	Random r;				// java random generator
	private int index;		// card index for dealing list items
	
	/**
	 * this ctor allows the user to specify their own Random object
	 * @param list - the list to be randomized
	 * @param r - the random object to use
	 */
	public RandomizeList(List<T> list, Random r) {
		this.list = list;
		this.r = r;
		this.index = 0;
	}
	
	/**
	 * this ctor will create a new random, more likely to be used
	 * @param list - the list to randomize
	 */
	public RandomizeList (List<T> list) {
		this(list, new Random());
	}
	
	/**
	 * call this to shuffle the list
	 */
	public void randomizeList() {
		index = 0;
		Collections.shuffle(this.list, this.r);
	}
	
	/**
	 * a function to print the list
	 */
	public void printList() {
		for (T i : this.list) {
			System.out.println(i);
		}
	}
	
	/**
	 * deals the top 5 items of the list and moves the index accordingly
	 * @return a sublist of the 5 top items
	 */
	public List<T> dealFive() {
		index += 5;
		return this.list.subList(index - 5, index);	
	}
	
	/**
	 * deals the top 2 items of the list and moves the index accordingly
	 * @return a sublist of the top 2 items
	 */
	public List<T> dealTwo() {
		index += 2;		
		return this.list.subList(index - 2, index);		
	}
	
}