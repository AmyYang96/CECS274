import java.io.*;
import java.util.Scanner;

/**
 * This class represents a LinkedList of songs
 * @author Amy Yang
 *
 */
public class LinkedList 
{
	/**
	 * first song of the list
	 */
	private Song first;
	
	/**
	 * Last song of the list
	 */
	private Song last;
	
	/**
	 * This constructor constructs a list with the first and last song to be null
	 */
	public LinkedList() 
	{
		first = null;
		last = null;
	}
	
	/**
	 * Read songs from file line by line into a song
	 */
	public void  readSongsFromFile ()
	{
		try
		{
			Scanner read=new Scanner(new File("Songs.txt"));
			
			do
			{		
				String line = read.nextLine();
				String [] tokens = line.split(","); //use commas to split up the data in the line
				
				Song song = new Song(tokens[0], tokens[1], tokens[2], tokens[3] ); // input data in constructor
				
				
					addSort(song);
			}while(read.hasNextLine());
				
			read.close();
		} 
		catch(FileNotFoundException fnf){
		
			System.out.println("File was not found");
		}
	}
	
	/**+
	 * This method determines if the list empty 
	 * @returns true if empty and false if it's not
	 */
	public boolean isEmpty() 
	{
		return first == null;
	}
	
	/**
	 * This method returns how many songs there are
	 * @return the number of songs
	 */
	public int size() 
	{
		int count = 0;
		Song p = first;
		while( p != null ) 
		{
			count++;
			p = p.getNext();
		}
		
		return count;
	}
	
	/**
	 * This method gets a song from the list
	 * @param i the index of the song
	 * @return the song
	 */
	public Song get( int i ) 
	{
		Song prev = first;
		
		for(int j=1; j<=i; j++) 
		{
			prev = prev.getNext();
		}
		
		return prev;
	}
	
	/**
	 * This method prints the list of songs
	 */
	public String toString() 
	{
		String str = "";
		Song n = first;
		int index = 1;
		
		while( n != null ) 
		{
			str = str + index + ". " + n.toString() + "\n";
			n = n.getNext();
			index++;
		}
		return str;
	}
	
	/**
	 * This method adds a new song to the list.
	 * @param s new soong to be added
	 */
	public void add( Song s ) 
	{
		if( isEmpty() ) 
		{
			first = s;
			last = first;
		} 
		else 
		{
			Song n = s;
			last.setNext( n );
			last = n;
		}
	}
	
	/**
	 * Adds a new song at a particular index
	 * @param s the new song to be added
	 * @param i the index where the song will be added
	 */
	public void add( Song s, int i ) 
	{
		if( i < 0 || i > size() ) 
		{
			System.out.println("Index out of bounds.");
		} 
		else 
		{
			if( i == 0 )
			{
				first = new Song( s.getTitle(), s.getArtist(),s.getAlbum(), s.getLength() );
				if( last == null )
				{
					last = first;
				}
			} 
			else 
			{
				Song prev = get( i - 1 );
				prev.setNext( new Song( s.getTitle(), s.getArtist(),s.getAlbum(), s.getLength(), prev.getNext()) );
				if( prev.getNext().getNext() == null ) 
				{
					last = prev.getNext();
				}
			}
		}
	} 
	/**
	 * This method searches for a song title
	 * @param song title of the song
	 */
	public void searchSong (String song)
	{
		boolean songFound = false;
		Song p = first;
		
		while (p!=null)
		{
			if( p.getTitle().equalsIgnoreCase(song) )
			{
				songFound = true;
				System.out.println("The song was found. The title is \"" + p.getTitle()+"\". ");
				break;
			}
			
			p = p.getNext();
		}
		
		if (songFound == false)
		{
			System.out.println("The song was not found.");
		}
	}
	
	/**
	 * Adds a song in a sorted order by artist, then by title if there are songs with the same artist
	 * @param song new song to be added
	 */
	public void addSort(Song song)
	{
		if(first == null)
		{
			add(song); 
		}
		else
		{
			int biggest =0;
			Song nextSong = get(0);
			while(nextSong != null)
			{
				
				if (song.compareTo(nextSong) > 0)
				{
					biggest++; //count index
					
				}
				nextSong = nextSong.getNext();
			}
			add(song,biggest); 
		}
	}
	
	/**
	 * This method searches for an artist and prints all the songs by the artist
	 * @param artist artist to be searched
	 */
	public void searchArtist (String artist)
	{
		boolean artistFound = false;
		Song p = first;
		
		while (p!=null)
		{
			if( p.getArtist().equalsIgnoreCase(artist) )
			{
				artistFound = true;
				System.out.println("The songs by this artist are:");
				System.out.println(p.getTitle());
				
			}
			
			p = p.getNext();
		}
		
		if (artistFound == false)
		{
			System.out.println("The artist was not found.");
		}
	}
	
	/**
	 * This method searches for an album and prints all the songs in the album
	 * @param album album to be searched
	 */
	public void searchAlbum (String album)
	{
		boolean albumFound = false;
		Song p = first;
		
		while (p!=null)
		{
			if( p.getAlbum().equalsIgnoreCase(album) )
			{
				albumFound = true;
				System.out.println("The songs in this album are:");
				System.out.println(p.getTitle());
				
			}
			
			p = p.getNext();
		}
		
		if (albumFound == false)
		{
			System.out.println("The album was not found.");
		}
	}
	
	/**
	 * This method searches for an index and displays the song title at that index
	 * @param index index to be searched
	 */
	public void searchIndex (int index)
	{
		if (index >= size() || index < 0)
		{
			System.out.println("Index is out of bounds.");
		}
		else
		{
			System.out.println("The song at index " + (index+1) + " is " + get(index).getTitle() );
		}
	}
	
	/**
	 * This method removes a song by index and returns the previous song to close gap
	 * @param i index of the song
	 * @return the previous song
	 */
	public Song remove( int i ) 
	{
		Song n = null;
		i = i-1;
		if( i < 0 || i >= size() ) 
		{
			System.out.println("Index out of bounds.");
		} 
		else 
		{
			if( i == 0 ) 
			{
				n = first;
				first = first.getNext();
				
				if( first == null )
				{
					last = null;
				}
			} 
			else 
			{
				Song prev = get( i - 1 );
				n = prev.getNext();
				prev.setNext( prev.getNext().getNext() );
				
				if( prev.getNext() == null ) 
				{
					last = prev;
				}
			}
		}
		
		return n;
	}
	
	/**
	 * This method searches for a title and removes the song
	 * @param songTitle title of the song to be removed
	 * @return the deleted song
	 */
	public Song remove( String songTitle ) 
	{
		Song n = null;
		
		if( !isEmpty() ) 
		{
			if( songTitle.equals( first.getTitle() ) ) 
			{
				n = first;
				first = first.getNext();
				
				if( first == null ) 
				{
					last = null;
				}
			}
			else 
			{
				Song prev = first;
				while( prev.getNext() != null &&
				!prev.getNext().getTitle().equals(songTitle) ) 
				{
					prev = prev.getNext();
				}
				
				if( prev.getNext() == null )
				{
					n = null;
					System.out.println("Does not exist");
				} 
				else 
				{
					n = prev.getNext();
					prev.setNext( prev.getNext().getNext() );
					
					if( prev.getNext() == null ) 
					{
						last = prev;
					}
				}
			}
		}
		return n;
	}
	
	/**
	 * Uses the selection sort to sort by title alphabetically
	 * @param songsList the LinkedList to be sorted
	 * @return sorted list
	 */
	public void selectionSortTitle() 
	{		
		for( int i = 0; i < size(); i++ ) 
		{
			int lowest = i;
			for( int j = i + 1; j <= size(); j++ ) 
			{
				if( get(j) != null && get( j ).getTitle().compareTo(get( lowest ).getTitle()) < 0) 
				{
					lowest = j;
				}
			}
			
			//swap
			Song tempSong = new Song (get(i).getTitle(), get(i).getArtist(), get(i).getAlbum(), get(i).getLength());
			get(i).setTitle( get(lowest).getTitle() );
			get(i).setArtist( get(lowest).getArtist() );
			get(i).setAlbum( get(lowest).getAlbum() );
			get(i).setLength( get(lowest).getLength() );
			
			get(lowest).setTitle( tempSong.getTitle() );
			get(lowest).setArtist( tempSong.getArtist() );
			get(lowest).setAlbum( tempSong.getAlbum() );
			get(lowest).setLength( tempSong.getLength() );
		}
	}
	
	/**
	 * Copies a linked list 
	 * @param list Linked list to be copied
	 * @return duplicate list
	 */
	public LinkedList copy (LinkedList list)
	{
		LinkedList copy = new LinkedList ();
		
		Song p = list.get(0);
		
		while( p != null ) 
		{
			copy.add(new Song (p.getTitle(), p.getArtist(), p.getAlbum(), p.getLength()));
			p = p.getNext();
			
		
		}
		return copy;
	}
	
	/**
	 * Uses the selection sort to sort by album alphabetically
	 * @param songsList the LinkedList to be sorted
	 * @return sorted list
	 */
	public void selectionSortAlbum() 
	{
		for( int i = 0; i < size(); i++ ) 
		{
			int lowest = i;
			for( int j = i + 1; j <= size(); j++ ) 
			{
				if( get(j) != null && get( j ).compareAlbum(get( lowest )) < 0) 
				{
					lowest = j;
				}
			}
			
			//swap
			Song tempSong = new Song (get(i).getTitle(), get(i).getArtist(), get(i).getAlbum(), get(i).getLength());
			get(i).setTitle( get(lowest).getTitle() );
			get(i).setArtist( get(lowest).getArtist() );
			get(i).setAlbum( get(lowest).getAlbum() );
			get(i).setLength( get(lowest).getLength() );
			
			get(lowest).setTitle( tempSong.getTitle() );
			get(lowest).setArtist( tempSong.getArtist() );
			get(lowest).setAlbum( tempSong.getAlbum() );
			get(lowest).setLength( tempSong.getLength() );
		}
	}
	
	/**
	 * Modifies a song by a specific part
	 */
	public void modifySong()
	{
		Scanner scan = new Scanner (System.in); 
		int index, choice;
		String modify;
		System.out.println("Please enter an index of a song you want to modify. ");
		index = UserInput.getInt();
		
		while (index <0 || index > size())
		{
			System.out.println("Invalid entry. Please enter an index of a song you want to modify. ");
			index = UserInput.getInt();
		}
		
		
		System.out.println("Please choose the part of a song you want to modify. ");
		System.out.println("1. Title\n2.Artist\n3.Album4.Length");
		choice = UserInput.getInt();
		
		while( choice <= 0 || choice > 4 )
		{
			System.out.println("Invalid entry. Please choose the part of a song you want to modify. ");
			System.out.println("1. Title\n2.Artist\n3.Album\n4.Length");
			choice = UserInput.getInt();
		}
		
		index = index - 1;
		
		if( choice == 1) // modify title
		{
			System.out.println("Please enter a new title: ");
			modify = scan.nextLine();
			get(index).setTitle(modify);
		}
		
		if( choice == 2) // modify artist
		{
			System.out.println("Please enter a new artist: ");
			modify = scan.nextLine();
			
			Song newSong = new Song(get(index).getTitle(), modify, get(index).getAlbum(), get(index).getLength());
			index = index + 1;
			remove(index);
			addSort(newSong);
			
		}
		
		if( choice == 3) // modify album
		{
			System.out.println("Please enter a new album: ");
			modify = scan.nextLine();
			get(index).setAlbum(modify);
		}
		
		if( choice == 4) // modify length
		{
			System.out.println("Please enter a new length: ");
			modify = scan.nextLine();
			get(index).setLength(modify);
		}
	}
	
}