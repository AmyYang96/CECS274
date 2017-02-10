import java.util.*;

/**
 * This class contains main that runs the game of War. The user and the computer play against each other.
 * @author Amy Yang
 */
public class WarGame {

	public static void main ( String[] args )
	{
		Scanner in = new Scanner(System.in);
		String input;
		
		ArrayList <Integer> deck = new ArrayList <Integer> ();
		ArrayList <Integer> player1Deck = new ArrayList <Integer> ();
		ArrayList <Integer> player2Deck = new ArrayList <Integer> ();
		
		War game = new War ();
		
		int playerWinCount = 0, totalGames =0; //counters
		double playerPercentage;
		
		//create and shuffle deck
		game.createDeck(deck);
		game.shuffleDeck(deck);
		
		//split deck to each player
		player1Deck = game.splitDeck(deck, 0);
		player2Deck = game.splitDeck(deck, 26);
	

		System.out.println( "Welcome to the game of War!\n" );
		game.displayMenu();
		input = in.nextLine();
		
		//check for invalid input
		while(!game.checkInput(input))
		{
			System.out.println( "Invalid input. Please enter a function: "  );
			input = in.nextLine();
		}
		
		//valid input
		while(game.checkInput(input) && !input.equals("5") && ((player1Deck.size() > 0) || (player2Deck.size() > 0)))
		{
			if( input.equalsIgnoreCase("1") ) //plays a round of battle
			{
				if(game.battle(player1Deck, player2Deck)) //if player wins, count that win
				{
					playerWinCount++;
				}
				totalGames++; //count each round
			}
			
			if( input.equalsIgnoreCase("2") ) //show score of each player
			{
				System.out.println( "Player's score:" + player1Deck.size() );
				System.out.println( "Computer's score:" + player2Deck.size() );
			}
			
			if( input.equalsIgnoreCase("3") ) //shows the sorted ArrayList of each player's deck
			{
				System.out.println( "Player's deck: " + game.sortDeck(player1Deck)  );
				System.out.println( "Computer's deck: " + game.sortDeck(player2Deck)  );
			}
			
			if( input.equalsIgnoreCase("4") ) // calculate player's win percentage
			{
			
				
				if(totalGames == 0) //check for division by 0
				{
					System.out.println( "Could not calculate percentage because no battles have been played.\n" );
				}
				else
				{
					playerPercentage = game.calcPercentage(playerWinCount, totalGames);
					System.out.println( "Player's win percentage: " + playerPercentage + "%" );
				}
			}
			
			//show menu again and ask for input
			game.displayMenu();
			input = in.nextLine();
			
			//check for invalid input
			while(!game.checkInput(input))
			{
				System.out.println( "Invalid input. Please enter a function: "  );
				input = in.nextLine();
			}
		}
		
		//determines who wins
		if( player1Deck.size() > player2Deck.size() )
		{
			System.out.println("Player wins!");
		}
		else if ( player1Deck.size() < player2Deck.size() )
		{
			System.out.println("Computer wins!");
		}
		else
		{
			System.out.println("Computer and Player are tied!");
		}
	}
}

