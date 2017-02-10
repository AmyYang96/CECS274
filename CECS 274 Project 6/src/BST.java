import java.util.*;
/**
 * This class represents a binary search tree
 * @author Amy Yang
 */
public class BST 
{
	/** Represents the first node before it splits */
	private Node root;

	/**
	 * Constructs a tree with the root initialized as null
	 */
	public BST() 
	{
		root = null;
	}

	/**
	 * Checks if tree is empty 
	 * @return true if it is empty
	 */
	public boolean isEmpty() 
	{
		return root == null;
	}

	/**
	 * Adds a movie to the tree
	 * @param movie a movie
	 */
	public void add(Movie m) 
	{
		root = add(m, root);
	}

	/**
	 * Recursively adds a node in sorted order by title
	 * 
	 * @param m
	 *            movie
	 * @param tree
	 *            a node
	 * @return the whole tree
	 */
	private Node add(Movie m, Node tree) 
	{
		if (tree == null) 
		{
			return new Node(m);
		} 
		else 
		{
			if (m.compareTo(tree.getData()) < 0) 
			{
				tree.setLeft(add(m, tree.getLeft()));
			} 
			else 
			{
				tree.setRight(add(m, tree.getRight()));
			}

			return tree;
		}
	}

	/**
	 * Adds an actor to a movie
	 * @param movie movie title
	 * @param actor actors name
	 */
	public void addActor (String movie, String actor)
	{
		Node n = searchTitle(movie);
		
		if ( n == null)
		{
			System.out.println("Actor could not be added because movie is not in the database.");
		}
		else
		{
			if (n.getData().getActorsList().get(0).compareTo(" ") == 0 )
			{
				n.getData().getActorsList().set(0,actor);				
			}
			else
			{
				n.getData().getActorsList().add(actor);
			}
		}
	}
	
	/**
	 * Deletes an actor to a movie
	 * @param movie movie title
	 * @param actor actors name
	 */
	public void deleteActor (String movie, String actor)
	{
		Node n = searchTitle(movie);
		
		if ( n == null)
		{
			System.out.println("Actor could not be deleted because movie is not in the database.");
		}
		else
		{
			if (n.getData().getActorsList().get(0).compareTo(" ") == 0 && n.getData().getActorsList().size()==1 )
			{
				System.out.println("No actors to be removed.");
			}
			else
			{
				if( n.getData().getActorsList().size()==1 && n.getData().getActorsList().get(0).compareTo(actor) == 0)
				{
					n.getData().getActorsList().set(0, " ");
				}
				else
				{
					if ( n.getData().getActorsList().contains(actor) == false)
					{
						System.out.println("Actor could not be deleted because actor is not in the list");
					}
					else
					{
						n.getData().getActorsList().remove(actor);
					}
				}
			}
		}
	}
	
	/**
	 * Searches for a movie by title
	 * @param name title to be searched
	 * @return node
	 */
	public Node searchTitle(String name) 
	{
		if (root == null) 
		{
			System.out.println("No items to search");
			return null;
		} 
		else 
		{
			return searchTitle(name, root);
		}
	}

	/**
	 * Recursively searches for a movie by title
	 * 
	 * @param s title
	 * @param n  node
	 * @return a node
	 */
	private Node searchTitle(String s, Node n) 
	{
		if (s.compareTo(n.getData().getTitle()) == 0) 
		{
			return n;
		}
	
		if (s.compareTo(n.getData().getTitle()) < 0) 
		{
			if (n.getLeft() == null) 
			{
				System.out.println("Item Not Found");
				return null;
			} 
			else 
			{
				return searchTitle(s, n.getLeft());
			}
		}
		else 
		{
			if (n.getRight() == null) 
			{
				System.out.println("Item Not Found");
				return null;
			} 
			else 
			{
				return searchTitle(s, n.getRight());
			}
		}
	}
	
	/**
	 * Searches for movies by rating
	 * @param rating rating to be searched
	 * @return list of movies with the same rating
	 */
	public BST searchRating(String rating) 
	{
		if (root == null) 
		{
			System.out.println("No items to search");
			return null;
		} 
		else 
		{
			BST list = new BST();
			searchRating(rating, root, list);
			return list;
		}
	}

	/**
	 * Recursively searches for a movie by rating
	 * @param s rating
	 * @param n  node
	 * @param list to add movies that have the same rating
	 */
	private void searchRating(String s, Node n, BST list) 
	{
		if (s.compareTo(n.getData().getRating()) == 0) 
		{
			list.add(n.getData());
	
		}
		
		if (n.getLeft() != null) 	
		{
			searchRating(s, n.getLeft(),list);
		}
		
		if (n.getRight() != null) 
		{
			searchRating(s, n.getRight(),list);
		}	
	}
	
	/**
	 * Searches for movies by decade
	 * @param decade decade to be searched
	 * @return list of movies in the same decade
	 */
	public BST searchDecade(int decade) 
	{
		if (root == null) 
		{
			System.out.println("No items to search");
			return null;
		} 
		else 
		{
			BST list = new BST();
			searchDecade(decade, root, list);
			return list;
		}
	}

	/**
	 * Recursively searches for a movie by decade
	 * @param decade decade to be searched
	 * @param n  node
	 * @param list to add movies that are in the same decade
	 */
	private void searchDecade(int decade, Node n, BST list) 
	{
		if (n.getData().getYear() >= decade && n.getData().getYear() < (decade+10) ) 
		{
			list.add(n.getData());
		}
		
		if (n.getLeft() != null) 	
		{
			searchDecade(decade, n.getLeft(),list);
		}
		
		if (n.getRight() != null) 
		{
			searchDecade(decade, n.getRight(),list);
		}
	}
	
	/**
	 * Searches for movies by star rating
	 * @param stars stars to be searched
	 * @return list of movies with the same stars
	 */
	public BST searchStars(double stars) 
	{
		if (root == null) 
		{
			System.out.println("No items to search");
			return null;
		} 
		else 
		{
			BST list = new BST();
			searchStars(stars, root, list);
			return list;
		}
	}

	/**
	 * Recursively searches for movies with the same star rating
	 * @param stars stars to be searched
	 * @param n  node
	 * @param list to add movies that have the same stars
	 */
	private void searchStars(double stars, Node n, BST list) 
	{
		if (n.getData().getStars() == stars ) 
		{
			list.add(n.getData());
		}
		
		if (n.getLeft() != null) 	
		{
			searchStars(stars, n.getLeft(),list);
		}
		
		if (n.getRight() != null) 
		{
			searchStars(stars, n.getRight(),list);
		}
	}
	
	/**
	 * Searches for movies by actor
	 * @param name actor's name to be searched
	 * @return list of movies with the same actor
	 */
	public BST searchActor(String name) 
	{
		if (root == null) 
		{
			System.out.println("No items to search");
			return null;
		} 
		else 
		{
			BST list = new BST();
			searchActor(name, root, list);
			return list;
		}
	}

	/**
	 * Recursively searches for a movie by actor
	 * @param s actor's name
	 * @param n  node
	 * @param list to add movies that have the same actor
	 */
	private void searchActor(String s, Node n, BST list) 
	{
		ArrayList <String> actors = n.getData().getActorsList();

		if(actors != null)
		{
			for(int i = 0; i < actors.size(); i++ ) 
			{
				if(s.compareToIgnoreCase( actors.get(i) ) == 0)
				{
					list.add(n.getData());
				}
			}
		}
		if (n.getLeft() != null) 	
		{
			searchActor(s, n.getLeft(),list);
		}
		
		if (n.getRight() != null) 
		{
			searchActor(s, n.getRight(),list);
		}	
	}

	
	
	/**
	 * Finds the min value in the tree
	 * @return min value
	 */
	public Movie findMin() 
	{
		return findMin(root).getData();
	}

	/**
	 * Recursively finds the min value in the tree
	 * @param n the next node
	 * @return min node
	 */
	private Node findMin(Node n) 
	{
		if (n == null) 
		{
			return null;
		} 
		else if (n.getLeft() == null) 
		{
			return n;
		}

		return findMin(n.getLeft());
	}

	/**
	 * Finds the max value in the tree
	 * @param n the next node
	 * @return max node
	 */
	public Movie findMax() 
	{
		return findMax(root).getData();
	}

	/**
	 * Recursively finds the max value in the tree
	 * @param n the next node
	 * @return max node
	 */
	private Node findMax(Node n) 
	{
		if (n == null) 
		{
			return null;
		} 
		else if (n.getRight() == null) 
		{
			return n;
		}
		return findMax(n.getRight());
	}

	/**
	 * Removes a movie by title
	 * @param title title of movie to be removed
	 */
	public void remove(String title) 
	{
		if (root == null) 
		{
			System.out.println("No items to remove");
		} 
		else 
		{
			if (searchTitle(title) == null)
			{
				System.out.print("Nothing to delete.");
			}
			else
			{
				root = remove(title, root);
			}
		}
	}

	/**
	 * Removes a movie by title recursively
	 * @param title title of movie to be removed
	 * @param n current node
	 * @return removed node
	 */
	private Node remove(String title, Node n) 
	{
		if (n == null) 
		{
			return n;
		} 
		
		// traverse to node to be removed
		if (title.compareToIgnoreCase(n.getData().getTitle()) < 0) 
		{
			n.setLeft(remove(title, n.getLeft()));
		} 
		else if (title.compareToIgnoreCase(n.getData().getTitle()) > 0) 
		{
			n.setRight(remove(title, n.getRight()));
		} 
		// two children
		else if (n.getLeft() != null && n.getRight() != null) 
		{
			if ((int) (Math.random() * 2) == 0) 
			{
				n.setData(findMin(n.getRight()).getData());
				n.setRight(remove(n.getData().getTitle(), n.getRight()));
			} 
			else 
			{
				n.setData(findMax(n.getLeft()).getData());
				n.setLeft(remove(n.getData().getTitle(), n.getLeft()));
			}
		} 
		else 
		{ 
			// one child
			if (n.getLeft() != null) 
			{
				n = n.getLeft();
			} 
			else 
			{
				n = n.getRight();
			}
		}
		return n;
	}

	/**
	 * Print the tree in order
	 */
	public void printBST() 
	{
		if (isEmpty()) 
		{
			System.out.println("No movies in the database.");
		} 
		else 
		{
			printBST(root);
		}
	}

	/**
	 * Recursively prints the tree branch by branch
	 * 
	 * @param n node
	 */
	private void printBST(Node n) 
	{
		// go down left tree
		if (n.getLeft() != null) 
		{
			printBST(n.getLeft());
		}
		// go down right tree
		System.out.println(n.getData());
		if (n.getRight() != null) 
		{
			printBST(n.getRight());
		}
	}
}
