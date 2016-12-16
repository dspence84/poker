// ==============================================================================
// | Daniel Spence
// | Arizona Holdem project 2
// | The all important PokerHand class.  Implements a modeled poker hand which
// | can then be compared to other poker hands to determine a clear winner.
// ==============================================================================

import java.util.ArrayList;
import java.util.Collections; // Gives us  Collections.sort
import java.util.List;

/** 
 * Creates an instance of a PokerHand  
 * @author Daniel Spence
 */
public class PokerHand implements Comparable<PokerHand> {
	
	public static final int HandSize = 5;	// how many cards in a hand
	
	private ArrayList<Card> cards;			// cards in the hand
	private ArrayList<Card> trickCards;		// cards associated with the hands trick
	private ArrayList<Card> highCards;		// card's not associated with a trick
	
	private Trick trick;					// the hand's trick
	private int trickScore;					// a score given to the trick based off the rank of the trick
	private int trickScoreSecondary;		// a score given to the second part of the trick(ie two pair's low pair)
		
	/**
	 * Instantiates a new PokerHand
	 * @param c1 Card 1
	 * @param c2 Card 2
	 * @param c3 Card 3
	 * @param c4 Card 4
	 * @param c5 Card 5
	 */
	public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards = new ArrayList<Card>();
		trickCards = new ArrayList<Card>();
		highCards = new ArrayList<Card>();
						
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
				
		
		trick = Trick.Nothing;
		trickScore = 0;
		trickScoreSecondary = 0;
		
		// determine the trick
		calculateHand();		
	}
	
	/**
	 * instantiates a new PokerHand with a list of 5 cards
	 * @param hand the poker hand you would like to create
	 */
	public PokerHand(List<Card> hand) {
		this(hand.get(0), hand.get(1), hand.get(2), hand.get(3), hand.get(4));
	}

	/**
	 * gets the hand of cards as a list
	 * @return the cards as a *new* list
	 */
	public List<Card> getHand() {
		return new ArrayList<Card>(cards);
	}
	
	/**
	 * returns the PokerHand in a readable string form
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Card c : cards) {
			sb.append(c);
			sb.append(" ");
		}
		
		return sb.toString().trim();
	}
	
	/**
	 * returns the hands trick
	 * @return trick
	 */
	public Trick getTrick() {
		return trick;
	}
	/** returns the trickScore for comparison
	 * @return trickScore
	 */
	public int getTrickScore() {
		return trickScore;
	}

	/**
	 * getter method for the object's trickScoreSecondary field
	 * @return trickScoreSecondary
	 */
	public int getTrickScoreSecondary() {
		return trickScoreSecondary;
	}
	
	/**
	 * getter method for the Hand's cardlist
	 * @return cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	/**
	 * getter method for the object's list of high card's
	 * @return highCards
	 */
	public ArrayList<Card> getHighCards() {
		return highCards;
	}
	
	/**
	 * 	Compares two PokerHand object's to determine which one 'wins'
	 */
	public int compareTo(PokerHand other) {
		int trickCompare;
		ArrayList<Card> combined = new ArrayList<Card>();
		combined.addAll(this.getCards());
		combined.addAll(other.getCards());
		
		// compare the two hands tricks
		trickCompare = this.getTrick().getValue() - other.getTrick().getValue();
				
		if(trickCompare == 0) {
			// if they have the same trick compare their trickScore
			if(this.getTrickScore() - other.getTrickScore() == 0) {
				// if they have the same trickScore it's likely a two pair and we'll need a secondary score (the other pair..)
				if(this.getTrickScoreSecondary() - other.getTrickScoreSecondary() == 0) { // 
					return compareHighCards(other.getHighCards());
				} else { // 
					return this.getTrickScoreSecondary() - other.getTrickScoreSecondary();
				}
			} else { 
				return this.getTrickScore() - other.getTrickScore();
			}
		} else {
			return trickCompare;
		}
	}

	/**
	 * calculates the trickScore and secondaryTrickScore to make the PokerHand comparable
	 */
	private void calculateHand() {
	    
		// grab the trick and switch through it
		trick = determineTrick();		
		
		switch(trick) {
		case Nothing:
			// no trickScore, the compareTo function will take care of the high cards
			trickScore = 0;
			break;			
		case Pair:
			// double the pair!
			trickScore = trickCards.get(0).getRank().getValue() * 2;					
			break;			
		case TwoPair:
			// double each pair, secondary trickScore is used here
			trickScore = Collections.max(trickCards).getRank().getValue() * 2;
			trickScoreSecondary = Collections.min(trickCards).getRank().getValue() * 2;
			break;
		case ThreeOfAKind:
			// triple it!
			trickScore = trickCards.get(0).getRank().getValue() * 3;
			break;
		case FullHouse:
			// find the 3 of a kind and place the scores where they go
			if(trickCards.get(1).getRank() == trickCards.get(2).getRank()) {
				trickScore = trickCards.get(0).getRank().getValue() * 3;
				trickScoreSecondary = trickCards.get(3).getRank().getValue() * 2;
			} else {
				trickScore = trickCards.get(2).getRank().getValue() * 3;
				trickScoreSecondary = trickCards.get(0).getRank().getValue() * 2;
			}				
			break;
		case FourOfAKind:
			// simple, 4 times the score
			trickScore = trickCards.get(0).getRank().getValue() * 4;
			break;
		case StraightFlush:		
		case Straight:
			// simply add all the cards together ( probably could just add the high card...)
			for(Card c : cards) {
				trickScore += c.getRank().getValue();
			}
			
			// change the ace value to low
			if(cards.get(0).getRank() == Rank.Deuce && cards.get(4).getRank() == Rank.Ace) {
				trickScore -= 13;
			}
		break;
		case Flush:
			// treat it like nothing, determine the high card later
			trickScore = 0;
			break;
		default:
			break;
		}
		
	}

	/**
	 * iterates the highCards list and the other cards list until
	 * a high card between the two is found.
	 * @param other the PokerHand to compare highCards with
	 * @return 1 if this hand has the better high card, 
	 *         0 if they have the same high card(s)
	 *         -1 if the other hand has a better high card
	 */
	private int compareHighCards(ArrayList<Card> other) {
		Collections.sort(highCards, Collections.reverseOrder());
		Collections.sort(other, Collections.reverseOrder());

		for(int i = 0; i < highCards.size(); i++) {

			if(highCards.get(i).getRank().getValue() > other.get(i).getRank().getValue() ) {
				return 1;
			} else if(highCards.get(i).getRank().getValue() < other.get(i).getRank().getValue()) {
				return -1;
			}
		}
	
		return 0;
	}
	
	/**
	 * determines the PokerHand's trick (ex. FourOfAKind, etc...)
	 * @return the Trick that was determined
	 */
	private Trick determineTrick() {			
		boolean foundTwo = false;		// determine if two cards were found
		boolean foundThree = false;		// determine if three cards were found
		boolean foundFour = false;		// four cards
		boolean succession = false;		// are the cards in a row?
		boolean straight = true;		// are the cards a straight?
		boolean flush = true;			// are the cards a flush?
		boolean firstCardHigh = true;	// is the first card a possible high card?
		
		int numPairs = 0;				// number of pairs found (two pairs will result when a 3 of a kind is found etc)
		Card lastCard = null;			// 
		
		// let's start with a sorted card list (this will make finding straight easy peasy
		Collections.sort(cards);
		
		// determine if cards are in succession
		for(Card currentCard : cards) {					
			
			if(lastCard == null) {
				lastCard = currentCard;				
				continue;
			}
			if(lastCard.getRank() == currentCard.getRank() ) {
				if(foundFour) {
					// throw new DuplicateCardException();  // should never get here
				} else if(foundThree && succession) {
					foundFour = true;
					foundThree = false;
					trickCards.add(currentCard);
				} else if(foundTwo && succession) {
					foundThree = true;
					foundTwo = false;
					trickCards.add(currentCard);
				} else {
					numPairs++;
					succession = true;
					foundTwo = true;
					firstCardHigh = false;
					trickCards.add(currentCard);
					trickCards.add(lastCard);
				}
			} else {
				// cards are not in succession, add a high card just in case
				succession = false;
				foundTwo = false;
				highCards.add(currentCard);

				// add the first card to the highCards list if no pair was found 
				if(firstCardHigh)
					highCards.add(lastCard);
			}						
			
			// if last card's value is not sequential to this card's value, then no straight
			if(lastCard.getRank().getValue() != currentCard.getRank().getValue() - 1) {
				straight = false;
			}
			// same kind of deal for a flush, but with suit
			if(lastCard.getSuit() != currentCard.getSuit()) {			
				flush = false;
			}
			
			// update the last card for the next iteration of the loop
			lastCard = currentCard;
		}
		
		// well, let's see if it was an ace low straight...
		if(!straight) straight = isAceLowStraight();
		
		// use what we found to create this beautiful return logic
		if(straight) {
			if(flush) {
				return Trick.StraightFlush;
			} else {
				return Trick.Straight;
			}
		} else if(flush) {
			return Trick.Flush;		
		} else if(foundFour) {
			return Trick.FourOfAKind;
		} else if(foundThree) {
			if(numPairs == 2) {
				return Trick.FullHouse;
			} else {
				return Trick.ThreeOfAKind;
			}
		} else if(numPairs > 0) {
			if(numPairs == 2) {
				return Trick.TwoPair;
			} else {
				return Trick.Pair;
			}
		} else {
			return Trick.Nothing;
		}
				
	}
	
	// a helper method to determine an ace low straight (kind of brute forcing this...	)
	private boolean isAceLowStraight() {
		
		if( cards.get(0).getRank() == Rank.Deuce &&
		    cards.get(1).getRank() == Rank.Three &&
		    cards.get(2).getRank() == Rank.Four &&
		    cards.get(3).getRank() == Rank.Five &&
		    cards.get(4).getRank() == Rank.Ace )
			return true;
		
		return false;
	}
}
