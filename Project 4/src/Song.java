/**
 * This  class contains the methods for a Song. It is also a node for a LinkedList 
 * @author Amy Yang
 *
 */
public class Song 
{
	/**
	 * Represents title of the song
	 */
	private String title;
	
	/**
	 * Represents the singer's name
	 */
	private String artist;
	
	/**
	 * Represents the name of the album that the song is in
	 */
	private String album;
	
	/**
	 * Represents the duration of the song
	 */
	private String length;
	
	/**
	 * Represents the next song in the list
	 */
	private Song nextSong;
	
	/**
	 * This constructor constructs a Song object
	 * @param t title of the song
	 * @param singer song's artist
	 * @param a album
	 * @param l length of the song
	 */
	public Song (String t, String singer, String a, String l)
	{
		title = t;
		artist = singer;
		album = a;
		length = l;
	}
	
	/**
	 * This constructor constructs a Song object with the next song in the list
	 * @param t title of the song
	 * @param singer song's artist
	 * @param a album
	 * @param l length of the song
	 * @param s next song
	 */
	public Song (String t, String singer, String a, String l, Song s)
	{

		title = t;
		artist = singer;
		album = a;
		length = l;
		nextSong = s;
		
	}
	
	/**
	 * This method returns the title of the song
	 * @return title of the song
	 */
	public String getTitle ()
	{
		return title;
	}
	
	/**
	 * This method sets the title of the song
	 * @param name title of the song
	 */
	public void setTitle (String name)
	{
		title = name;
	}
	
	/**
	 * This method returns the artist of the song
	 * @return artist of the song
	 */
	public String getArtist ()
	{
		return artist;
	}
	
	/**
	 * This method sets the artist of the song
	 * @param name artist of the song
	 */
	public void setArtist (String name)
	{
		artist = name;
	}
	
	/**
	 * This method returns the album of the song
	 * @return album of the song
	 */
	public String getAlbum ()
	{
		return album;
	}
	
	/**
	 * This method sets the album of the song
	 * @param name album of the song
	 */
	public void setAlbum (String name)
	{
		album = name;
	}
	
	/**
	 * This method returns the length of the song
	 * @return length of the song
	 */
	public String getLength ()
	{
		return length;
	}
	
	/**
	 * This method sets the length of the song
	 * @param name length of the song
	 */
	public void setLength (String name)
	{
		length = name;
	}
	
	/**
	 * This method returns the next song in the list
	 * @return next song
	 */
	public Song getNext()
	{
		return nextSong;
	}
	
	/**
	 * This method sets the next song in the list
	 * @param n the next song in the list
	 */
	public void setNext (Song n)
	{
		nextSong = n;
	}
	
	/**
	 * Overrides to string method with song info
	 * @return a string with song info
	 */
	public String toString ()
	{
		String s;
		
		s = "Title: " + title + "\t\t\t\tArtist: " + artist + "\t\t\tAlbum: " + album + "\t\tLength: "
				+ length;
		return s;
	}
	
	/**
	 * This method compares 2 songs by artist. If the songs have the same artist, then it compares the 2 song titles
	 * @param song2 the song to be compared
	 * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or 
	 *             greater than the specified object.
	 */
	public int compareTo(Song song2)
	{
		if (getArtist().compareToIgnoreCase(song2.getArtist()) == 0)
		{
			return getTitle().compareToIgnoreCase(song2.getTitle());
		}
		else
		{
			return getArtist().compareToIgnoreCase(song2.getArtist());
		}
	}
	
	/**
	 * This method compares 2 songs by album. If the songs have the same artist, then it compares the 2 song titles
	 * @param song2 the song to be compared
	 * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or 
	 *             greater than the specified object.
	 */
	public int compareAlbum(Song song2)
	{
		if (getArtist().compareToIgnoreCase(song2.getArtist()) == 0)
		{
			return getTitle().compareToIgnoreCase(song2.getTitle());
		}
		else
		{
			return getAlbum().compareToIgnoreCase(song2.getAlbum());
		}
	}
}
