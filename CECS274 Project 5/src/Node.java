import java.awt.Point;

/**
 * This class represents a node with a point
 * @author Amy Yang
 *
 */
public class Node 
{
	/**Represents a point*/
	private Point point;
	
	/**Represents next node*/
	private Node next;
	
	/**
	 * This constructor constructs a node that takes in point, used in stacks
	 * @param pt a point object
	 * @param n a node
	 */
	public Node( Point pt, Node n ) 
	{
		point = pt;
		next = n;
	}
	
	/**
	 * This constructor takes in a Point parameter, used in queues
	 * @param pt Point object
	 */
	public Node (Point pt)
	{
		point = pt;
		next = null;
	}
	/**
	 * Gets the point in the node
	 * @return a point
	 */
	public Point getValue() 
	{
		return point;
	}
	
	/**
	 * Gets the next node
	 * @return the next node
	 */
	public Node getNext() 
	{
		return next;
	}
	
	/**
	 * Modifies the content of the node
	 * @param pt new point info
	 */
	public void setValue( Point pt)
	{
		point = pt;
	}
	
	/**
	 * Sets the next node
	 * @param n the node that is to be next
	 */
	public void setNext( Node n)
	{
		next = n;
	}
}
