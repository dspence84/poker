// ==============================================================================
// | Daniel Spence
// | Arizona Holdem project 2
// | Contains the trick enum
// ==============================================================================

public enum Trick {
	Nothing(0),
	Pair(1),
	TwoPair(2),
	ThreeOfAKind(3),
	Straight(4),
	Flush(5),
	FullHouse(6),
	FourOfAKind(7),
	StraightFlush(8);
	
	private int value;
	
	private Trick(int value) {
		this.value = value;
	}
	
	/**
	 * getter for the value of the current trick as compared to the other tricks
	 * @return the value of the trick
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * gives a formatted string representation of the trick
	 */
	public String toString() {
		switch(this) {		
		case Nothing: return "Nothing";
		case Pair: return "Pair";
		case TwoPair: return "Two Pair";
		case ThreeOfAKind: return "Three of a Kind";
		case Straight: return "Straight";
		case Flush: return "Flush";
		case FullHouse: return "Full House";
		case FourOfAKind: return "Four of a Kind";
		case StraightFlush: return "Straight Flush";
		default: throw new IllegalArgumentException();
		}
	}
	
}
