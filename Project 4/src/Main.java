import java.io.*;
import java.util.*;

/**
 * This class allows the user to interact with a song list through main
 * @author Amy Yang
 *
 */
public class Main 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		int action;
		LinkedList list = new LinkedList();
		list.readSongsFromFile();
		
		
		displayMenu();
		action = UserInput.getInt();
		
		while (action <=0 || action > 13)
		{
			System.out.println("Invalid entry. Please try again.");
			displayMenu();
			action = UserInput.getInt();
		}
		
		while (action <= 12)
		{
			if (action == 1) //search for title
			{
				String title;
				
				System.out.println("Please enter a song title that you want to search: ");
				title = scan.nextLine();
				
				list.searchSong(title);
			}
			
			if (action == 2) // search for artist
			{
				String artist;
				
				System.out.println("Please enter a song artist that you want to search: ");
				artist = scan.nextLine();
				
				list.searchArtist(artist);
			}
			
			if (action == 3) //Search for album
			{
				String album;
				
				System.out.println("Please enter an album that you want to search: ");
				album = scan.nextLine();
				
				list.searchAlbum(album);
			}
			
			if (action == 4) //search a song by index
			{
				int index;
				
				System.out.println("Please enter an index of a song: ");
				index = scan.nextInt();
				
				list.searchIndex(index-1);
				
			}
			
			if (action == 5) //add song
			{
				String title, artist, album, length;
				
				System.out.println("Please enter a title:");
				title = scan.nextLine();
				
				System.out.println("Please enter an artist:");
				artist= scan.nextLine();
				
				System.out.println("Please enter an album:");
				album = scan.nextLine();
				
				System.out.println("Please enter the length:");
				length = scan.nextLine();
				
				Song newSong = new Song(title, artist, album, length);
				
				list.addSort(newSong);
				System.out.println(list.toString());
			}
			
			if (action == 6) //remove a song by title
			{
				String title;
				
				System.out.println("Please enter a song title that you want to remove: ");
				title = scan.nextLine();
				
				System.out.println("Removed:" +list.remove(title).toString());
			}
			
			if (action == 7) // remove by index
			{
				int index;
				
				System.out.println("Please enter an index of a song that you want to remove: ");
				index = scan.nextInt();
				
				System.out.println("Removed:" +list.remove(index).toString());
			}
			
			if (action == 8) //size
			{
				System.out.println("There are " + list.size() + " songs in the list.");
			}
			
			if (action == 9) //print list
			{
				System.out.println(list.toString());
			}
			
			if (action == 10) // sort by title
			{
				LinkedList sortTitle = new LinkedList();
				sortTitle = sortTitle.copy(list);
				sortTitle.selectionSortTitle();
				System.out.println(sortTitle.toString());
				
			}
			
			if (action == 11) //sort by album
			{
				LinkedList sortAlbum = new LinkedList();
				sortAlbum = sortAlbum.copy(list);
				sortAlbum.selectionSortAlbum();
				System.out.println(sortAlbum.toString());
			}
			
			if (action == 12)
			{
				list.modifySong();
			}
			
			displayMenu();
			action = UserInput.getInt();
			
			while (action <=0 || action > 13)
			{
				System.out.println("Invalid entry. Please try again.");
				displayMenu();
				action = UserInput.getInt();
			}
		}// while (action <= 12)
		
		writeToFile(list);
	}

	/**
	 * Writes LinkedList back to File
	 * @param list list to be written back to file
	 */
	public static void writeToFile (LinkedList list)
	{
		try
		{
			PrintWriter writer = new PrintWriter("Songs.txt");
			
			Song p = list.get(0);
			while (p != null) // go through ArrayList
			{
				writer.println(p.getTitle() + "," + p.getArtist() + "," + p.getAlbum() + "," + p.getLength());
				p = p.getNext();
			}
			
			writer.close();
			
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("File was not found");
		}
	}
	
	/**
	 * Displays a menu of functions
	 */
	public static void displayMenu()
	{
		System.out.println("Please choose a function.");
		System.out.println("1. Search for a song title");
		System.out.println("2. Search for an artist");
		System.out.println("3. Search for an album");
		System.out.println("4. Search for a song by index");
		System.out.println("5. Add a song");
		System.out.println("6. Remove a song by title");
		System.out.println("7. Remove a song by index");
		System.out.println("8. Display the number of songs");
		System.out.println("9. Display the list of songs");
		System.out.println("10. Sort list by title");
		System.out.println("11. Sort list by album");
		System.out.println("12. Modify a song \n13. Quit");
	}
}
