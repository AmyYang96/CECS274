import java.util.ArrayList;

/**
 * This class represents a heap
 * @author Amy Yang
 *
 */
public class Heap 
{
	
	/**Represents a heap*/
	private ArrayList<Node> heap;
	
	/**
	 * Constructs a heap with an empty arraylist
	 */
	public Heap()
	{
		heap = new ArrayList<Node>();
	}
	
	/**
	 * Gets the size of the heap
	 * @return size
	 */
	public int getSize()
	{
		return heap.size();
	}
	
	/**
	 * Checks if the heap is empty
	 * @return true if empty
	 */
	public boolean isEmpty()
	{
		return heap.isEmpty();
	}
	
	/**
	 * Returns the parent's index
	 * @param i child's index
	 * @return parent's index
	 */
	public int getPLoc(int i)
	{
		return (i-1)/2;
	}
	
	/**
	 * Returns left child's index
	 * @param i current index
	 * @return left child's index
	 */
	public int getLCLoc(int i)
	{
		return 2*i+1;
	}
	
	/**
	 * Returns right child's index
	 * @param i current index
	 * @return right child's index
	 */
	public int getRCLoc(int i)
	{
		return 2*i+2;
	}
	
	/**
	 * Gets a node at a certain index
	 * @param i index
	 * @return node
	 */
	public Node getNodeAt(int i)
	{
		if(heap.get(i) == null)
		{
			System.out.println("Item does not exist.");
			return null;
		}
		else
		{
			return heap.get(i);
		}
	}
	
	/**
	 * Adds a node to the heap
	 * @param n
	 */
	public void addNode(Node n)
	{
		heap.add(null);
		int index = heap.size() - 1;
		while(index > 0 && getNodeAt(getPLoc(index)).getData().compareTo(n.getData().getDate()) > 0)
		{
			heap.set(index, getNodeAt(getPLoc(index)));
			index = getPLoc(index);
		}
		heap.set(index, n);
	}
	
	/**
	 * Removes the minimum value in the heap
	 * @return node with the min value
	 */
	public Node removeMin()
	{
		Node min = heap.get(0);
		int index = heap.size()-1;
		Node last = heap.remove(index);
		
		if(index > 0)
		{
			heap.set(0, last);
			Node root = heap.get(0);
			int end = heap.size()-1;
			index = 0;
			boolean done = false;
			
			while(!done)
			{
				if(getLCLoc(index) <= end)
				{
					//left exists
					Node child = getNodeAt(getLCLoc(index));
					int childLoc = getLCLoc(index);
					if(getRCLoc(index) <= end) 
					{
						//right exists
						if(getNodeAt(getRCLoc(index)).getData().compareTo(child.getData().getDate()) <0 )
						{
							child = getNodeAt(
							getRCLoc(index));
							childLoc = getRCLoc(index);
						}
					}
					if(child.getData().compareTo( root.getData().getDate()) < 0)
					{
						heap.set(index, child);
						index = childLoc;
					}
					else
					{
						done = true;
					}
				}
				else
				{
					//no children
					done = true;
				}
			}
			heap.set(index, root);
		}
		return min;
	}
	
	/**
	 * Prints the items in the list
	 */
	public void printHeap()
	{
		for(int i=0;i<heap.size();i++)
		{
			System.out.println((i+1)+". " +heap.get(i).getData()+" ");
		}
		System.out.println();
	}
}