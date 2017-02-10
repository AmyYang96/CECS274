/**
 * This class represents a node in a heap
 * @author Amy Yang
 *
 */
public class Node 
{
	/**Represents a word */
	private Task data;
	
	/**
	 * Constructs a node object with a Task
	 * @param d new Task
	 */
	public Node(Task d)
	{
		data = d;
	}
	
	/**
	 * Gets a Task
	 * @return a Task
	 */
	public Task getData()
	{
		return data;
	}
	
	/**
	 * Sets the node with a new Task
	 * @param d new Task
	 */
	public void setData(Task d)
	{
		data = d;
	}

	
}
