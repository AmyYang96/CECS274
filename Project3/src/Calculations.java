import java.util.*;

/**
 * This class contains methods for statistics calculations
 * @author Amy Yang
 *
 */
public class Calculations 
{
	/**
	 * Static method that calculates average by using recursive sum
	 * @param grades ArrayList of grades in the class
	 * @return class average
	 */
	public static double average (ArrayList <Integer> grades)
	{
		double sum = (double) sumArray(grades, 0);
		
		return sum / grades.size();
	}
	
	/**
	 * Static method that calculates the sum of class grades using the helper recursive sum method sumArray.
	 * @param grades ArrayList of grades in the class
	 * @return sum of the class grades
	 */
	public static int sum (ArrayList <Integer> grades)
	{
		return sumArray(grades,0);
	}
	
	/**
	 * Static method that calculates the sum of class grades using the recursive sum 
	 * @param grades ArrayList of grades in the class
	 * @param i first index in the ArrayList
	 * @return sum of the class grades
	 */
	public static int sumArray( ArrayList <Integer> grades, int i)
	{
		if(i < grades.size())
		{
			return  (grades.get(i) + sumArray(grades, i+1));			
		}
	
		return 0;		
	}
	
	/**
	 * Static method that calculates median
	 * @param grades ArrayList of sorted grades in the class
	 * @return median
	 */
	public static double median (ArrayList <Integer> grades)
	{
		int midIndex = grades.size()/2;
		
		if (midIndex%2 == 0)
		{
			return (grades.get(midIndex) + grades.get(midIndex-1) ) /2.0;
		}
		else
		{
			return grades.get(midIndex);
		}
	}
	
	/**
	 * Static method that calculates the range
	 * @param sortedGrades ArrayList of sorted grades in the class
	 * @return range
	 */
	public static int range (ArrayList <Integer> sortedGrades)
	{
		return sortedGrades.get( sortedGrades.size()-1 ) - sortedGrades.get(0); //max - min
	}
	
	/**
	 * Static helper method to quicksort that returns the pivot
	 * @param grades ArrayList of grades in the class
	 * @param left first index 
	 * @param right second index
	 * @return returns the pivot point
	 */
	public static int partition(ArrayList <Integer> grades, int left, int right)
	{
		int pivot = grades.get(left);
	
		while (left <= right)
		{
			while (grades.get(left) < pivot)
			{
				left++;
			}
			
			while (grades.get(right) > pivot)
			{
				right--;
			}
			
			if (left <= right)
			{
				int temp = grades.get(right);
				grades.set(right, grades.get(left));
				grades.set(left,temp);
				left++;
				right--;
			}
		}
		return left;
		}
	
	/**
	 * Static method that sorts array with quicksort recursively
//	 * @param grades ArrayList of grades in the class
	 * @param start beginning of ArrayList
	 * @param end end of ArrayList
	 */
	public static void quickSort(ArrayList <Integer> grades, int start, int end)
	{
		if(start < end)
		{
			int pivot = partition(grades, start, end);
		
			if(start < pivot - 1)
			{
				quickSort(grades, start, pivot - 1);
			}
			
			if(end > pivot)
			{
				quickSort(grades, pivot, end);
			}
		}
	}
	
	/**
	 * Helper method for standard deviation, uses recursion to add
	 * @param grades ArrayList of grades in the class
	 * @param i starting index
	 * @return variance before square root is applied
	 */
	public static double variance(ArrayList <Integer> grades, int i)
	{
		double average = average(grades);
		if(i <grades.size())
		{
			return ( ( Math.pow(average - grades.get(i), 2) ) / grades.size() ) + variance(grades, i+1);
		}
		return 0;
	}
	
	/**
	 * Calculates standard deviation with helper method
	 * @param grades ArrayList of grades in the class
	 * @return standard deviation
	 */
	public static double stdDeviation(ArrayList <Integer> grades)
	{
		return Math.pow(variance(grades,0), 0.5);
	}

	/**
	 * Calculates recursively the occurrence for each grade
	 * @param grades ArrayList of grades in the class
	 * @param modeList ArrayList of modes in which the grades are the indices
	 * @param i starting index
	 * @return ArrayList of each grade occurrence
	 */
	public static ArrayList <Integer>  modeArray (ArrayList <Integer> grades, ArrayList <Integer>  modeList, int i)
	{
		if( i < grades.size())
		{
			modeList.set(grades.get(i), modeList.get(grades.get(i))+1); // set at grade index and increment
			return modeArray(grades, modeList, i+1); //recursive
		}
		else
		{
			return modeList;
		}
	}
	/**
	 * Calculates the mode from ArrayList of occurences
	 * @param modeList ArrayList of each grade occurrence
	 * @return ArrayList of modes
	 */
	public static ArrayList <Integer> mode(ArrayList <Integer> modeList)
	{
		ArrayList <Integer> mode = new ArrayList <Integer>();
	
		for(int i=0; i < modeList.size(); i++)
		{
			if (modeList.get(i) == 3)
			{
				mode.add(i);
			}
		}
		return mode;
	}
	
	/**
	 * Returns the list of Modes as a String
	 * @param mode ArrayList of Modes
	 * @returnlist of Modes as a String
	 */
	public static String printMode ( ArrayList <Integer> mode)
	{
		String modeResult = "";
		
		for(int i = 0; i<mode.size(); i++)
		{
			modeResult += mode.get(i) + ", ";
		}
		return modeResult;
	}

}
