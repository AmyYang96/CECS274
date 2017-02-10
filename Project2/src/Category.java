import java.util.*;
import java.io.*;

/**
 * This class class contains a category of questions in an ArrayList
 * @author AMmy Yang
 *
 */
public class Category 
{
	/** Represents name of the category */
	private String categoryName;
	
	/** Represents the ArrayList of questions */
	private ArrayList <Question> questions = new ArrayList <Question>();  
	
	/**
	 * This constructor is defined by the name and initializes the ArrayList. 
	 * @param name
	 */
	public Category(String name)
	{
		categoryName = name;
		
		// reads each question from file
		try
		{
			Scanner read=new Scanner(new File(categoryName +".txt"));
			
			do
			{
				String line = read.nextLine();
				String [] tokens = line.split(","); //use commas to split up the data in the line
				
				Question q = new Question(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5] ); // input data in constructor
				
				questions.add(q); // add question arraylist
				
			}while(read.hasNextLine());
				
			read.close();
		} 
		catch(FileNotFoundException fnf){
		
			System.out.println("File was not found");
		}
	}
	
	/**
	 * This method returns the category name
	 * @return the name of the category
	 */
	public String getName()
	{
		return categoryName;
	}
	
	/**
	 * This method adds a question to the ArrayList
	 */
	public void addQuestion()
	{
		Scanner in = new Scanner (System.in);
		String question, a1, a2, a3, a4, correctAnswer;

		System.out.println("Please enter a question: ");
		question = in.nextLine();
		
		System.out.println("Please enter answer choice #1: ");
		a1 = in.nextLine();
		
		System.out.println("Please enter answer choice #2: ");
		a2 = in.nextLine();
		
		System.out.println("Please enter answer choice #3: ");
		a3 = in.nextLine();
		
		System.out.println("Please enter answer choice #4: ");
		a4 = in.nextLine();
		
		System.out.println("Please enter the correct answer (number): ");
		correctAnswer = in.nextLine();
		
		//checks input
		while( !( correctAnswer.equalsIgnoreCase("1") || correctAnswer.equalsIgnoreCase("2") || correctAnswer.equalsIgnoreCase("3") || correctAnswer.equalsIgnoreCase("4") ) )
		{
			System.out.println("Invalid entry. Enter again:");
			correctAnswer = in.nextLine();
		}
		Question q = new Question ( question, a1, a2, a3, a4, correctAnswer );
		
		questions.add(q);
	}
	
	
	/**
	 * This method asks the user which part of the question to modify and modifies it
	 * @param index Represents the question number on the list (will be subtracted by 1 to get the true index)
	 */
	public void modifyQuestion(int index)
	{
		Scanner in = new Scanner(System.in);
		boolean input = true;
		int choice;
		String info;
		
		while (input)
		{
			try
			{
				System.out.println("\nChoose which part of the question to modify:");
				System.out.println("1. Question\n2. Answer choice #1\n3. Answer choice #2\n4. Answer choice #3\n" +
						"5. Answer choice #4\n6. Correct Answer");
				choice = in.nextInt();
				in.nextLine();
				
				if (choice <= 0 || choice > 6)
				{
					System.out.println("Invalid input");
					input = true;
				}
				else
				{
					if ( choice == 1) // modify question
					{
						System.out.println("Please enter a modified question:");
						info = in.nextLine();
						questions.get(index-1).setQuestion(info);
					}
					
					if ( choice == 2) // modify answer choice #1
					{
						System.out.println("Please enter a modified answer choice #1:");
						info = in.nextLine();
						questions.get(index-1).setAnswer1(info);
					}
					
					if ( choice == 3) // modify answer choice #2
					{
						System.out.println("Please enter a modified answer choice #2:");
						info = in.nextLine();
						questions.get(index-1).setAnswer2(info);
					}
					
					if ( choice == 4) // modify answer choice #3
					{
						System.out.println("Please enter a modified answer choice #3:");
						info = in.nextLine();
						questions.get(index-1).setAnswer3(info);
					}
					
					if ( choice == 5) // modify answer choice #4
					{
						System.out.println("Please enter a modified answer choice #4:");
						info = in.nextLine();
						questions.get(index-1).setAnswer4(info);
					}
					
					if ( choice == 6) // modify the correct answer 
					{
						System.out.println("Please enter a modified correct answer :");
						info = in.nextLine();
						
						//checks input
						while( !( info.equalsIgnoreCase("1") || info.equalsIgnoreCase("2") || info.equalsIgnoreCase("3") || info.equalsIgnoreCase("4") ) )
						{
							System.out.println("Invalid entry. Enter again:");
							info = in.nextLine();
						}
						questions.get(index-1).setCorrectAnswer(info);
					}
					input = false;
				}
			}
			catch( InputMismatchException im ) 
			{
				in.next(); //clear buffer
				System.out.println("Invalid Input");
			}
		}
	}
	
	/**
	 * This method writes the questions in the ArrayList back into the File 
	 * @param qList Represents the ArrayList of questions
	 */
	public void writeList()
	{
		try
		{
			PrintWriter writer = new PrintWriter(categoryName + ".txt");
			
			for(int i = 0; i < questions.size(); i++) // go through ArrayList
			{
				writer.println(questions.get(i).getQuestion() + "," + 
								   questions.get(i).getAnswer1() + "," +
								   questions.get(i).getAnswer2() + "," +
								   questions.get(i).getAnswer3() + "," +
								   questions.get(i).getAnswer4() + "," +
								   questions.get(i).getCorrectAnswer());
			}
			
			writer.close();
			
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("File was not found");
		}
	}
	
	/**
	 * This method prints the questions in the category
	 */
	public void printQuestions()
	{
		for(int i = 0; i < questions.size(); i++)
		{
			String q = questions.get(i).toString();
			System.out.println( (i+1) + ". " + q);
		}
	}
	
	/**
	 * This method returns the size of the category
	 * @return the size of the category
	 */
	public int getSize()
	{
		return questions.size();
	}
	
	/**
	 * This method allows the user to take the quiz.
	 */
	public void takeQuiz()
	{
		Scanner in = new Scanner(System.in);
		Random generator = new Random();
		int question;
		int right = 0;
		String answer;
		
		for(int i=0; i<10; i++)
		{
			question = generator.nextInt(questions.size());
			
			System.out.println( (i+1) + "." + questions.get(question).toString());
			System.out.println("Answer: ");
			answer = in.nextLine();
			
			//checks input
			while( !( answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("3") || answer.equalsIgnoreCase("4") ) )
			{
				System.out.println("Invalid entry. Enter again:");
				answer = in.nextLine();
			}
			
			if( answer.equalsIgnoreCase(questions.get(question).getCorrectAnswer()))
			{
				right++;
			}		
		}
		
		System.out.println("You got " + right + " questions right.");
	}
}
