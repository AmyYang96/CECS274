import java.util.Scanner;
import java.io.*;

/**
 * This is the main class that interacts with the tasklist
 * @author Amy Yang
 *
 */
public class Main 
{
	public static void main(String[] args) 
	{
		int action;
		Scanner in = new Scanner (System.in);
		Heap taskList = new Heap();
		taskList = readFile(taskList);
		
		
		menu();
		action = UserInput.getInt();
		
		while (action <1 || action > 6)
		{
			System.out.println("Please try again.");
			action = UserInput.getInt();
		}
		
		while (action > 0 && action <6)
		{
			if (action == 1) // display tasklist
			{
				if(taskList.isEmpty())
				{
					System.out.println("There are no tasks.");
				}
				else
				{
					taskList.printHeap();
				}
			}
			
			if (action == 2) // display current task
			{
				System.out.println(taskList.getNodeAt(0).getData());
			}
			
			if(action == 3) // add new task
			{
				String task, date, time;
				
				System.out.println("Enter a task: ");
				task = in.nextLine();
				System.out.println("Enter a due date: ");
				date = in.nextLine();
				System.out.println("Enter a time:");
				time = in.nextLine();
				
				taskList.addNode(new Node(new Task(task, date, time)));
			}
			
			if (action == 4) // mark complete
			{
				if(taskList.isEmpty())
				{
					System.out.println("There are no tasks to remove.");
				}
				else
				{
					System.out.println("Completed:" + taskList.removeMin().getData());
				}
			}
			
			if (action == 5) // postpone current task
			{
				if(taskList.isEmpty())
				{
					System.out.println("There are no tasks to postpone.");
				}
				else
				{
					String task = taskList.removeMin().getData().getTask();
					String date, time;
					System.out.println("Enter a new date: ");
					date = in.nextLine();
					System.out.println("Enter a new time:");
					time = in.nextLine();
					
					taskList.addNode(new Node(new Task(task, date, time)));
				}
			}
			
			System.out.println();
			menu();
			action = UserInput.getInt();
			
			while (action <1 || action > 6)
			{
				System.out.println("Please try again.");
				action = UserInput.getInt();
			}
		}
		
	}
	
	/**
	 * Reads in the list of tasks from file and adds to the heap
	 * @param tasksList empty heap
	 * @return heap with  list of tasks
	 */
	public static Heap readFile(Heap tasksList)
	{
		try
		{
			Scanner read=new Scanner(new File("tasklist.txt"));
			
			do
			{
				String line = read.nextLine();
				String [] tokens = line.split(",");
				
				Task task = new Task (tokens[0], tokens[1], tokens[2]); // input data in constructor
				
				tasksList.addNode(new Node(task));
				
			}while(read.hasNextLine());
				
			read.close();
		} 
		catch(FileNotFoundException fnf)
		{
			System.out.println("File was not found");
		}
		
		return tasksList;
	}
	
	/**
	 * Prints the menu
	 */
	public static void menu()
	{
		System.out.println("Please choose a function");
		System.out.println("1. Display tasklist");
		System.out.println("2. Display current task");
		System.out.println("3. Add a new task");
		System.out.println("4. Mark complete");
		System.out.println("5. Postpone current task\n6. Quit");
	}
}
