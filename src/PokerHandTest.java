// =============================================================================
// | Daniel Spence
// | PokerHand project 1
// | Contains the class for testing PokerHand.  Attempts to insure all code
// | is working properly.
// ==============================================================================

import static org.junit.Assert.*;

import org.junit.Test;

public class PokerHandTest {

	@Test
	  public void testSuitEnum() {
	    String result = "";
	    for (Suit suit : Suit.values())
	      result += suit + " ";
	    assertEquals("Diamonds Clubs Hearts Spades", result.trim());
	  }

	  @Test
	  public void testRankEnum() {
	    String result = "";
	    for (Rank rank : Rank.values())
	      result += rank + " ";
	    assertEquals(
	        "Deuce Three Four Five Six Seven Eight Nine Ten Jack Queen King Ace",
	        result.trim());
	  }


	  @Test
	  public void testTwoPairWhenOnePairIsEqual() {
	    PokerHand a = new PokerHand(C4, HK, D4, H3, DK);
	    PokerHand b = new PokerHand(H4, C10, CA, DA, S4);
	    assertTrue(a.compareTo(b) < 0);
	    assertTrue(b.compareTo(a) > 0);
	  }

	  @Test
	  public void testAceLowStraight() {
	    PokerHand a = new PokerHand(CA, C2, C3, C4, H5);
	    PokerHand b = new PokerHand(D2, D3, D4, D5, H6);
	    boolean answer = a.compareTo(b) < 0;
	    assertTrue(answer);
	  }
	
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
	
	@Test
	public void testNothing() {
		PokerHand ph = new PokerHand(S3, D4, C8, DA, DJ);
		assertEquals(Trick.Nothing, ph.getTrick());
		
		ph = new PokerHand(S3, D4, S5, D6, HA);
		assertEquals(Trick.Nothing, ph.getTrick());
	}
	
	@Test
	public void testNothingCompare() {
		PokerHand ph1 = new PokerHand(S4, S5, SK, SA, DJ);
		PokerHand ph2 = new PokerHand(HJ, CA, HK, C5, S3);
		assertEquals(Trick.Nothing, ph1.getTrick());
		assertTrue(ph1.compareTo(ph2) > 0);
		
		ph2 = new PokerHand(D4, D5, DK, CA, SJ);
		assertTrue(ph1.compareTo(ph2) == 0);
	}	
	  
	@Test
	public void testPairs() {
		PokerHand ph = new PokerHand(S3, D3, D5, D6, D9);				
		assertEquals(Trick.Pair, ph.getTrick());
		
		ph = new PokerHand(D3, D5, C5, CA, C4);
		assertEquals(Trick.Pair, ph.getTrick());
		
		ph = new PokerHand(D3, C3, C5, H5, C4);
		assertTrue(ph.getTrick() != Trick.Pair);
	}
	
	@Test
	public void testPairCompare() {
		PokerHand ph1 = new PokerHand(S2, HK, SK, S3, S4);
		PokerHand ph2 = new PokerHand(SA, HJ, SJ, S5, CQ);
		assertEquals(ph1.getTrick(), ph2.getTrick());		
		assertTrue(ph1.compareTo(ph2) > 0);
		
		ph1 = new PokerHand(S3, C3, HA, HQ, HJ);
		ph2 = new PokerHand(H3, D3, HK, SQ, S5);
		assertEquals(ph1.getTrick(), ph2.getTrick());
		assertTrue(ph1.compareTo(ph2) > 0);
		
		ph1 = new PokerHand(S3, C3, HA, HQ, HJ);
		ph2 = new PokerHand(D3, H3, SA, DQ, H10);
		assertEquals(ph1.getTrick(), ph2.getTrick());
		assertTrue(ph1.compareTo(ph2) > 0);
	}
	
	@Test
	public void testTwoPairs() {
		PokerHand ph = new PokerHand(S3, D3, D4, C4, C5);
		assertEquals(Trick.TwoPair, ph.getTrick());
		
		ph = new PokerHand(S2, C2, HK, SK, SA);
		assertEquals(Trick.TwoPair, ph.getTrick());
		
		ph = new PokerHand(D3, S3, C3, HJ, SJ);
		assertTrue(ph.getTrick() != Trick.TwoPair);
	}

	
	@Test
	public void testTwoPairsCompare() {
		PokerHand ph1 = new PokerHand(S3, D3, C5, D5, HK);
		PokerHand ph2 = new PokerHand(H3, C3, S5, H5, HA);		
		assertEquals(ph1.getTrick(), ph2.getTrick());
		assertTrue(ph2.compareTo(ph1) > 0);
		
		ph1 = new PokerHand(H6, D6, HA, SA, S2);
		ph2 = new PokerHand(HK, SK, HQ, SQ, S3);		
		assertEquals(ph1.getTrick(), ph2.getTrick());
		assertTrue(ph1.compareTo(ph2) > 0);
		
		ph1 = new PokerHand(S4, D4, S5, D5, HK);
		ph2 = new PokerHand(C4, H4, H5, C5, HA);
		assertEquals(ph1.getTrick(), ph2.getTrick());
		assertTrue(ph1.compareTo(ph2) < 0);		
		
		ph1 = new PokerHand(S4, D4, S5, D5, HK);
		ph2 = new PokerHand(C2, H2, H5, C5, HA);
		assertEquals(ph1.getTrick(), ph2.getTrick());
		assertTrue(ph1.compareTo(ph2) > 0);	
	}
	
	@Test
	public void testThreeKind() {
		PokerHand ph = new PokerHand(S8, D8, C8, HJ, HK);
		assertEquals(Trick.ThreeOfAKind, ph.getTrick());
		
	}
	
	@Test
	public void testThreeKindCompare() {
		PokerHand ph1 = new PokerHand(S9, D9, H9, HQ, HK);
		PokerHand ph2 = new PokerHand(S8, D8, H8, HA, H2);
		assertEquals(Trick.ThreeOfAKind, ph1.getTrick());
		assertTrue(ph1.compareTo(ph2) > 0);
		
		ph1 = new PokerHand(SQ, CQ, C5, D2, HQ);
		ph2 = new PokerHand(S2, C2, C4, D5, H2);
		assertEquals(Trick.ThreeOfAKind, ph1.getTrick());
		assertTrue(ph1.compareTo(ph2) > 0);
	}
	
	@Test
	public void testStraight() {
		PokerHand ph = new PokerHand(SA, S2, C3, D4, S5);
		assertEquals(Trick.Straight, ph.getTrick());
	}
	
	@Test
	public void testStraightCompare() {
		PokerHand ph1 = new PokerHand(SA, S2, C3, H4, S5);
		PokerHand ph2 = new PokerHand(D3, D4, D5, S6, D7);
		assertEquals(Trick.Straight, ph1.getTrick());
		assertTrue(ph2.compareTo(ph1) > 0);
		
		ph1 = new PokerHand(HA, SK, DQ, HJ, D10);
		ph2 = new PokerHand(SA, H3, D2, S4, H5);
		assertEquals(Trick.Straight, ph1.getTrick());
		assertTrue(ph1.compareTo(ph2) > 0);
				
	}
	
	@Test
	public void testFlush() {
		PokerHand ph = new PokerHand(SA, S2, S5, S7, SK);
		assertEquals(Trick.Flush, ph.getTrick());
	}
	
	@Test
	public void testFlushCompare() {
		PokerHand ph1 = new PokerHand(SA, S2, S5, S7, S9);
		PokerHand ph2 = new PokerHand(HA, H2, H5, H7, H10);
		assertEquals(Trick.Flush, ph1.getTrick());
		assertTrue(ph2.compareTo(ph1) > 0);		
		assertTrue(ph1.compareTo(ph2) < 0);
	}
	
	@Test
	public void testFullHouse() {
		PokerHand ph = new PokerHand(S7, C7, D7, HA, CA);
		assertEquals(Trick.FullHouse, ph.getTrick());
	}
	
	@Test
	public void testFullHouseCompare() {
		PokerHand ph1 = new PokerHand(SA, CA, HA, S2, D2);
		PokerHand ph2 = new PokerHand(S3, D3, SK, CK, HK);
		assertEquals(Trick.FullHouse, ph1.getTrick());
		assertTrue(ph1.compareTo(ph2) > 0);
	}
	
	@Test
	public void testFourKind() {
		PokerHand ph1 = new PokerHand(HA, CA, SA, DA, HK);
		PokerHand ph2 = new PokerHand(SQ, HQ, CQ, DQ, CK);
		assertEquals(Trick.FourOfAKind, ph1.getTrick());
		assertTrue(ph1.compareTo(ph2) > 0);
		assertTrue(ph2.compareTo(ph1) < 0);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	}
	
	@Test
	public void testStraightFlush() {
		PokerHand ph = new PokerHand(C2, C3, C4, C5, C6);
		assertEquals(Trick.StraightFlush, ph.getTrick());
	}
	
	@Test
	public void testStraightFlushCompare() {
		PokerHand ph1 = new PokerHand(SA, SQ, SK, SJ, S10);
		PokerHand ph2 = new PokerHand(C2, C3, C5, C4, CA);
		assertTrue(ph1.compareTo(ph2) > 0);
	}
	
	@Test
	public void testVariousHands() {
		PokerHand ph1 = new PokerHand(HQ, SQ, CQ, SA, C2);
		PokerHand ph2 = new PokerHand(HK, CK, C3, S5, D7);
		assertTrue(ph1.compareTo(ph2) > 0);
		
	}
	
	@Test
	public void testTrick() {
		assertEquals(Trick.Nothing.toString(), "Nothing");
	}
	

}
