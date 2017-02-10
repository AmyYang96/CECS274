import java.awt.Point;
import java.io.*;
import java.util.*;

/**
 * This class contains main and static methods to solve mazes
 * @author Amy Yang
 *
 */
public class MazeSolver 
{
	public static void main(String[] args) 
	{
		int choice, solve;
		
		menu();
		choice = UserInput.getInt();
		
		while (choice < 1 || choice > 5)
		{
			menu();
			System.out.println("Invalid entry. Try again.");
			choice = UserInput.getInt();
		}
		
		while (choice >= 1 && choice <= 4)
		{
			if (choice == 1) // level 0
			{
				subMenu();
				solve = UserInput.getInt();
				
				while (solve < 1 || solve > 4)
				{
					subMenu();
					System.out.println("Invalid entry. Try again.");
					solve = UserInput.getInt();
				}
				
				if (solve == 1) // DFS
				{
					char[][] maze0 = MazeSolver.readFile("Maze-Level0",5,5);
					MazeSolver.depthFirstSearch(maze0, MazeSolver.searchStartPoint(maze0));
				}
				if (solve == 2) // BFS
				{
					char[][] maze0 = MazeSolver.readFile("Maze-Level0",5,5);
					MazeSolver.breadthFirstSearch(maze0);
				}
				
				if (solve == 3) // solve
				{
					char[][] maze0 = MazeSolver.readFile("Maze-Level0",5,5);
					MazeSolver.solveMaze(maze0);
				}
			}
			
			
			if (choice == 2) // level 1
			{
				subMenu();
				solve = UserInput.getInt();
				
				while (solve < 1 || solve > 4)
				{
					subMenu();
					System.out.println("Invalid entry. Try again.");
					solve = UserInput.getInt();
				}
//				char[][] maze1 = MazeSolver.readFile("Maze-Level1",9,15);
//				MazeSolver.displayArray(maze1);
				
				if (solve == 1) // DFS
				{
					char[][] maze1 = MazeSolver.readFile("Maze-Level1",9,15); 
					//System.out.println(MazeSolver.searchStartPoint(maze1));
					MazeSolver.depthFirstSearch(maze1, MazeSolver.searchStartPoint(maze1));
				}
				if (solve == 2) // BFS
				{
					char[][] maze1 = MazeSolver.readFile("Maze-Level1",9,15);
					MazeSolver.breadthFirstSearch(maze1);
				}
				
				if (solve == 3) // solve
				{
					char[][] maze1 = MazeSolver.readFile("Maze-Level1",9,15);
					MazeSolver.solveMaze(maze1);
				}
			}
			
			if (choice == 3) // level 2
			{
				subMenu();
				solve = UserInput.getInt();
				
				while (solve < 1 || solve > 4)
				{
					subMenu();
					System.out.println("Invalid entry. Try again.");
					solve = UserInput.getInt();
				}
				
				if (solve == 1) // DFS
				{
					char[][] maze2 = MazeSolver.readFile("Maze-Level2",11,21);
					MazeSolver.depthFirstSearch(maze2, MazeSolver.searchStartPoint(maze2));
				}
				if (solve == 2) // BFS
				{
					char[][] maze2 = MazeSolver.readFile("Maze-Level2",11,21);
					MazeSolver.breadthFirstSearch(maze2);
				}
				
				if (solve == 3) // solve
				{
					char[][] maze2 = MazeSolver.readFile("Maze-Level2",11,21);
					MazeSolver.solveMaze(maze2);
				}
			}
			
			if (choice == 4) // level 3
			{
				subMenu();
				solve = UserInput.getInt();
				
				while (solve < 1 || solve > 4)
				{
					subMenu();
					System.out.println("Invalid entry. Try again.");
					solve = UserInput.getInt();
				}
				
				if (solve == 1) // DFS
				{
					char[][] maze3 = MazeSolver.readFile("Maze-Level3",41,81);
					MazeSolver.depthFirstSearch(maze3, MazeSolver.searchStartPoint(maze3));
				}
				if (solve == 2) // BFS
				{
					char[][] maze3 = MazeSolver.readFile("Maze-Level3",41,81);
					MazeSolver.breadthFirstSearch(maze3);
				}
				
				if (solve == 3) // solve
				{
					char[][] maze3 = MazeSolver.readFile("Maze-Level3",41,81);
					MazeSolver.solveMaze(maze3);
				}
			}
			
			menu();
			choice = UserInput.getInt();
			
			while (choice < 1 || choice > 5)
			{
				menu();
				System.out.println("Invalid entry. Try again.");
				choice = UserInput.getInt();
			}
		}
	}
	
	/**
	 * This method displays the main menu
	 */
	public static void menu()
	{
		System.out.println("Please select a level of maze:");
		System.out.println("1. Level 0");
		System.out.println("2. Level 1");
		System.out.println("3. Level 2");
		System.out.println("4. Level 3");
		System.out.println("5. Quit");
	}
	
	/**
	 * This method displays the sub menu
	 */
	public static void subMenu()
	{
		System.out.println("Please select how you would to solve it:");
		System.out.println("1. DFS by stack");
		System.out.println("2. BFS by queue");
		System.out.println("3. Solve\n4. Go to main menu:");
		
	}
	/**
	 * This method reads a a maze from file
	 * @param fileName the maze's file name
	 * @param row number of rows that the maze has
	 * @param col number of columns that the maze has
	 * @return a 2D character array of the maze
	 */
	public static char[][] readFile (String fileName, int row, int col)
	{
		char[][] maze = new char[row][col];
		
		try
		{
			Scanner read=new Scanner(new File(fileName + ".txt"));
			
			do
			{
				String line = read.nextLine();
				String [] tokens = line.split(",");
				for(int i=0; i<tokens.length; i++)
				{
					for(int j = 0; j < tokens[i].length(); j++)
					{
						maze[i][j] = tokens[i].charAt(j);
						
					}
				}
				
			}
			while(read.hasNextLine());
			
			read.close();
		}
		catch (FileNotFoundException fnf)
		{
			System.out.println("File was not found");
		}
		
		return maze;
	}
	
	/**
	 * This method searches for a starting point
	 * @param maze the character array
	 * @return starting point
	 */
	public static Point searchStartPoint(char[][] maze)
	{
		int x=0;
		int y=0;

		for(int i = 0; i<maze.length; i++)
		{
		    for(int j = 0; j<maze[0].length; j++)
		    {
		        if(Character.valueOf(maze[i][j])== Character.valueOf('s'))
		        {
		        	x = i;
		        	y = j;
		        }
		    }
		}
		Point start = new Point(x,y);
		return start;
	}
	
	/**
	 * This method searches for a finish point
	 * @param maze the character array
	 * @return finish point
	 */
	public static Point searchFinishPoint(char[][] maze)
	{
		int x=0;
		int y=0;

		for(int i = 0; i<maze.length; i++)
		{
		    for(int j = 0; j<maze[0].length; j++)
		    {
		        if(Character.valueOf(maze[i][j])== Character.valueOf('f'))
		        {
		        	x = i;
		        	y = j;
		        }
		    }
		}
		Point finish = new Point(x,y);
		return finish;
	}
	
	/**
	 * This method solves the maze by using stacks
	 * @param maze the 2D character array
	 * @param start starting point
	 */
	public static void depthFirstSearch (char[][] maze, Point start)
	{
		LinkedStack stack = new LinkedStack();
		
		Point finish = searchFinishPoint(maze);
		stack.push(start);
		Point currentPos = stack.pop();
	
		while (!currentPos.equals(finish))
		{
			if( Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()]) == Character.valueOf(' ')) 
			{
				maze[(int)currentPos.getY()][(int)currentPos.getX()] = '.';
			}
			
			try // top
			{
				if( Character.valueOf(maze[(int)currentPos.getY()-1][(int)currentPos.getX()]) == Character.valueOf(' ')) 
				{
					stack.push(new Point( (int)currentPos.getX(), (int)currentPos.getY()-1));
				}
				
				if( Character.valueOf(maze[(int)currentPos.getY()-1][(int)currentPos.getX()]) == Character.valueOf('f')) 
				{
					stack.push(new Point( (int)currentPos.getX(), (int)currentPos.getY()-1));
				}
			}
			catch (IndexOutOfBoundsException oob)
			{
				//do nothing
			}
			
			try // bottom
			{
				if( Character.valueOf(maze[(int)currentPos.getY()+1][(int)currentPos.getX()]) == Character.valueOf(' ')) 
				{
					stack.push(new Point( (int)currentPos.getX(), (int)currentPos.getY()+1));
				}
				if( Character.valueOf(maze[(int)currentPos.getY()+1][(int)currentPos.getX()]) == Character.valueOf('f')) 
				{
					stack.push(new Point( (int)currentPos.getX(), (int)currentPos.getY()+1));;
				}
			}
			catch (IndexOutOfBoundsException oob)
			{
				//do nothing
			}
			
			try // left
			{
				if( Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()-1]) == Character.valueOf(' ')) 
				{
					stack.push(new Point( (int)currentPos.getX()-1, (int)currentPos.getY()));
				}
				if( Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()-1]) == Character.valueOf('f')) 
				{
					stack.push(new Point( (int)currentPos.getX()-1, (int)currentPos.getY()));
				}
			}
			catch (IndexOutOfBoundsException oob)
			{
				//do nothing
			}
			
			try // right
			{
				if( Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()+1]) == Character.valueOf(' ')) 
				{
					stack.push(new Point( (int)currentPos.getX()+1, (int)currentPos.getY()));;
				}
				if( Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()+1]) == Character.valueOf('f')) 
				{
					stack.push(new Point( (int)currentPos.getX()+1, (int)currentPos.getY()));
				}
			}
			catch (IndexOutOfBoundsException oob)
			{
				//do nothing
			}
			
			if(!stack.isEmpty())
			{
				currentPos = stack.pop();
			}
			else
			{
				break;
			}
		
		}
		
		displayArray(maze);
	}
	
	/**
	 * This method solves the maze by using queue
	 * @param maze the 2D character array
	 */
	public static void breadthFirstSearch (char[][] maze)
	{
		LinkedQueue queue = new LinkedQueue();
		Point start = searchStartPoint(maze);
		Point finish = searchFinishPoint(maze);
		queue.add(start);
		Point currentPos = queue.remove();
		
		while (!currentPos.equals(finish))
		{
			if( Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()]) == Character.valueOf(' ')) 
			{
				maze[(int)currentPos.getY()][(int)currentPos.getX()] = '.';
			}
			
			try // top
			{
				if( Character.valueOf(maze[(int)currentPos.getY()-1][(int)currentPos.getX()]) == Character.valueOf(' ')) 
				{
					queue.add(new Point( (int)currentPos.getX(), (int)currentPos.getY()-1));
				}
				
				if( Character.valueOf(maze[(int)currentPos.getY()-1][(int)currentPos.getX()]) == Character.valueOf('f')) 
				{
					queue.add(new Point( (int)currentPos.getX(), (int)currentPos.getY()-1));
				}
			}
			catch (IndexOutOfBoundsException oob)
			{
				//do nothing
			}
			
			try // bottom
			{
				if( Character.valueOf(maze[(int)currentPos.getY()+1][(int)currentPos.getX()]) == Character.valueOf(' ')) 
				{
					queue.add(new Point( (int)currentPos.getX(), (int)currentPos.getY()+1));
				}
				if( Character.valueOf(maze[(int)currentPos.getY()+1][(int)currentPos.getX()]) == Character.valueOf('f')) 
				{
					queue.add(new Point( (int)currentPos.getX(), (int)currentPos.getY()+1));;
				}
			}
			catch (IndexOutOfBoundsException oob)
			{
				//do nothing
			}
			
			try // left
			{
				if( Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()-1]) == Character.valueOf(' ')) 
				{
					queue.add(new Point( (int)currentPos.getX()-1, (int)currentPos.getY()));
				}
				if( Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()-1]) == Character.valueOf('f')) 
				{
					queue.add(new Point( (int)currentPos.getX()-1, (int)currentPos.getY()));
				}
			}
			catch (IndexOutOfBoundsException oob)
			{
				//do nothing
			}
			
			try // right
			{
				if( Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()+1]) == Character.valueOf(' ')) 
				{
					queue.add(new Point( (int)currentPos.getX()+1, (int)currentPos.getY()));;
				}
				if( Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()+1]) == Character.valueOf('f')) 
				{
					queue.add(new Point( (int)currentPos.getX()+1, (int)currentPos.getY()));
				}
			}
			catch (IndexOutOfBoundsException oob)
			{
				//do nothing
			}
			
			if(!queue.isEmpty())
			{
				currentPos = queue.remove();
			}
			else
			{
				break;
			}
		}
		
		displayArray(maze);
	}
	
	/**
	 * Allows the user to solve the maze. If user quits, then DFS takes over
	 * @param maze 2D character array
	 */
	public static void solveMaze(char[][] maze)
	{
		int action;
		boolean solved = false;
		Point currentPos = searchStartPoint(maze); 
		Point finish = searchFinishPoint(maze);
		
		displayArray(maze);
		solveMenu();
		action = UserInput.getInt();
		
		while ( action < 1 || action > 5 )
		{
			System.out.println("Invalid");
			action = UserInput.getInt();
		}
		
		while (!solved)
		{
			if (action == 1) //up
			{
				try
				{
					if (Character.valueOf(maze[(int)currentPos.getY()-1][(int)currentPos.getX()]) == Character.valueOf(' ') )
					{
						maze[(int)currentPos.getY()-1][(int)currentPos.getX()] = '.';
						currentPos = new Point( (int) currentPos.getX(), (int) currentPos.getY()-1);
						System.out.println("Current position is (" + (int) currentPos.getX() + ", " + (int) currentPos.getY() + ")");
					}
					
					if (Character.valueOf(maze[(int)currentPos.getY()-1][(int)currentPos.getX()]) == Character.valueOf('*') )
					{
						System.out.println("You have hit a wall");
						System.out.println("Current position is (" + (int) currentPos.getX() + ", " + (int) currentPos.getY() + ")");
					}
					
					if (Character.valueOf(maze[(int)currentPos.getY()-1][(int)currentPos.getX()]) == Character.valueOf('.') )
					{
						System.out.println("You have already solved that point.");
						System.out.println("Current position is (" + (int) currentPos.getX() + ", " + (int) currentPos.getY() + ")");
					}
					if (Character.valueOf(maze[(int)currentPos.getY()-1][(int)currentPos.getX()]) == Character.valueOf('f') )
					{
						System.out.println("You have solved the maze");
						solved = true;
						currentPos = finish;
						displayArray(maze);
					}
				
				}
				catch (IndexOutOfBoundsException oob )
				{
					System.out.println("Out of bounds. Try again");
				}
			}
			
			if (action == 2) //down
			{
				try
				{
					if (Character.valueOf(maze[(int)currentPos.getY()+1][(int)currentPos.getX()]) == Character.valueOf(' ') )
					{
						maze[(int)currentPos.getY()+1][(int)currentPos.getX()] = '.';
						currentPos = new Point( (int) currentPos.getX(), (int) currentPos.getY()+1);
						System.out.println("Current position is (" + (int) currentPos.getX() + ", " + (int) currentPos.getY() + ")");
					}
					
					if (Character.valueOf(maze[(int)currentPos.getY()+1][(int)currentPos.getX()]) == Character.valueOf('*') )
					{
						System.out.println("You have hit a wall");
						System.out.println("Current position is (" + (int) currentPos.getX() + ", " + (int) currentPos.getY() + ")");
					}
					
					if (Character.valueOf(maze[(int)currentPos.getY()+1][(int)currentPos.getX()]) == Character.valueOf('.') )
					{
						System.out.println("You have already solved that point.");
						System.out.println("Current position is (" + (int) currentPos.getX() + ", " + (int) currentPos.getY() + ")");
					}
					if (Character.valueOf(maze[(int)currentPos.getY()+1][(int)currentPos.getX()]) == Character.valueOf('f') )
					{
						System.out.println("You have solved the maze");
						solved = true;
						currentPos = finish;
						displayArray(maze);
					}
				
				}
				catch (IndexOutOfBoundsException oob )
				{
					System.out.println("Out of bounds. Try again");
				}
			}
			
			if (action == 3) //left
			{
				try
				{
					if (Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()-1]) == Character.valueOf(' ') )
					{
						maze[(int)currentPos.getY()][(int)currentPos.getX()-1] = '.';
						currentPos = new Point( (int) currentPos.getX()-1, (int) currentPos.getY());
						System.out.println("Current position is (" + (int) currentPos.getX() + ", " + (int) currentPos.getY() + ")");
					}
					
					if (Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()-1]) == Character.valueOf('*') )
					{
						System.out.println("You have hit a wall");
						System.out.println("Current position is (" + (int) currentPos.getX() + ", " + (int) currentPos.getY() + ")");
					}
					
					if (Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()-1]) == Character.valueOf('.') )
					{
						System.out.println("You have already solved that point.");
						System.out.println("Current position is (" + (int) currentPos.getX() + ", " + (int) currentPos.getY() + ")");
					}
					if (Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()-1]) == Character.valueOf('f') )
					{
						System.out.println("You have solved the maze");
						solved = true;
						currentPos = finish;
						displayArray(maze);
					}
				
				}
				catch (IndexOutOfBoundsException oob )
				{
					System.out.println("Out of bounds. Try again");
				}
			}
			
			if (action == 4) //right
			{
				try
				{
					if (Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()+1]) == Character.valueOf(' ') )
					{
						maze[(int)currentPos.getY()][(int)currentPos.getX()+1] = '.';
						currentPos = new Point( (int) currentPos.getX()+1, (int) currentPos.getY());
						System.out.println("Current position is (" + (int) currentPos.getX() + ", " + (int) currentPos.getY() + ")");
					}
					
					if (Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()+1]) == Character.valueOf('*') )
					{
						System.out.println("You have hit a wall");
						System.out.println("Current position is (" + (int) currentPos.getX() + ", " + (int) currentPos.getY() + ")");
					}
					
					if (Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()+1]) == Character.valueOf('.') )
					{
						System.out.println("You have already solved that point.");
						System.out.println("Current position is (" + (int) currentPos.getX() + ", " + (int) currentPos.getY() + ")");
					}
					if (Character.valueOf(maze[(int)currentPos.getY()][(int)currentPos.getX()+1]) == Character.valueOf('f') )
					{
						System.out.println("You have solved the maze");
						solved = true;
						currentPos = finish;
						displayArray(maze);
					}
				
				}
				catch (IndexOutOfBoundsException oob )
				{
					System.out.println("Out of bounds. Try again");
				}
			}
			
			if (action == 5)
			{
				depthFirstSearch(maze, currentPos);
				solved = true;
				currentPos = finish;
			}
			
			if ( !currentPos.equals(finish))
			{
				displayArray(maze);
				solveMenu();
				action = UserInput.getInt();
				
				while ( action < 1 || action > 5 )
				{
					System.out.println("Invalid");
					action = UserInput.getInt();
				}
			}
		}
		
	}
	
	/**
	 * Displays the menu when the user solves the maze
	 */
	public static void solveMenu()
	{
		System.out.println("Please select a movement:");
		System.out.println("1. Up");
		System.out.println("2. Down");
		System.out.println("3. Left");
		System.out.println("4. Right");
		System.out.println("5. Quit");
	}
	/**
	 * This  method displays the maze
	 * @param maze character array
	 */
	public static void displayArray(char[][] maze)
	{
		for(int i = 0; i<maze.length; i++)
		{
		    for(int j = 0; j<maze[0].length; j++)
		    {
		        System.out.print(maze[i][j]);
		    }
		    System.out.println();
		}
	}
}
