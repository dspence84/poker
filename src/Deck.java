// ==============================================================================
// | Daniel Spence
// | Arizona Holdem Project 2
// | Responsible for creating a deck of cards and serving them up
// ==============================================================================

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
		
	// Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce, Suit.Clubs)
	private final static Card C2 = new Card(Rank.Deuce, Suit.Clubs);
	private final static Card C3 = new Card(Rank.Three, Suit.Clubs);
	private final static Card C4 = new Card(Rank.Four, Suit.Clubs);
	private final static Card C5 = new Card(Rank.Five, Suit.Clubs);
	private final static Card C6 = new Card(Rank.Six, Suit.Clubs);
	private final static Card C7 = new Card(Rank.Seven, Suit.Clubs);
    private final static Card C8 = new Card(Rank.Eight, Suit.Clubs);
	private final static Card C9 = new Card(Rank.Nine, Suit.Clubs);
	private final static Card C10 = new Card(Rank.Ten, Suit.Clubs);
	private final static Card CJ = new Card(Rank.Jack, Suit.Clubs);
	private final static Card CQ = new Card(Rank.Queen, Suit.Clubs);
	private final static Card CK = new Card(Rank.King, Suit.Clubs);
	private final static Card CA = new Card(Rank.Ace, Suit.Clubs);

	private final static Card D2 = new Card(Rank.Deuce, Suit.Diamonds);
	private final static Card D3 = new Card(Rank.Three, Suit.Diamonds);
	private final static Card D4 = new Card(Rank.Four, Suit.Diamonds);
	private final static Card D5 = new Card(Rank.Five, Suit.Diamonds);
	private final static Card D6 = new Card(Rank.Six, Suit.Diamonds);
	private final static Card D7 = new Card(Rank.Seven, Suit.Diamonds);
	private final static Card D8 = new Card(Rank.Eight, Suit.Diamonds);
	private final static Card D9 = new Card(Rank.Nine, Suit.Diamonds);
	private final static Card D10 = new Card(Rank.Ten, Suit.Diamonds);
	private final static Card DJ = new Card(Rank.Jack, Suit.Diamonds);
	private final static Card DQ = new Card(Rank.Queen, Suit.Diamonds);
	private final static Card DK = new Card(Rank.King, Suit.Diamonds);
	private final static Card DA = new Card(Rank.Ace, Suit.Diamonds);

	private final static Card H2 = new Card(Rank.Deuce, Suit.Hearts);
	private final static Card H3 = new Card(Rank.Three, Suit.Hearts);
	private final static Card H4 = new Card(Rank.Four, Suit.Hearts);
	private final static Card H5 = new Card(Rank.Five, Suit.Hearts);
	private final static Card H6 = new Card(Rank.Six, Suit.Hearts);
	private final static Card H7 = new Card(Rank.Seven, Suit.Hearts);
	private final static Card H8 = new Card(Rank.Eight, Suit.Hearts);
	private final static Card H9 = new Card(Rank.Nine, Suit.Hearts);
	private final static Card H10 = new Card(Rank.Ten, Suit.Hearts);
	private final static Card HJ = new Card(Rank.Jack, Suit.Hearts);
	private final static Card HQ = new Card(Rank.Queen, Suit.Hearts);
	private final static Card HK = new Card(Rank.King, Suit.Hearts);
	private final static Card HA = new Card(Rank.Ace, Suit.Hearts);

	private final static Card S2 = new Card(Rank.Deuce, Suit.Spades);
	private final static Card S3 = new Card(Rank.Three, Suit.Spades);
	private final static Card S4 = new Card(Rank.Four, Suit.Spades);
	private final static Card S5 = new Card(Rank.Five, Suit.Spades);
	private final static Card S6 = new Card(Rank.Six, Suit.Spades);
	private final static Card S7 = new Card(Rank.Seven, Suit.Spades);
	private final static Card S8 = new Card(Rank.Eight, Suit.Spades);
	private final static Card S9 = new Card(Rank.Nine, Suit.Spades);
	private final static Card S10 = new Card(Rank.Ten, Suit.Spades);
	private final static Card SJ = new Card(Rank.Jack, Suit.Spades);
	private final static Card SQ = new Card(Rank.Queen, Suit.Spades);
	private final static Card SK = new Card(Rank.King, Suit.Spades);
	private final static Card SA = new Card(Rank.Ace, Suit.Spades);
	
	
	private RandomizeList<Card> rl;
	private List<Card> deck;
	
	public Deck() {
		
		deck = new ArrayList<Card>();		
		rl = new RandomizeList<Card>(deck);
	}	
	
	public void Shuffle() {		
		rl.randomizeList();
	}
	
	public List<Card> dealTwo() {
		return rl.dealTwo();
	}
	
	public List<Card> dealFive() {
		return rl.dealFive();
	}
	
	public void build52CardDeck() {
		deck.add(C2);
		deck.add(C2);
		deck.add(C3);
		deck.add(C4);
		deck.add(C5);
		deck.add(C6);
		deck.add(C7);
		deck.add(C8);
		deck.add(C9);
		deck.add(C10);
		deck.add(CJ);
		deck.add(CQ);
		deck.add(CK);
		deck.add(CA);
		
		deck.add(S2);
		deck.add(S3);
		deck.add(S4);
		deck.add(S5);
		deck.add(S6);
		deck.add(S7);
		deck.add(S8);
		deck.add(S9);
		deck.add(S10);
		deck.add(SJ);
		deck.add(SQ);
		deck.add(SK);
		deck.add(SA);
		
		deck.add(D2);
		deck.add(D3);
		deck.add(D4);
		deck.add(D5);
		deck.add(D6);
		deck.add(D7);
		deck.add(D8);
		deck.add(D9);
		deck.add(D10);
		deck.add(DJ);
		deck.add(DQ);
		deck.add(DK);
		deck.add(DA);
		
		deck.add(H2);
		deck.add(H3);
		deck.add(H4);
		deck.add(H5);
		deck.add(H6);
		deck.add(H7);
		deck.add(H8);
		deck.add(H9);
		deck.add(H10);
		deck.add(HJ);
		deck.add(HQ);
		deck.add(HK);
		deck.add(HA);
	}
}
