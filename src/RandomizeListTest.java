// ==============================================================================
// | Daniel Spence
// | Arizona Holdem Project 2
// | Contains tests for the RandomizeList class
// ==============================================================================

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class RandomizeListTest {		
	
	Random r;
	RandomizeList<Integer> rl;
	List<Integer> list;
	
	public RandomizeListTest() {
		list = new ArrayList<Integer>();

		for(int i = 0; i < 10; i++) {
			list.add(i);
		}		
		
		r = new Random();
		rl = new RandomizeList<Integer>(list, r);
	}	

	@Test
	public void testPrintList() {
		RandomizeList<Integer> rl2 = new RandomizeList<Integer>(list);
		rl2.printList();
	}

	@Test
	public void testTopFive() {
		rl.randomizeList();
		Collections.shuffle(this.list, this.r);
					
		assertEquals(list.subList(0, 5) ,rl.dealFive());
	}

	@Test
	public void testDealTwo() {
		rl.randomizeList();
		Collections.shuffle(this.list, this.r);
		
		assertEquals(list.subList(0, 2), rl.dealTwo());
		assertEquals(list.subList(2, 4), rl.dealTwo());
	}

}
