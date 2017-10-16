
public class QuickSort<T extends Comparable<T>> {

	private HelperFunctions<T> helpers = new HelperFunctions<T>();
	
	public T[] sort(T array[]) {
		return sortAux(array, 0, array.length - 1);
	}
	
	/* Sorting function using the quicksort method.
	 * Takes the array, beginning index and ending index
	 * as parameters */
	 public T[] sortAux(T array[], int low, int high) {
		 
	     if (low < high) {
	    	 
	    	 	//Find the correct index for the pivot
	        int pivotCorrected = helpers.partition(array, low, high);

	        //Recursively sort elements to the left and right of pivot
	        sortAux(array, low, pivotCorrected - 1);
	        sortAux(array, pivotCorrected + 1, high);
	     }
	     return array;
	 }
	 
	
}
