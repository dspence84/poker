// ------------------------------------------------------------------------------
// Daniel Spence
// Arizona Holdem project 2
// contains the Suit Enum
// ------------------------------------------------------------------------------

// Spades: '\u2660'
// Diamonds: '\u2666'
// Clubs: '\u2663'
// Hearts: '\u2764'

// a Card has 4 suits, enumerated as follows:
public enum Suit {
	Diamonds("\u2666"), Clubs("\u2663"), Hearts("\u2764"), Spades("\u2660");
	
	private String suitStr;
	
	private Suit(String suit) {
		this.suitStr = suit;
	
	}
	
	@Override
	public String toString() {
		return suitStr;
	}
}
