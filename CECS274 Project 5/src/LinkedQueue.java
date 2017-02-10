import java.awt.Point;
/**
 * This class represents a queue of nodes
 * @author Amy Yang
 *
 */
public class LinkedQueue 
{
	/**Represents the first node in the list*/
	private Node first;
	
	/**Represents the last node in the list*/
	private Node last;
	
	/**
	 * Constructs an empty queue list 
	 */
	public LinkedQueue()
	{
		first = null;
		last = null;
	}
	
	/**
	 * Checks if the stack is empty
	 * @return true if empty, false if not
	 */
	public boolean isEmpty() 
	{
		return first == null;
	}
	
	/**
	 * Adds a node to the queue
	 * @param pt point to be added
	 */
	public void add( Point pt ) 
	{
		if( isEmpty() ) 
		{
			first = new Node(pt);
			last = first;
		} 
		else 
		{
			Node n = new Node(pt);
			last.setNext(n);
			last = n;
		}
	}
	
	/**
	 * Removes the node first in the queue
	 * @return the removed node
	 */
	public Point remove() 
	{
		Point ret = null;
		if( isEmpty() ) 
		{
			System.out.println("Nothing to Remove");
		} 
		else 
		{
			ret = first.getValue();
			first = first.getNext();
			if( first == null ) 
			{
				last = null;
			}
		}
		return ret;
	}
	
	/**
	 * Returns the node at the front of the queue
	 * @return the node at the front of the queue
	 */
	public Point peek() 
	{
		Point ret = null;
		if( isEmpty() ) 
		{
			System.out.println("Queue is Empty");
		} 
		else 
		{
			ret = first.getValue();
		}
		return ret;
	}
	
	/**
	 * Counts how many nodes there are in the queue
	 * @return the number of nodes in the queue
	 */
	public int size() 
	{
		int count = 0;
		Node n = first;
		while( n != null ) 
		{
			count++;
			n = n.getNext();
		}
		return count;
	}
	
	/**
	 * @Override
	 * Returns a string with all the point info
	 * @return a string with all the point info
	 */
	public String toString()
	{
		String s = "";
		Node n = first;
		while(n != null)
		{
			s = s + n.getValue();
			n = n.getNext();
		}
		return s;
	}
}
