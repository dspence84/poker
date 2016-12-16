// ==============================================================================
// | Daniel Spence
// | Arizona Holdem Project 2
// | Contains the all important player class that holds the players money,
// | the players number and includes various functionality as finding the
// | player's best hand
// ==============================================================================

import java.util.ArrayList;
import java.util.List;

/**
 * the Player class holds the players data such as player #, cash
 * and functionality for finding the best hand out of a list of 
 * n cards
 * @author Daniel
 *
 */
public class Player {

	private List<Card> playerCards;			// the cards that belong to the player
	private double cashOnHand;				// the amount of money the player has
	private int playerNumber;				// the player's number
	private PokerHand bestHand;				// the bestHand the player can make
	
	/**
	 * Constructs a new player with a given amount of Cash
	 * @param number
	 * @param Cash
	 */
	public Player(int number, double Cash) {
		
		playerCards = new ArrayList<Card>();
		cashOnHand = Cash;
		playerNumber = number;
		bestHand = null;
	}
		
	/**
	 * sets the players cards
	 * @param hand
	 */
	public void receiveHand(List<Card> hand) {
		playerCards = new ArrayList<Card>(hand);
	}
	
	/**
	 * returns the bestHand after findBestHand is ran on a list of cards
	 * @return
	 */
	public PokerHand getBestHand() {
		return bestHand;
	}
	
	/**
	 * This will find the best hand out of the list allCards.  The
	 * bestHand can then be retrieved through getBestHand()
	 * 
	 * @param allCards
	 */
	public void findBestHand(List<Card> allCards) {
		CombinationMaker<Card> cm = new CombinationMaker<Card>(allCards);		
		List<List<Card>> combinations = cm.makeCombinations(PokerHand.HandSize);
		
		PokerHand bestHand = new PokerHand(combinations.get(0));
		PokerHand currentHand;
		for(List<Card> cards : combinations) {
			currentHand = new PokerHand(cards);
			if(currentHand.compareTo(bestHand) > 0) {
				bestHand = currentHand;
			}
		}
		
		this.bestHand = bestHand;
		
	}
	
	/**
	 * gets the players number
	 * @return
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	/**
	 * peaks the players cards
	 * @return
	 */
	public List<Card> getPlayerCards() {
		return playerCards;
	}
	
	/**
	 * peaks the players cash
	 * @return
	 */
	public double getCashOnHand() {
		return cashOnHand;
	}
	
	/**
	 * adds the cash from thePot to the players cash pool
	 * @param thePot
	 */
	public void collectThePot(double thePot) {
		cashOnHand += thePot;
	}
	
	/**
	 * allows the player to bet for amount
	 * @param amount
	 */
	public void bet(double amount) {
		cashOnHand -= amount;
	}	
}