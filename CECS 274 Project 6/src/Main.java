import java.io.*;
import java.util.*;

/**
 * This is the main class for the movie database
 * @author Amy Yang
 *
 */
public class Main 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner (System.in);
		int action;
		BST tree = new BST ();
		ArrayList <Movie> treeCopy = new ArrayList <Movie> ();
		tree = readFile(tree);
		treeCopy = readFile(treeCopy);
		menu();
		action = UserInput.getInt();
		
		while (action < 1 || action > 11)
		{
			System.out.println("Invalid entry.\n");
			menu();
			action = UserInput.getInt();
		}
		
		while (action >=1 && action < 11)
		{
			if ( action == 1 ) //add new movie
			{
				String title, actor, rating, choice;
				int year, length;
				double stars;
				ArrayList <String> actors = new ArrayList <String>();
				
				System.out.println("Enter a movie title: ");
				title = scan.nextLine();
				
				System.out.println("Do you want to enter the released year? (Y/N) ");
				choice = scan.nextLine();
				while ( !(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")))
				{
					System.out.println("Invalid. Try again. Y or N? ");
					choice = scan.nextLine();
				}
				if ( choice.equalsIgnoreCase("Y") )
				{
					System.out.println("Enter released year: ");
					year = UserInput.getInt();
				}
				else
				{
					year = 0;
				}
				
				System.out.println("Do you want to enter the rating? (Y/N) ");
				choice = scan.nextLine();
				while ( !(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")))
				{
					System.out.println("Invalid. Try again. Y or N? ");
					choice = scan.nextLine();
				}
				if ( choice.equalsIgnoreCase("Y") )
				{
					System.out.println("Enter movie rating: ");
					rating = scan.nextLine();
				}
				else
				{
					rating = "0";
				}
				
				System.out.println("Do you want to enter the length of the movie? (Y/N) ");
				choice = scan.nextLine();
				while ( !(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")))
				{
					System.out.println("Invalid. Try again. Y or N? ");
					choice = scan.nextLine();
				}
				if ( choice.equalsIgnoreCase("Y") )
				{
					System.out.println("Enter movie length: ");
					length = UserInput.getInt();
				}
				else
				{
					length = 0;
				}
				
				System.out.println("Do you want to enter the audience rating? (Y/N) ");
				choice = scan.nextLine();
				while ( !(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")))
				{
					System.out.println("Invalid. Try again. Y or N? ");
					choice = scan.nextLine();
				}
				if ( choice.equalsIgnoreCase("Y") )
				{
					System.out.println("Enter the number of stars: ");
					stars = UserInput.getDecimal();
				}
				else
				{
					stars = 0.0;				
				}
				
				System.out.println("Do you want to enter the list of actors? (Y/N) ");
				choice = scan.nextLine();
				while ( !(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")))
				{
					System.out.println("Invalid. Try again. Y or N? ");
					choice = scan.nextLine();
				}
				if ( choice.equalsIgnoreCase("Y") )
				{
					int numActors;
					System.out.println("Enter how many actors you want to enter: ");
					numActors = UserInput.getInt();
					
					while ( numActors <= 0)
					{
						System.out.println("Invalid. Enter how many actors you want to enter: ");
						numActors = UserInput.getInt();
					}
					
					for( int i=0; i< numActors; i++)
					{
						System.out.println("Enter the actor's name: ");
						actor = scan.nextLine();
						actors.add(actor);
					}
				}
				else
				{
					actors.set(0, " ");
				}
				
				Movie movie = new Movie( title, year, rating, length, stars, actors);
				tree.add(movie);
				treeCopy.add(movie);
			}
			
			if ( action == 2 ) // delete movie
			{
				String title;
				System.out.println("Enter a movie title to delete: ");
				title = scan.nextLine();
				tree.remove(title);
				
				for (int i = 0; i < treeCopy.size(); i++)
				{
					if (treeCopy.get(i).getTitle().compareTo(title) == 0)
					{
						treeCopy.remove(i);
					}
				}
			}
			
			if ( action == 3 ) // add actor to movie
			{
				String movie, name;
				System.out.println("Enter a movie title: ");
				movie = scan.nextLine();
				
				System.out.println("Enter an actor to add: ");
				name = scan.nextLine();
				tree.addActor(movie, name);
				
				for(int i=8; i < treeCopy.size(); i++)
				{
					if( treeCopy.get(i).getTitle().compareToIgnoreCase(movie) == 0)
					{
						if ( treeCopy.get(i).getActorsList().get(0).compareTo(" ") == 0)
						{
							treeCopy.get(i).getActorsList().set(0, name);
						}
						else
						{
							treeCopy.get(i).getActorsList().add(name);
						}
					}
				}
			}
			
			if ( action == 4 ) // delete actor from movie
			{
			
				String movie, name;
				System.out.println("Enter a movie title: ");
				movie = scan.nextLine();
				
				System.out.println("Enter an actor to delete: ");
				name = scan.nextLine();
				tree.deleteActor(movie, name);
				
				for(int i=8; i < treeCopy.size(); i++)
				{
					if( treeCopy.get(i).getTitle().compareToIgnoreCase(movie) == 0)
					{
						if ( treeCopy.get(i).getActorsList().size()== 1 && treeCopy.get(i).getActorsList().get(0).compareTo(name) == 0)
						{
							treeCopy.get(i).getActorsList().set(0, " ");
						}
						else
						{
							treeCopy.get(i).getActorsList().remove(name);
						}
					}
				}
			}
			
			if ( action == 5 ) // display movies
			{
				tree.printBST();
			}
			
			if ( action == 6 ) // Search movies by title
			{
				String title;
				System.out.println("Enter a movie title to search: ");
				title = scan.nextLine();
				Node n = tree.searchTitle(title);
				
				if(n != null)
				{
					System.out.println("Movie was found.\n" + n.getData() + "\n");
				}
			}
			
			if ( action == 7 ) // Search movies by rating
			{
				BST rating = new BST ();
				int choice;
				System.out.println("Choose a rating: \n1. G\n2. PG\n3. PG-13\n4. R\n5. NC-17");
				choice = UserInput.getInt();
				
				while (choice < 1 || choice > 5)
				{
					System.out.println("Invalid. Choose a rating: \n1. G\n2. PG\n3. PG-13\n4. R\n5. NC-17");
					choice = UserInput.getInt();
				}
				
				if (choice == 1)
				{
					rating = tree.searchRating("G");
					rating.printBST();
					System.out.println();
				}
				if (choice == 2)
				{
					rating = tree.searchRating("PG");
					rating.printBST();
					System.out.println();
				}
				if (choice == 3)
				{
					rating = tree.searchRating("PG-13");
					rating.printBST();
					System.out.println();
				}
				if (choice == 4)
				{
					rating = tree.searchRating("R");
					rating.printBST();
					System.out.println();
				}
				if (choice == 5)
				{
					rating = tree.searchRating("NC-17");
					rating.printBST();
					System.out.println();
				}
			}
			
			if ( action == 8 ) // Search movies by decade
			{
				BST decad = new BST();
				int decade;
				System.out.println("Enter a decade to search: ");
				decade = UserInput.getInt();
				
				while ( decade % 10 != 0)
				{
					System.out.println("Invalid entry. Entry is not a decade. Enter a decade to search: ");
					decade = UserInput.getInt();
				}
				decad = tree.searchDecade(decade);
				decad.printBST();
				System.out.println();
			}
			
			if ( action == 9 ) // Search movies by stars
			{
				BST stars = new BST();
				double star;
				System.out.println("Enter a star rating to search: ");
				star = UserInput.getDecimal();
				
				while ( star < 1.0 || star > 10)
				{
					System.out.println("Invalid entry. Enter a star rating to search: ");
					star = UserInput.getDecimal();
				}
				stars = tree.searchStars(star);
				stars.printBST();
				System.out.println();
			}
			
			if ( action == 10 ) // Search movies by actor
			{
				BST actors = new BST ();
				String name;
				System.out.println("Enter an actor to search: ");
				name = scan.nextLine();
				
				actors = tree.searchActor(name);
				actors.printBST();
				System.out.println();
			}
			
			menu();
			action = UserInput.getInt();
			
			while (action < 1 || action > 11)
			{
				System.out.println("Invalid entry.\n");
				menu();
				action = UserInput.getInt();
			}
		}
		writeFile(treeCopy);
	}
	
	/**
	 * Populates BST from file
	 * @param tree BST of movies
	 * @return populated tree
	 */
	public static BST readFile (BST tree)
	{
		try
		{
			Scanner read=new Scanner(new File("movies.txt"));
			
			do
			{
				ArrayList <String> actorsList = new ArrayList <String> ();
				String [] actors = null;
				String line = read.nextLine();
				String [] tokens = line.split("/"); 
				
				if(tokens.length == 6)
				{
					actors = tokens[5].split(",");
				}
				
				
				if (actors != null)
				{
					for (int i =0; i < actors.length; i++)
					{
						actorsList.add(actors[i]);
					}
				}
				else
				{
					actorsList.add(0," ");
				}
				Movie m = new Movie(tokens[0], Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]), actorsList );
				
				tree.add(m);
				
			}while(read.hasNextLine());
				
			read.close();
		} 
		catch(FileNotFoundException fnf){
		
			System.out.println("File was not found");
		}
		return tree;
	}
	
	/**
	 * Populates ArrayList of movies  from file
	 * @param movieList ArrayLisr
	 * @return ArrayList of movies
	 */
	public static ArrayList <Movie> readFile (ArrayList <Movie> movieList)
	{
		try
		{
			Scanner read=new Scanner(new File("movies.txt"));
			
			do
			{
				ArrayList <String> actorsList = new ArrayList <String> ();
				String [] actors = null;
				String line = read.nextLine();
				String [] tokens = line.split("/"); 
				
				if(tokens.length == 6)
				{
					actors = tokens[5].split(",");
				}
				
				
				if (actors != null)
				{
					for (int i =0; i < actors.length; i++)
					{
						actorsList.add(actors[i]);
					}
				}
				else
				{
					actorsList.add(0," ");
				}
				Movie m = new Movie(tokens[0], Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]), actorsList );
				
				movieList.add(m);
				
			}while(read.hasNextLine());
				
			read.close();
		} 
		catch(FileNotFoundException fnf){
		
			System.out.println("File was not found");
		}
		return movieList;
	}

	/**
	 * Displays the main menu
	 */
	public static void menu()
	{
		System.out.println("Please select a function: ");
		System.out.println("1. Add a new movie");
		System.out.println("2. Delete a movie");
		System.out.println("3. Add an actor to a movie");
		System.out.println("4. Delete an actor from a movie");
		System.out.println("5. Display movies by title.");
		System.out.println("6. Search movies by title");
		System.out.println("7. Search movies by rating");
		System.out.println("8. Search movies by decade");
		System.out.println("9. Search movies by stars");
		System.out.println("10. Search movies by actor \n11. Quit");
		
	}
	
	/**
	 * Writes back to file
	 * @param treeCopy ArrayList
	 */
	public static void writeFile(ArrayList <Movie> treeCopy)
	{
		try
		{
			PrintWriter writer = new PrintWriter("movies.txt");
			
			for(int i = 0; i < treeCopy.size(); i++) // go through ArrayList
			{
				writer.print(treeCopy.get(i).getTitle() + "/" +
						treeCopy.get(i).getYear() + "/" +
						treeCopy.get(i).getRating() + "/" +
						treeCopy.get(i).getLength() + "/" +
						treeCopy.get(i).getStars() + "/");
				if (treeCopy.get(i).getActorsList().size() == 1)
				{
					writer.print(treeCopy.get(i).getActorsList().get(0));
				}	
				else
				{
					for ( int j = 0; j < treeCopy.get(i).getActorsList().size(); j++)
					{
						writer.print(treeCopy.get(i).getActorsList().get(j) + ",");
					}
				}
				writer.println();
			}
			
			writer.close();
			
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("File was not found");
		}
	}
}
