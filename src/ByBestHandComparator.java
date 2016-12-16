// ==============================================================================
// | Daniel Spence
// | Arizona Holdem Project 2
// | comparator class to arrange the players by best hand
// ==============================================================================

import java.util.Comparator;

/**
 * This comparator class will sort the players by best hand.
 * @author Daniel
 *
 */
public class ByBestHandComparator implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		return o2.getBestHand().compareTo(o1.getBestHand());	
	}

}
