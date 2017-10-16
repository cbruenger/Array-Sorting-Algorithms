
public class HeapSort<T extends Comparable<T>> {
	
	private HelperFunctions<T> helpers = new HelperFunctions<T>();

	/*The sort function which implements HeapSort. Takes the array
	 *to be sorted as a parameter*/
	public T[] sort(T[] array) {
		
		int length = array.length;
 
        //Transform input into max heap
        for (int i = (length / 2) - 1; i >= 0; i--)
        		array = heapify(array, length, i);
 
        /*Remove elements one at a time by swapping max with
         *last element, i, and then decrementing i. Then 
         *create a max heap of the reduced heap*/
        for (int i = length - 1; i >= 0; i--) {
        	
            array = helpers.swap(array, 0, i);
            array = heapify(array, i, 0);
        }
        return array;
    }
 
    /*Create a max heap of a subtree tree taking current index
     * and current size of tree*/
    public T[] heapify(T[] array, int size, int root) {
    	
        int maxIndex = root;
        int leftChildIndex = (2 * root) + 1;
        int rightChildIndex = (2 * root) + 2;
 
        //Reassign maxIndex if left child is larger
        if (leftChildIndex < size && array[leftChildIndex].compareTo(array[maxIndex]) > 0)
        		maxIndex = leftChildIndex;
 
      //Reassign maxIndex if right child is larger
        if (rightChildIndex < size && array[rightChildIndex].compareTo(array[maxIndex]) > 0)
            maxIndex = rightChildIndex;
 
        /*If the initial root is no longer the max index, swap them
         *and recurse*/
        if (maxIndex != root) {
        	
            array = helpers.swap(array, root, maxIndex);
            array = heapify(array, size, maxIndex);
        }
        return array;
    }
}
