/**
 * This class constructs a Question object with a question and 4 answer choices
 * @author Amy YaNg
 *
 */
public class Question 
{
	/** Represents a question */
	private String question;
	
	/** Represents the first answer choice */
	private String answer1;
	
	/** Represents the second answer choice */
	private String answer2;
	
	/** Represents the third answer choice */
	private String answer3;
	
	/** Represents the fourth answer choice */
	private String answer4;
	
	/** Represents the correct answer */
	private String correctAnswer;
	
	/**
	 * This constructor represents a question with answer choices and the correct answer
	 * @param q		Represents the question 
	 * @param a1	Represents the first answer choice
	 * @param a2	Represents the second answer choice
	 * @param a3	Represents the third answer choice
	 * @param a4	Represents the fourth answer choice
	 * @param correctAns Represents the correct answer 
	 */
	public Question (String q, String a1, String a2, String a3, String a4, String correctAns)
	{
		question = q;
		answer1 = a1;
		answer2 = a2;
		answer3 = a3;
		answer4 = a4;
		correctAnswer = correctAns;
	}
	
	/**
	 * This method returns the question.
	 * @return	Returns the question
	 */
	public String getQuestion()
	{
		return question;
	}
	
	/**
	 * This method modifies the question
	 * @param q Represents the new question
	 */
	public void setQuestion (String q)
	{
		question = q;
	}

	/**
	 * This method modifies answer choice 1
	 * @param a1 Represents the new answer choice 1
	 */
	public void setAnswer1(String a1)
	{
		answer1 = a1;
	}
	
	/**
	 * This method returns answer choice 1
	 * @return Returns answer choice 1
	 */
	public String getAnswer1()
	{
		return answer1;
	}
	
	/**
	 * This method modifies answer choice 2
	 * @param a2 Represents the new answer choice 2
	 */
	public void setAnswer2(String a2)
	{
		answer2 = a2;
	}

	/**
	 * This method returns answer choice 2
	 * @return Returns answer choice 2
	 */
	public String getAnswer2()
	{
		return answer2;
	}
	
	/**
	 * This method returns answer choice 3
	 * @return Returns answer choice 3
	 */
	public String getAnswer3()
	{
		return answer3;
	}
	
	/**
	 * This method modifies answer choice 3
	 * @param a3 Represents the new answer choice 3
	 */
	public void setAnswer3(String a3)
	{
		answer3 = a3;
	}
	
	/**
	 * This method returns answer choice 4
	 * @return Returns answer choice 4
	 */
	public String getAnswer4()
	{
		return answer4;
	}
	
	/**
	 * This method modifies answer choice 4
	 * @param a4 Represents the new answer choice 4
	 */
	public void setAnswer4(String a4)
	{
		answer4 = a4;
	}
	
	/**
	 * This method returns the correct answer to the question
	 * @return	Returns the correct answer to the question
	 */
	public String getCorrectAnswer()
	{
		return correctAnswer;
	}
	
	/**
	 * This method modifies the correct answer
	 * @param correctAns Represents the new correct answer
	 */
	public void setCorrectAnswer( String correctAns)
	{
		correctAnswer = correctAns;
	}
	
	/**
	 * This method returns a string with the question and answer choices together
	 * @return Returns a string with the question and answer choices together
	 */
	public String toString ()
	{
		String result = question + "\n   " + answer1 + "\n   " + answer2 + "\n   " + answer3 + "\n   " + answer4 + "\n";
		
		return result;
	}
}
