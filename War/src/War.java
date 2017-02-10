import java.util.*;

/**
 * This class contains all the methods for the card game War!
 * @author Amy Yang
 *
 */
public class War {

	/**
	 * This method creates a card deck with 52 cards by storing integers 1-13 4 times in an ArrayList
	 * @param deck 		the ArrayList that contains 52 cards/integers
	 */
	public static void createDeck( ArrayList <Integer> deck )
	{
		for ( int i = 0; i < 4; i++ ) // adds #s 1-13 4 times
		{
			for( int j =0; j < 13; j++ )
			{
				deck.add(j+1);				
			}
		}
	}
	
	/**
	 * This method shuffles the card deck by randomly generating 2 indexes and swaps the elements 52 times
	 * @param deck		the ArrayList that contains 52 cards/integers
	 */
	public static void shuffleDeck ( ArrayList <Integer> deck )
	{
		Random generator = new Random();
		int index1, index2, temp;
		
		for( int i = 0; i < 53; i++ )
		{
			//generate random index locations
			index1 = generator.nextInt(52);
			index2 = generator.nextInt(52);
			
			//swap
			temp = deck.get(index1);
			deck.set(index1, deck.get(index2) );
			deck.set(index2, temp);
		}
	}
	
	/**
	 * This method splits the deck in half by copying half of its contents into another ArrayList
	 * @param deck			the ArrayList that contains 52 cards/integers
	 * @param startIndex	determines which half to copy the deck from
	 * @return halfDeck		returns half of the deck in an ArrayList
	 */
	public static ArrayList <Integer> splitDeck ( ArrayList <Integer> deck, int startIndex )
	{
		ArrayList <Integer> halfDeck = new ArrayList <Integer> ();
		
		//determines if it copies from the beginning of the deck or second half
		if ( startIndex == 0) //first half
		{
			for ( int i= startIndex; i < deck.size() / 2; i++ )
			{
				halfDeck.add(deck.get(i));
			}
		}
		
		if (startIndex == 26) //second half
		{
			for ( int i= startIndex; i < deck.size(); i++ )
			{
				halfDeck.add(deck.get(i));
			}
		}
		
		return halfDeck;
	}
	
	/**
	 * This method displays the main menu
	 */
	public static void displayMenu ()
	{
		System.out.println( "Please choose a function: " );
		System.out.println( "1. Play one round" );
		System.out.println( "2. Show Score" );
		System.out.println( "3. Peek at cards" );
		System.out.println( "4. Show Percentage" );
		System.out.println( "5. Quit" );
	}
	
	/**
	 * This method plays a round of battle and compares the top cards. It determines if the player won
	 * @param deck1		deck of cards from the first player
	 * @param deck2		deck of cards from the second player (computer)
	 * @return playerWin	boolean value: true if the player won, false otherwise
	 */
	public static boolean battle( ArrayList <Integer> deck1, ArrayList <Integer> deck2)
	{
		final int TOP = 0; //top card (first element in the ArrayList)
		
		int card1 = deck1.get(TOP), card2 = deck2.get(TOP); // get top cards
		
		boolean playerWin = false;
		//displays the cards played
		System.out.println(  "Player plays a " + card1 );
		System.out.println(  "Computer plays a " + card2);
		
		if( deck1.get(TOP) > deck2.get(TOP) ) // if player wins
		{
			System.out.println( "Player won a card." );
			
			// remove player's top card and place it and computer's card at the bottom of deck
			deck1.remove(TOP);
			deck1.add(card1);
			deck1.add(card2);
			deck2.remove(TOP); // remove computer's top card
			
			playerWin = true;
		}
		
		else if( deck1.get(TOP) < deck2.get(TOP) ) //if computer wins
		{
			System.out.println( "Computer won a card." );
			
			// remove computer's top card and place it and player's card at the bottom of deck
			deck2.remove(TOP);
			deck2.add(card2);
			deck2.add(card1);
			deck1.remove(TOP); // remove player's top card
			
		}
		
		else //if the top cards are equal there is war
		{
			if(war(deck1, deck2))
			{
				playerWin = true;
			}
		}
		return playerWin;
		
	}
	
	/**
	 * This method plays war if the top cards are equal. It determines if the player won
	 * @param deck1		deck of cards from the first player
	 * @param deck2		deck of cards from the second player (computer)
	 * @return playerWin	boolean value: true if the player won, false otherwise
	 */
	public static boolean war ( ArrayList <Integer> deck1, ArrayList <Integer> deck2)
	{
		Random generator = new Random();
		boolean playerWin = false;
		System.out.println( "The cards are equal. 1..2..3..War!" );
		
		
		if(  deck1.size() >= 4 && deck2.size() >= 4 )
		{
			if( deck1.get(1) > deck2.get(1) ) // if player wins
				{
					System.out.println( "Player won!" );
					
					// place player's played cards and computer's cards at the bottom of deck and remove player's played cards at top
					for(int i = 0; i < 4; i++)
					{
						deck1.add(deck1.get(i));
						deck1.remove(i);
						deck1.add(deck2.get(i));
						deck2.remove(i);
						playerWin = true;
					}
					
				}
				
			else if( deck1.get(1) < deck2.get(1) ) //if computer wins
				{
					System.out.println( "Computer won a card." );
					
					// place player's  cards and computer's played cards at the bottom of deck and remove computer's played cards at top
					for(int i = 0; i < 4; i++)
					{
						deck2.add(deck2.get(i));
						deck2.remove(i);
						deck2.add(deck1.get(i));
						deck1.remove(i);
					}
				}
			
		}
		else //second round of war begins and keeps looping if top cards are equal
		{
			int j=2;
			while ( deck1.size() >= 8 && deck2.size() >= 8 && (deck1.get(j) == deck2.get(j)) )
			{
				 if( deck1.get(j) > deck2.get(j) ) // if player wins
					{
						System.out.println( "Player won a card." );
						
						// place player's played cards and computer's cards at the bottom of deck and remove player's played cards at top
						for(int i = 0; i < 8; i++)
						{
							deck1.add(deck1.get(i));
							deck1.remove(i);
							deck1.add(deck2.get(i));
							deck2.remove(i);
							playerWin = true;
							break;
						}
					}
					
					if( deck1.get(j) < deck2.get(j) ) //if computer wins
					{
						System.out.println( "Computer won a card." );
						
						// place player's  cards and computer's played cards at the bottom of deck and remove computer's played cards at top
						for(int i = 0; i < 8; i++)
						{
							deck2.add(deck2.get(i));
							deck2.remove(i);
							deck2.add(deck1.get(i));
							deck1.remove(i);
							break;
						}
					}
				j++;
			}
		
		}
		return playerWin;
	}
	
	/**
	 * This method prints the number of cards from each player by getting the ArrayList size
	 * @param deck1		deck of cards from the first player
	 * @param deck2		deck of cards from the second player (computer)
	 */
	public static void displayScore ( ArrayList <Integer> deck1, ArrayList <Integer> deck2 )
	{
		int score1, score2;
		
		//get the size of ArrayLists
		score1 = deck1.size(); //player's score
		score2 = deck2.size(); //computer's score
		
		//print result
		System.out.println("Player's score: " + score1);
		System.out.println("Computer's score: " + score2);
	}
	
	/**
	 * This method sorts a player's deck by first copying it into another ArrayList and then using the Bubble Sort
	 * @param deck		the player's deck in an ArrayList that contains cards/integers
	 * @return sortedDeck	the player's sorted deck in an ArrayList
	 */
	public static ArrayList <Integer> sortDeck ( ArrayList <Integer> deck )
	{
		ArrayList <Integer> sortedDeck = new ArrayList <Integer> ();
		boolean swapped = false;
		
		//copy ArrayList
		for ( int i= 0; i < deck.size(); i++ )
		{
			sortedDeck.add(deck.get(i));
		}
		
		//sort using Bubble Sort
		do 
		{
			swapped = false;
			for( int i = 0; i < sortedDeck.size() - 1; i++ ) 
			{
				if( sortedDeck.get( i ) > sortedDeck.get( i + 1 ) ) 
				{
					int swap = sortedDeck.get( i );
					sortedDeck.set( i, sortedDeck.get( i + 1 ) );
					sortedDeck.set( i + 1, swap );
					swapped = true;
				}
			}
		} while( swapped );
		
		return sortedDeck;
	}
	
	/**
	 * This method prints the player's deck in an ArrayList
	 * @param deck	the player's deck in an ArrayList
	 */
	public static void displayDeck ( ArrayList <Integer> deck )
	{
		System.out.println( deck );
	}
	
	/**
	 * This method calculates the player's winning percentage
	 * @param wins			the number of player wins
	 * @param totalPlayed	the number of total rounds played
	 * @return percentage	the percentage of wins
	 * @throws ArithmeticException	avoids divide by 0 error
	 */
	public static double calcPercentage( int wins, int totalPlayed ) throws ArithmeticException
	{
		double w = (double) wins;
		double total = (double) totalPlayed;
		
		double percentage = (w / total) * 100; //calculate percentage
		
		return percentage;
	}
	
	/**
	 * This method checks if the input is valid.
	 * @param input		the string inputed by the user 
	 * @return			the boolean value the indicates the validity of the input
	 */
	public static boolean checkInput(String input)
	{
		boolean valid = true;
		
		//check if the input is 1,2,3,4, or 5
		if ( !(input.equalsIgnoreCase("1") || input.equalsIgnoreCase("2") || input.equalsIgnoreCase("3") ||
				input.equalsIgnoreCase("4") || input.equalsIgnoreCase("5")))
		{
			valid = false;
		}
		return valid;
	}
	
}
