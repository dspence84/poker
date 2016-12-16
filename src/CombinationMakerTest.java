// ==============================================================================
// | Daniel Spence
// | Arizona Holdem Project 2
// | Tests combinationMaker class
// ==============================================================================

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CombinationMakerTest {

	@Test
	public void testCombination() {
		List<Integer> l = new ArrayList<Integer>();
		
		l.add(1);
		l.add(2);
		l.add(3);
		
		List<List<Integer>> combos = new ArrayList<List<Integer>>();
		
		List<Integer> combo = new ArrayList<Integer>();
		combo.add(1); combo.add(2);
		combos.add(new ArrayList<Integer>(combo));
		combo.clear();
		combo.add(1); combo.add(3);
		combos.add(new ArrayList<Integer>(combo));
		combo.clear();
		combo.add(2); combo.add(3);
		combos.add(new ArrayList<Integer>(combo));
		
		CombinationMaker<Integer> c = new CombinationMaker<Integer>(l);
		
		assertEquals(c.makeCombinations(2), combos);
		assertEquals(c.makeCombinations(2).get(0).size(), 2);
	}
}
