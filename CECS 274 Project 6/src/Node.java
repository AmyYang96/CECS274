/**
 * This class represents a node to be used in BST
 * @author Amy Yang
 */
public class Node 
{
	/**Represents a movie */
	private Movie movie;
	
	/**Represents the left branch*/
	private Node left;
	
	/**Represents the right branch*/
	private Node right;
	
	/**
	 * Constructs a node with a movie
	 * @param m movie
	 */
	public Node(Movie m) 
	{
		movie = m;
		left = null;
		right = null;
	}
	
	/**
	 * Sets the node with a movie
	 * @param m movie
	 */
	public void setData(Movie m) 
	{
		movie = m;
	}
	
	/**
	 * Gets the movie from the node
	 * @return a movie
	 */
	public Movie getData() 
	{
		return movie;
	}
	
	/**
	 * Modifies the left node
	 * @param l new node
	 */
	public void setLeft(Node l) 
	{
		left = l;
	}
	
	/**
	 * Gets the left node
	 * @return left node
	 */
	public Node getLeft() 
	{
		return left;
	}
	
	/**
	 * Modifies right node
	 * @param r new node
	 */
	public void setRight(Node r) 
	{
		right = r;
	}
	
	/**
	 * Gets right node
	 * @return right node
	 */
	public Node getRight() 
	{
		return right;
	}

}
