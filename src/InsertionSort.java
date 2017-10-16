//import java.util.Arrays;

public class InsertionSort<T extends Comparable<T>> {

	//The function which implements insertion sort
	public T[] sort(T array[]) {
		
		int length = array.length;
		
		//Iterates through the array, beginning at index 1
		for(int i = 1; i < length; i++) {
			
			T item = array[i];
			int j = i - 1;
				
			/*While iterating through the array, if the previous
			 * element is greater than the ith element, it takes the
			 * ith element's place, and this is repeated to the left
			 * until a lesser element or the beginning of the list
			 * is reached*/
			while (j >= 0 && array[j].compareTo(item) > 0) {
				
				array[j + 1] = array[j];
				j--;
			}
			
			/*The ith element is placed into the position of the 
			* old position of the last element that replaced it,
			* or simply replaces itself if nothing changed*/
			array[j + 1] = item;
		}
		return array;
	}
}
