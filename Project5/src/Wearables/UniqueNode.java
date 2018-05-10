package Wearables;

/**
 * creates a node used for BST traversal and stores data and array index information
 * @author evan kohout
 *
 * @param <T> the type of the object
 */
public class UniqueNode<T extends Comparable<T>> {
		public T data;
		public UniqueNode<T> left, right;
		public int index;
		
		/**
		 * creates a new UniqueNode object
		 * @param t
		 * @param idx
		 */
		public UniqueNode(T t, int idx){
			this.data = t;
			this.index = idx;
			left = null;
			right = null;
			
		}
		
		/**
		 * Adds a new node to the BST
		 * @param t -- the data of the node to store
		 * @param pos -- the array index position to store
		 * @return
		 */
		public boolean add(T t, int pos){
			if (t.compareTo(this.data) == 0){
				return false;
			} else if (t.compareTo(this.data) < 0){
				if(left == null){
					left = new UniqueNode<T>(t, pos);
					return true;
				} else {
					return left.add(t, pos);
				}
			} else if (t.compareTo(this.data) > 0) {
				if (right == null){
					right = new UniqueNode<T>(t, pos);
					return true;
				} else {
					return right.add(t, pos);
				}
			} 
			return false;
		}
	}