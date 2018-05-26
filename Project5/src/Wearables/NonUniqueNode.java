package Wearables;

/**
 * used to create new nonunique node objects for a Ternary search tree
 * @author evankoh
 *
 * @param <T> the type to be used
 */
public class NonUniqueNode<T extends Comparable<T>> {
		public T data;
		public NonUniqueNode<T> left, right;
		public DupeNode<T> dupe;
		public int index;

		/**
		 * creates a new NonUniqueNode object
		 * @param t
		 * @param idx
		 */
		public NonUniqueNode(T t, int idx){
			this.data = t;
			this.index = idx;
			this.left = null;
			this.right = null;
			this.dupe = null;
			
		}
		
		/**
		 * Adds a new item to the TST
		 * @param t -- the data to add
		 * @param pos -- the index position
		 * @return
		 */
		public boolean add(T t, int pos){
			if (t.compareTo(this.data) == 0){
				if(dupe == null){
					dupe = new DupeNode<T>(t, pos);
					return true;
				} else {
					dupe.add(t, pos);
					return true;
				}
			} else if (t.compareTo(this.data) < 0){
				if(left == null){
					left = new NonUniqueNode<T>(t, pos);
					return true;
				} else {
					return left.add(t, pos);
				}
			} else if (t.compareTo(this.data) > 0) {
				if (right == null){
					right = new NonUniqueNode<T>(t, pos);
					return true;
				} else {
					return right.add(t, pos);
				}
			} 
			return false;
		}
	}