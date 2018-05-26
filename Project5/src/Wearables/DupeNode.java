package Wearables;

/**
 * creates a duplicate node used to store items of the same data
 * @author evankoh
 * @param <T>
 *
 */
public class DupeNode<T> {
		public DupeNode<T> u;
		public int index;
		
		/**
		 * creates a new duplicate node
		 * @param idx
		 */
		public DupeNode(T t, int idx){
			this.u = this;
			this.index = idx;
		}
		
		/**
		 * Adds a duplicate node
		 * @param pos
		 */
		public void add(T t, int pos){
			this.index = pos;
		}
	}