// ==============================================================================
// | Daniel Spence
// | Arizona Holdem Project 2
// | Contains the CombinationMaker class
// ==============================================================================

import java.util.ArrayList;
import java.util.List;

/**
 * creates a list of all possible combinations of 
 * a list from their positions in that list
 * @author Daniel Spence
 *
 * @param <T> the type of objects you would like to create combinations for
 */
public class CombinationMaker<T> {

	private List<List<T>> combinations;
	private List<T> combination;
	private List<T> list;
	
	/**
	 * creats a new CombinationMaker
	 * @param list -- the list in which to work with
	 */
	public CombinationMaker(List<T> list) {
		combinations = new ArrayList<List<T>>();
		combination = new ArrayList<T>();
		this.list = new ArrayList<T>(list);
	}
	
	/**
	 * runs the combination algorithm
	 * @param k choose k objects from the list size
	 * @return returns a new List containing all combinations
	 * of the original list
	 */
	public List<List<T>> makeCombinations(int k) {
		comb(0, k);
		return new ArrayList<List<T>>(combinations);
	}
	
	// pick an element find all the combinations of K-1 elements
	private void comb(int offset, int k) {
		if(k == 0) {
			combinations.add(new ArrayList<T>(combination));
			return;
		}
		
		for(int i = offset; i < list.size(); i++) {
			combination.add(list.get(i));
			comb(i+1,k-1);
			combination.remove(combination.size() - 1);
		}
	}
}
