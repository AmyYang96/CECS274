import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * This class contains the main class to display calculations
 * @author Amy Yang
 *
 */
public class ClassGradesStats 
{
	public static void main(String[] args) 
	{
		int input;
		
		ArrayList <Integer> class1 = new ArrayList <Integer> ();
		ArrayList <Integer> class2 = new ArrayList <Integer> ();
		ArrayList <Integer> classBoth = new ArrayList <Integer> ();
		ArrayList <Integer> sortedClass1 = new ArrayList <Integer> ();
		ArrayList <Integer> sortedClass2 = new ArrayList <Integer> ();
		ArrayList <Integer> sortedClassBoth = new ArrayList <Integer> ();

		readGrades(classBoth);
		
		for( int i=0; i<50; i++) //put grades for class 1 into ArrayList
		{
			class1.add(classBoth.get(i));
		}
		
		for( int i=50; i<100; i++) //put grades for class 2 into ArrayList
		{
			class2.add(classBoth.get(i));
		}
		

		//copy
		sortedClass1 = copy(class1);
		sortedClass2 = copy(class2);
		sortedClassBoth = copy(classBoth);
		
		//sort
		Calculations.quickSort(sortedClass1, 0, 49);
		Calculations.quickSort(sortedClass2, 0, sortedClass2.size()-1);
		Calculations.quickSort(sortedClassBoth, 0, sortedClassBoth.size()-1);
		
		//fill the initial mode ArrayLists w/ zeroes
		ArrayList <Integer> class1ModeArray = setZeroArray();
		ArrayList <Integer> class2ModeArray = setZeroArray();
		ArrayList <Integer> classBothModeArray = setZeroArray();
		
		//Calculate occurence for each grade
		class1ModeArray = Calculations.modeArray(class1, class1ModeArray, 0);
		class2ModeArray = Calculations.modeArray(class2, class2ModeArray, 0);
		classBothModeArray = Calculations.modeArray(classBoth, classBothModeArray, 0);
		
		//return list of modes
		ArrayList <Integer> class1Mode = Calculations.mode(class1ModeArray);
		ArrayList <Integer> class2Mode = Calculations.mode(class2ModeArray);
		ArrayList <Integer> classBothMode = Calculations.mode(classBothModeArray);

		
		displayMenu();
		input = UserInput.getInt();
		
		while(input <=0 || input >8)
		{
			System.out.println("Invalid. Try again.");
			input = UserInput.getInt();
		}
		
		while (input > 0 && input <= 7)
		{
			if (input == 1) // display grades of both classes
			{
				displayGrades(class1, class2);
			}
			
			if (input == 2) // display sorted grades of both classes
			{
				displayGrades(sortedClass1, sortedClass2);
			}
			
			if (input == 3) // display average
			{
				System.out.println("Average grade of class 1: " + Calculations.average(class1));
				System.out.println("Average grade of class 2: " + Calculations.average(class2));
				System.out.println("Average grade of both classes: " + Calculations.average(classBoth) + "\n");
			}
			
			if (input == 4) // display median
			{
				System.out.println("Median grade of class 1: " + Calculations.median(sortedClass1));
				System.out.println("Median grade of class 2: " + Calculations.median(sortedClass2));
				System.out.println("Median grade of both classes: " + Calculations.median(sortedClassBoth) + "\n");
			}
			
			if (input == 5) // display mode
			{
				System.out.println("Mode of class 1: " + Calculations.printMode(class1Mode));
				System.out.println("Mode of class 2: " + Calculations.printMode(class2Mode));
				System.out.println("Mode of both classes: " + Calculations.printMode(classBothMode) + "\n");
				
			}
			
			if (input == 6) // display range
			{
				System.out.println("Range grade of class 1: " + Calculations.range(sortedClass1));
				System.out.println("Range grade of class 2: " + Calculations.range(sortedClass2));
				System.out.println("Range grade of both classes: " + Calculations.range(sortedClassBoth) + "\n");
			}
			
			if (input == 7) // display standard deviation
			{
				System.out.println("Standard deviation of class 1: " + Calculations.stdDeviation(class1));
				System.out.println("Standard deviation of class 2: " + Calculations.stdDeviation(class2));
				System.out.println("Standard deviation of both classes: " + Calculations.stdDeviation(classBoth) + "\n");
			}
			
			displayMenu();
			input = UserInput.getInt();
			
			while(input <=0 || input >8) //check int value
			{
				System.out.println("Invalid. Try again.");
				input = UserInput.getInt();
			}
		}
	}
	
	/**
	 * Reads grades from file
	 * @param grades ArrayList of Grades
	 */
	public static void readGrades (ArrayList <Integer> grades)
	{
		// reads each grade from file
		try
		{
			Scanner read=new Scanner(new File("MidtermGrades.txt"));
			
			do
			{
				int grade = read.nextInt();
				
				grades.add(grade); // add grade to arraylist
				
			}while(read.hasNextLine());
				
			read.close();
		} 
		catch(FileNotFoundException fnf){
		
			System.out.println("File was not found");
		}
	}

	/**
	 * Method copies an ArrayList 
	 * @param grades ArrayList of grades
	 * @return copied Arraylist
	 */
	public static ArrayList <Integer> copy(ArrayList <Integer> grades)
	{
		ArrayList <Integer> copyGrades = new ArrayList <Integer> ();
		
		for(int i=0; i<grades.size(); i++)
		{
			copyGrades.add(grades.get(i));
		}
		
		return copyGrades;
	}
	
	/**
	 * Prints arrayList recursively
	 * @param grades Arraylist of grades
	 * @param i starting index
	 */
	public static void printArray( ArrayList <Integer> grades, int i ) 
	{
		if( i < grades.size() ) 
		{
			System.out.println( grades.get(i) );
			printArray( grades, i + 1 );
		}
	}
	
	/**
	 * Prints arrayList recursively
	 * @param grades1 Arraylist of grades of class 1
	 * @param grades2 Arraylist of grades of class 2
	 * @param i starting index
	 */
	public static void printArray( ArrayList <Integer> grades1, ArrayList <Integer> grades2, int i  ) 
	{
		if( i < grades1.size() ) 
		{
			System.out.println( grades1.get(i) + "\t\t" + grades2.get(i) );
			printArray( grades1, grades2, i+1);
		}
	}
	
	/**
	 * Helper method of printArray() to print
	 * @param grades
	 */
	public static void print( ArrayList <Integer> grades ) 
	{
		printArray( grades, 0 );
	}
	
	/**
	 * Helper method of printArray() to print
	 * @param grades1 Arraylist of grades of class 1
	 * @param grades2 Arraylist of grades of class 2
	 */
	public static void print( ArrayList <Integer> grades1, ArrayList <Integer> grades2 ) 
	{
		printArray( grades1, grades2, 0 );
	}
	/**
	 * Display grades of 1 class
	 * @param grades Arraylist of grades
	 */
	public static void displayGrades ( ArrayList <Integer> grades )
	{
		print(grades);
	}
	
	/**
	 * Display grades of 2 classes
	 * @param grades1 Arraylist of grades of first class
	 * @param grades2 Arraylist of grades of second class
	 */
	public static void displayGrades ( ArrayList <Integer> grades1,  ArrayList <Integer> grades2)
	{
		System.out.println("Class 1:\tClass 2:");
		print(grades1, grades2);
	}
	
	/**
	 * Displays the menu
	 */
	public static void displayMenu()
	{
		System.out.println("1. Display grades of both classes");
		System.out.println("2. Display sorted grades of both classes");
		System.out.println("3. Display average");
		System.out.println("4. Display median ");
		System.out.println("5. Display mode   ");
		System.out.println("6. Display range");
		System.out.println("7. Display standard deviation");
		System.out.println("8. Quit \nPlease choose a function: ");
	}
	
	/**
	 * Fills the initial mode ArrayList with zeroes
	 * @return mode ArrayList of zeroes
	 */
	public static ArrayList <Integer> setZeroArray()
	{
		ArrayList <Integer> modeList = new ArrayList <Integer> ();
		
		for(int i=0; i < 101; i++)
		{
			modeList.add(0);
		}
		
		return modeList;
	}
}
