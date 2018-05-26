package Wearables;

/**
 * Used to create an index of nonunique items, with duplicates, and sorts them
 * @author evan kohout
 *
 * @param <T>
 */
public class NonUniqueIndex<T extends Comparable<T>> {
	private NonUniqueNode<T> root;
	private T[] nonUniqueArr;
	
	/**
	 * creates a new non-unique index using a ternary search tree, adds items to the tree
	 * @param arr -- the items to be added to the tree
	 */
	public NonUniqueIndex(T[] arr) {
		this.root = null;
		this.nonUniqueArr = arr;
		for(int i = 0; i < arr.length; i++){
			this.add(arr[i], i);
		}
	}

	/**
	 * Used to retrieve an array of indices 
	 * @return
	 */
	public int[] getArrayIndices(){
		int[] returnArr = new int[nonUniqueArr.length];
		String[] inOrder = searchInOrder(root).split("@");
		for(int i = 0; i < inOrder.length; i++){
			returnArr[i] = Integer.parseInt(inOrder[i]);
		}
		return returnArr;
	}
	
	/**
	 * Returns an array index for a given data value
	 * @param t -- the value to be found
	 * @return an int -- the index of the node for the given data
	 */
	public int search(T t){
		NonUniqueNode<T> current = root;
		while(current != null){
			if(current.data.compareTo(t) == 0){
				return current.index = current.dupe.index;
			} else if(current.data.compareTo(t) > 0){
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return -1;
	}
	
	/*
	 * used to search the BST using the inOrder method
	 */
	private String searchInOrder(NonUniqueNode<T> node){
		if(node == null){
			return "";
		} else if (node.dupe != null){
			return searchInOrder(node.left) + node.dupe.index + "@" + searchInOrder(node.right);
		} else {
			return searchInOrder(node.left) + node.index + "@" + searchInOrder(node.right);
		}
	}
	
	/*
	 * used to add a single item to the BST
	 */
	private boolean add (T t, int pos){
		if( root == null){
			root = new NonUniqueNode<T>(t, pos);
			return true;
		} else {
			return root.add(t, pos);
		}
	}
	
	/**
	 * Clears the TST
	 */
    public void clear()
    {
        root = null;
    }
    
    /**
     * Used to check if the TST has content or not
     * @return true or false depending if TST is empty
     */
    public boolean isEmpty()
    {
        return root == null;
    }
}
