package Wearables;

/**
 * Creates an index of unique items and sorts them, based on a binary search tree
 * @author evan kohout
 *
 * @param <T> the type of the object
 */
public class UniqueIndex<T extends Comparable<T>> {
	private UniqueNode<T> root;
	private T[] uniqueArr;
	
	/**
	 * creates a new UniqueIndex object
	 * @param arr
	 */
	public UniqueIndex(T[] arr) {
		this.root = null;
		this.uniqueArr = arr;
		for(int i = 0; i < arr.length; i++){
			this.add(arr[i], i);
		}
	}
	
	/**
	 * Used to retrieve an array of indices 
	 * @return
	 */
	public int[] getArrayIndices(){
		int[] returnArr = new int[uniqueArr.length];
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
		UniqueNode<T> current = root;
		while(current != null){
			if(current.data.compareTo(t) == 0){
				return current.index;
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
	private String searchInOrder(UniqueNode<T> node){
		if(node == null){
			return "";
		} 
		return searchInOrder(node.left) + node.index + "@" + searchInOrder(node.right);
	}
	
	/*
	 * used to add a single item to the BST
	 */
	private boolean add (T t, int pos){
		if( root == null){
			root = new UniqueNode<T>(t, pos);
			return true;
		} else {
			return root.add(t, pos);
		}
	}
}
