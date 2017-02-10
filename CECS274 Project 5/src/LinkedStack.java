import java.awt.Point;

/**
 * Represents a stack of nodes
 * @author Amy Yang
 *
 */
public class LinkedStack 
{
	/**Represents the node at the top of the stack */
	private Node top;
	
	/**
	 * Constructs a stack with the bottom as null
	 */
	public LinkedStack() 
	{
		top = null;
	}
	
	/**
	 * Checks if the stack is empty
	 * @return true if empty, false if not
	 */
	public boolean isEmpty() 
	{
		return top == null;
	}
	
	/**
	 * Adds a node to the stack
	 * @param p point to be added
	 */
	public void push( Point p ) 
	{
		top = new Node( p, top );
	}

	/**
	 * Removes the node at the top of the stack
	 * @return the removed node
	 */
	public Point pop() 
	{
		Point retPoint = null;
		
		if( isEmpty() )
		{
			System.out.println("Nothing to Remove");
		} 
		else 
		{
			retPoint = top.getValue();
			top = top.getNext();
		}
		return retPoint;
	}
	
	/**
	 * Returns the node at the top of the stack
	 * @return the node at the top of the stack
	 */
	public Point peek() 
	{
		Point retPoint = null;
		
		if( isEmpty() )
		{
			System.out.println("Stack is Empty");
		} 
		else 
		{
			retPoint = top.getValue();
		}
		return retPoint;
	}
	
	/**
	 * @Override
	 * Returns a string with all the point info
	 * @return a string with all the point info
	 */
	public String toString() 
	{
		String s = "";
		Node n = top;
		
		while( n != null ) 
		{
			s = s + n.getValue() + " ";
			n = n.getNext();
		}
		return s;
	}
}
