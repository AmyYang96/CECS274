import java.util.*;

/**
 * This class represents a movie object
 * @author Amy Yang
 *
 */
public class Movie 
{
	/**Represents the movie title*/
	public String title;
	
	/**Represents the release year*/
	public int year;
	
	/**Represents the movie rating*/
	public String rating;
	
	/**Represents the movie length in minutes*/
	public int length;
	
	/**Represents the audience rating*/
	public double stars;
	
	/**Represents the list of actors*/
	public ArrayList <String> actorsList;
	
	/**
	 * This constructor creates a Movie object with the following parameters:
	 * @param t movie title
	 * @param y release year
	 * @param r movie rating
	 * @param duration movie length
	 * @param s audience rating
	 * @param list list of actors
	 */
	public Movie (String t, int y, String r, int duration, double s,  ArrayList <String> list)
	{
		title = t;
		year = y;
		rating = r;
		length = duration;
		stars = s;
		actorsList = list;
	}
	
	/**
	 * Returns the movie title
	 * @return the movie title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Modifies the  movie title
	 * @param name new the movie title
	 */
	public void setTitle (String name)
	{
		title = name;
	}
	
	/**
	 * Returns the movie year
	 * @return the movie year
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * Modifies  the movie year
	 * @param yr new the movie year
	 */
	public void setYear (int yr)
	{
		year = yr;
	}
	
	/**
	 * Returns the movie rating
	 * @return the movie rating
	 */
	public String getRating()
	{
		return rating;
	}
	
	/**
	 * Modifies the movie rating
	 * @param r new the movie rating
	 */
	public void setRating (String r)
	{
		rating = r;
	}
	
	/**
	 * Returns the movie length
	 * @return the movie length
	 */
	public int getLength()
	{
		return length;
	}
	
	/**
	 * Modifies the  movie length
	 * @param duration new  movie length
	 */
	public void setLength (int duration)
	{
		length = duration;
	}
	
	/**
	 * Returns the audience rating
	 * @return the audience rating
	 */
	public double getStars()
	{
		return stars;
	}
	
	/**
	 * Modifies the audience rating
	 * @param star the new audience rating
	 */
	public void setStars (double star)
	{
		stars = star;
	}
	
	/**
	 * Returns the list of actors
	 * @return the list of actors
	 */
	public ArrayList <String> getActorsList()
	{
		return actorsList;
	}
	
	/**
	 * Modifies the list of actors
	 * @param names the new list of actors
	 */
	public void setActorsList (ArrayList <String>names)
	{
		actorsList = names;
	}
	
	/**
	 * Compares the two movies by title
	 * @param movie2 the other movie that's being compared
	 * @return -1 if the word is before, 0 if same, 1 if greater
	 */
	public int compareTo(Movie movie2)
	{
		return getTitle().compareToIgnoreCase(movie2.getTitle()); 
	}

	
	/**
	 * Returns String of movie info
	 * @return movie info
	 */
	public String toString()
	{
		String s = "Title: " + getTitle() + "\tRelease year: " + getYear()
				+ "\tRating: " + getRating() + "\tDuration: " + getLength()
				+ "\tStars:" + getStars() + "\tActors: ";
		
		if (actorsList.get(0).compareTo(" ") == 0)
		{
			s = s + "none recorded";
			
		}
		else
		{
			for (int i = 0; i < actorsList.size(); i++)
			{
				s = s + actorsList.get(i) + ", ";
			}
		}
		return s;
	}
	
	
	
	
	
	
}
