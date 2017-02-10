import java.util.*;
import java.text.*;

/**
 * This class represents a task
 * @author Amy Yang
 *
 */
public class Task 
{
	/**Represents a task*/
	public String task;
	
	/**Represents the due date*/
	public Date dueDate;

	/**
	 * Constructor initializes a date object by splitting the date and time
	 * @param chore Represents the task
	 * @param day Represents due date
	 * @param time Represents due date time
	 */
	public Task (String chore, String day, String time)
	{
		task = chore;
		String d = day+" " +time;
		
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
			dueDate = formatter.parse(d);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	//	dueDate = new  GregorianCalendar();
//		dueDate.set(year-1900, month, date, hours, min);
	}
	
	/**
	 * Gets the task
	 * @return task
	 */
	public String getTask ()
	{
		return task;
	}
	
	/**
	 * Sets to a new task
	 * @param t new task
	 */
	public void setTask (String t)
	{
		task = t;
	}
	/**
	 * Gets the task's due date
	 * @return due date
	 */
	public Date getDate ()
	{
		return dueDate;
	}
	
	/**
	 * Sets a new due date
	 * @param year new due date year
	 * @param month new due date month
	 * @param day new due date day
	 * @param hrs new due date time
	 * @param min new due date time
	 */
	public void setDate (int year, int month, int day, int hrs, int min)
	{
		dueDate.setYear(year);
		dueDate.setMonth(month);
		dueDate.setDate(day);
		dueDate.setHours(hrs);
		dueDate.setMinutes(min);
	}
//	
	/**
	 * Compares 2 due dates
	 * @param date2 another due date
	 * @return -1 if the date is before date2, 0 if the dates are the same, 1 if after date2
	 */
	public int compareTo (Date date2)
	{
		return dueDate.compareTo(date2);
	}
	
	/**
	 * Converts task to a string
	 * @return a String
	 */
	public String toString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		
		return task + ", " + formatter.format(dueDate);
	}
}
