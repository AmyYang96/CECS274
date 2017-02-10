import java.util.*;

/**
 * This class runs the trivia game
 * @author Amy Yang
 *
 */
public class TriviaGame 
{

	public static void main(String[] args) 
	{
		
		Scanner in = new Scanner(System.in);
		
		ArrayList <Category> categories = new ArrayList <Category> ();
		
		Category harryPotter = new Category("HarryPotter");
		Category starWars =  new Category ("StarWars");
		Category adventureTime = new Category ("AdventureTime");
		
		String category, action;
		int categoryNum, questionNum;
		
		//add categories to ArrayList.
		categories.add(adventureTime);
		categories.add(harryPotter);
		categories.add(starWars);
		
		System.out.println("Welcome to the Trivia Game!");
		
		System.out.println("Please choose a category:");
	
		//print category list
		for(int i =0; i <categories.size(); i++)
		{
			System.out.println( (i+1) + ". " + categories.get(i).getName() );
		}

		System.out.println("4. Quit");
		category = in.nextLine();
		
		//checks input
		while( !( category.equalsIgnoreCase("1") || category.equalsIgnoreCase("2") || category.equalsIgnoreCase("3") || category.equalsIgnoreCase("4") ) )
		{
			System.out.println("Invalid entry. Enter again:");
			category = in.nextLine();
		}
		
		
		while ( category.equalsIgnoreCase("1") || category.equalsIgnoreCase("2") || category.equalsIgnoreCase("3")) //category menu
		{
			categoryNum = Integer.parseInt(category) - 1; //index for categories ArrayList
			
			displayMenu();
			action = in.nextLine();
			
			
			//checks input
			while( !( action.equalsIgnoreCase("1") || action.equalsIgnoreCase("2") || action.equalsIgnoreCase("3") || action.equalsIgnoreCase("4")) )
			{
				System.out.println("Invalid entry. Enter again:");
				action = in.nextLine();
			}
			
			
			//specific category - take quiz & modify/add questions
			while( action.equalsIgnoreCase("1") || action.equalsIgnoreCase("2") || action.equalsIgnoreCase("3") )
			{
				if(action.equalsIgnoreCase("1")) //take quiz
				{
					categories.get(categoryNum).takeQuiz();
				}
				
				if( action.equalsIgnoreCase("2")) //modify question
				{
					boolean input= true; 
					categories.get(categoryNum).printQuestions();
					
					
					while(input)
					{
						try
						{
							System.out.println("Select a question to modify:");
							questionNum = in.nextInt();
							
							// check the number
							while (questionNum > categories.get(categoryNum).getSize())
							{
								System.out.println("Question could not be found. Enter again.");
								questionNum = in.nextInt();
							}
							
							categories.get(categoryNum).modifyQuestion(questionNum); // modify question
							
							input = false;
						}
						catch( InputMismatchException im ) 
						{
							in.nextLine(); //clear buffer
							System.out.println("Invalid Input");
						}
					}
				}
				
				if ( action.equalsIgnoreCase("3")) // add question
				{
					categories.get(categoryNum).addQuestion();
				}
				
				
				displayMenu();
				action = in.nextLine();
				
				//checks input
				while( !( action.equalsIgnoreCase("1") || action.equalsIgnoreCase("2") || action.equalsIgnoreCase("3") || action.equalsIgnoreCase("4") ) )
				{
					System.out.println("Invalid entry. Enter again:");
					action = in.nextLine();
				}
			}
			
			System.out.println("\nPlease choose a category:");
			//print category list
			for(int i =0; i <categories.size(); i++)
			{
				System.out.println( (i+1) + ". " + categories.get(i).getName() );
			}

			System.out.println("4. Quit");
			category = in.nextLine();
			
			//checks input
			while( !( category.equalsIgnoreCase("1") || category.equalsIgnoreCase("2") || category.equalsIgnoreCase("3") || category.equalsIgnoreCase("4") ) )
			{
				System.out.println("Invalid entry. Enter again:");
				category = in.nextLine();
			}
			
		}
		
		//write each category back to file
		for(int i=0; i<categories.size(); i++)
		{
			categories.get(i).writeList();
		}
	}

	/**
	 * This method displays the submenu.
	 */
	public static void displayMenu()
	{
		System.out.println("\nPlease choose an action:");
		System.out.println("1. Take quiz");
		System.out.println("2. Modify question");
		System.out.println("3. Add question");
		System.out.println("4. New Category");
	}
}
