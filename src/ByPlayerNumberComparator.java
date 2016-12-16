// ==============================================================================
// | Daniel Spence
// | Arizona Holdem Project 2
// | comparator class for sorting players
// ==============================================================================

import java.util.Comparator;

/**
 * comparator to order the players by number
 * @author Daniel
 *
 */
public class ByPlayerNumberComparator implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		return o1.getPlayerNumber() - o2.getPlayerNumber();	
	}
}
