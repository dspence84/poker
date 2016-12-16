import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	public static void main(String[] args) {
		List<Player> players = new ArrayList<Player>();			// a list of players in the game
		List<Player> winners;									// the winners of the game
		PokerHand dealer;										// the dealers hand of cards
		String input;											// input from the console
		Deck deck;												// the deck of cards to use
		final double playerStartingCash = 100.0; 				// the amount of starting cash for each player
		final double betSize = 2.00;							// the bet size for each player
		
		// build the deck
		deck = new Deck();
		deck.build52CardDeck();
		
		// create an input and output stream for our game
		Scanner in = new Scanner(System.in);
		PrintStream out = System.out;
				
		out.print("How many players? ");
		int numPlayers = in.nextInt();
		
		for(int i = 0; i < numPlayers; i++) {			
			players.add(new Player(i + 1, playerStartingCash));
		}
		
		do {			
			// shuffle the deck
			deck.Shuffle();		
			
			// deal out the community cards and print them out
			dealer = new PokerHand(deck.dealFive());				
			out.println("\nCommunity Cards: " + dealer);
			out.println("++++++++++++++++++++++++++++++++++++");
					
			// give each player two cards
			for(Player p : players) {
				p.receiveHand(deck.dealTwo());
			}
			
			players.sort(new ByPlayerNumberComparator());
		    for(Player player : players) {
		    	// combine the cards of the dealer and the current player to make allCards
		    	List<Card> allCards = dealer.getHand();
		    	allCards.addAll(player.getPlayerCards());
		    	
		    	// find the players best hand and make the player bet
		    	player.bet(betSize);
		    	player.findBestHand(allCards);
		    	
		    	// make a pretty console printout
		    	String playerCards = player.getPlayerCards().toString();
		    	out.printf("Player %2d: $%3.2f - %s\n", player.getPlayerNumber(), player.getCashOnHand(), playerCards.substring(1,playerCards.length() - 1));
		    	out.println("    Best Hand: " + player.getBestHand().toString() + " - " + player.getBestHand().getTrick());
		    	out.println();
		    }
		    
		    // sort the players by best hand to determine the winner(s)
		    winners = new ArrayList<Player>();
		    players.sort(new ByBestHandComparator());							    
		    PokerHand bestHand = players.get(0).getBestHand();		    
		    
		    // determine how many winners there are
		    for(Player player : players) {
		    	if(player.getBestHand().compareTo(bestHand) == 0) {
		    		winners.add(player);
		    	}
		    }
		    
		    // determine thePot size by how many winners there are
		    double thePot = betSize * players.size() / (double) winners.size();
		    
		    // pretty printout for the winner or winners
		    if(winners.size() > 1) {
		    	out.println("Winning hands (tie)");
		    	out.println("++++++++++++++++++++++++++++++++++++");
		    	for(Player winner : winners) {
		    		winner.collectThePot(thePot);
			    	out.printf("%s - %s - Player %2d $%.2f\n", winner.getBestHand(), winner.getBestHand().getTrick(), 
			    			winner.getPlayerNumber(), winner.getCashOnHand());
			    				    	
			    }
		    	
		    } else {
		    	Player winner = winners.get(0);
		    	winner.collectThePot(thePot);
		    	out.printf("Winner: Player %d $%.2f\n", winner.getPlayerNumber(), winner.getCashOnHand());
		    	out.println("++++++++++++++++++++++++++++++++++++");
		    	out.println("   " + winner.getBestHand().getTrick() + " " + winner.getBestHand());
		    }
		    		
		    // finally, ask the user if they would like to play another round
		    out.print("\nPlay another round? y | n: ");
		    input = in.next();
		} while(input.equals("y"));
    
		in.close();
	}
	
}
