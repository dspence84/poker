// ------------------------------------------------------------------------------
// Daniel Spence
// Arizona Holdem project 2
// contains the Rank enum
// ------------------------------------------------------------------------------

// a set of ranks for a playing card -- Ace through King
public enum Rank {
	Deuce(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), 
	Ten(10), Jack(11), Queen(12), King(13), Ace(14);
	
	private int value;
	
	// private constructor sets the value depending on what rank is picked
	private Rank(int val) {
		value = val;
	}

	@Override
	public String toString() {
		
		switch (this) {
		case Jack:
			return "J";
		case Queen:
			return "Q";
		case King:
			return "K";
		case Ace:
			return "A";
		default:
			return String.valueOf(value);
			
		}
		
	}
	
	// return the value of the rank
	public int getValue() {
		return value;
	}
}
