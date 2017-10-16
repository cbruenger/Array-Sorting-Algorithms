
public class MergeSort<T extends Comparable<T>> {

	/*The sort function which takes an array and calls the
	 * recursive function*/
	public T[] sort(T[] array) {
		return sortAux(array, 0, array.length - 1);
	}
	
	/*The recursive function that divides the array into
	 * sub arrays by their midpoint until they are size
	 * 1, and then calls the merge function on each of the
	 * sub arrays until the final merged array is produced*/
	public T[] sortAux(T[] array, int low, int high) {
		
		if (high > low) {
			
			//Find mid index
			int mid = (high + low) / 2;
			
			//Sort left sub array and then right sub array
			sortAux(array, low, mid);
			sortAux(array, (mid + 1), high);
			
			//Merge the sub arrays
			merge(array, low, mid, high);
			
		}
		return array;
    }
	
	/*The merging function which is called by the sort in each
	 * recursive call that merges all of the sub arrays, eventually
	 * producing the final array*/
	public T[] merge(T[] array, int low, int mid, int high) {
		
		/*A temporary copy of the array with sorted halves on 
		* either side of the midpoint*/
		T[] temp = array;
		
		/*Incrementors for the left and right halves of temp, and 
		* for the final array*/
		int tempLeftInc = low;
		int tempRightInc = mid + 1;
		int arrayInc = low;
		
		/*Iterates through the temp array, sequentially comparing items
		 * in each half of the temp array and copyingng the lesser items
		 * into the final array and then incrementing the final array 
		 * index*/
		while (tempLeftInc <= mid && tempRightInc <= high) {
			if (temp[tempLeftInc].compareTo(temp[tempRightInc]) <= 0) {
				array[arrayInc] = temp[tempLeftInc];
				tempLeftInc++;
			} else {
				array[arrayInc] = temp[tempRightInc];
				tempRightInc++;
			}
			arrayInc++;
		}
		
		/*If there were remaining items in the left half of the array
		 * that were not reached due to being larger than all items in
		 * the right half, they are copied into the remaining indices
		 * of the final array*/
		while (tempLeftInc <= mid) {
			array[arrayInc] = temp[tempLeftInc];
			tempLeftInc++;
			arrayInc++;
		}
		return array;
	}
}
