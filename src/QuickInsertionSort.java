
public class QuickInsertionSort<T extends Comparable<T>> {

	private InsertionSort<T> insertionSort = new InsertionSort<T>();
	private HelperFunctions<T> helpers = new HelperFunctions<T>();
	
	public T[] sort(T array[], int switchSize) {
		return sortAux(array, 0, array.length - 1, switchSize);
	}
	
	/* Sorting function using the quicksort method.
	 * Takes the array, beginning index and ending index
	 * as parameters */
	 public T[] sortAux(T array[], int low, int high, int switchSize) {
		 
	     if (low < high) {
	    	 
	    	 	if (array.length < switchSize) {
	    	 		array = insertionSort.sort(array);
	    	 	} else {
	    	 		//Find the correct index for the pivot
	    	        int pivotCorrected = helpers.partition(array, low, high);

	    	        //Recursively sort elements to the left and right of pivot
	    	        array = sortAux(array, low, pivotCorrected - 1, switchSize);
	    	        array = sortAux(array, pivotCorrected + 1, high, switchSize);
	    	 	}
	     }
	     return array;
	 }
	
}
