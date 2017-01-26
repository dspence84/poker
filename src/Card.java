// ==============================================================================
// | Daniel Spence
// | contains the Card class
// ==============================================================================

/** 
 * Creates an instance of a standard playing card  
 * @author Daniel Spence
 */
public class Card implements Comparable<Card> {

	private Rank rank;
	private Suit suit;
	
	/**
	 * Creates a new instance of a card
	 *
	 * @param  rank a rank type to assign the current card
	 * @param  suit a suit type to assign the current card
	 */
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * prints the card's rank and suit symbol
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append( this.getRank().toString());
		sb.append( this.getSuit().toString());
		
		return sb.toString();
	}	

	public int compareTo(Card other) {		
		return this.getRank().getValue() - other.getRank().getValue();
	}
	
	/**
	 * peak the card's suit
	 * 
	 * @return the suit of the card
	 */
	public Suit getSuit() {
		return suit;                                                                                                                                                                
	}
	
	/**
	 * peak the card's rank
	 *
	 * @return the rank of the card
	 */
	public Rank getRank() {
		return rank;
	}
}
