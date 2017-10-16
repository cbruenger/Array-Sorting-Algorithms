import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//Continue looping the program until user decides to exit
		while (true) {
			
			//Get user input to exit program or for array type, cutoff size for quickSort, and array elements
			System.out.println("Choose your array type, or to quit, by entering either 1, 2 or 3:\n");
			System.out.println("\t1 Integer\n\t2 String\n\t3 quit\n");
			String type = scanner.nextLine();
			if (Integer.parseInt(type) == 3) break;
			System.out.println();		
			System.out.println("Enter the array cutoff size for which Quicksort should switch to InsertionSort:\n");
			String cutoffString = scanner.nextLine();
			System.out.println();			
			System.out.println("Enter the elements of your array separated by ONLY commas (no spaces):\n");
			String string = scanner.nextLine();
			System.out.println();
			
			//The array to pass into the sorting algorithms, and the cutoff for QuickSort that switches to MergeSort
			String[] stringArray = string.split(",");
			int cutoff = Integer.parseInt(cutoffString);
			
			//Run algorithms on String arrays
			if (Integer.parseInt(type) == 2) {
				
				//Initialize classes
				Printer<String> printer = new Printer<String>();
				InsertionSort<String> inSort = new InsertionSort<String>();
				QuickSort<String> quickSort = new QuickSort<String>();
				QuickInsertionSort<String> quickInsertionSort = new QuickInsertionSort<String>();
				QuickSortMedianOf3<String> quickSortMedianOf3 = new QuickSortMedianOf3<String>();
				MergeSort<String> mergeSort = new MergeSort<String>();
				HeapSort<String> heapSort = new HeapSort<String>();
				
				//InsertionSort
				long array1Start = System.nanoTime();
				String[] sortedArray1 = inSort.sort(stringArray);
				long array1End = System.nanoTime();
				long array1RunTime = array1End - array1Start;

				//QuickSort
				long array2Start = System.nanoTime();
				String[] sortedArray2 = quickSort.sort(stringArray);
				long array2End = System.nanoTime();
				long array2RunTime = array2End - array2Start;

				//QuickSort switching to InsertionSort
				long array3Start = System.nanoTime();
				String[] sortedArray3 = quickInsertionSort.sort(stringArray, cutoff);
				long array3End = System.nanoTime();
				long array3RunTime = array3End - array3Start;

				//QuickSort median of 3 switching to InsertionSort
				long array4Start = System.nanoTime();
				String[] sortedArray4 = quickSortMedianOf3.sort(stringArray, cutoff);
				long array4End = System.nanoTime();
				long array4RunTime = array4End - array4Start;

				//MergeSort
				long array5Start = System.nanoTime();
				String[] sortedArray5 = mergeSort.sort(stringArray);
				long array5End = System.nanoTime();
				long array5RunTime = array5End - array5Start;

				//HeapSort
				long array6Start = System.nanoTime();
				String[] sortedArray6 = heapSort.sort(stringArray);
				long array6End = System.nanoTime();
				long array6RunTime = array6End - array6Start;

				//Print info
				System.out.println("1) InsertionSort:\n");
				System.out.println("\tRuntime: " + array1RunTime + " microseconds");
				System.out.print("\tResults: ");
				printer.printArray(sortedArray1);
				System.out.println("2) Quicksort:\n");
				System.out.println("\tRuntime: " + array2RunTime + " microseconds");
				System.out.print("\tResults: ");
				printer.printArray(sortedArray2);
				System.out.println("3) Quicksort switching to InsertionSort on arrays of size less than " + cutoff + ":\n");
				System.out.println("\tRuntime: " + array3RunTime + " microseconds");
				System.out.print("\tResults: ");
				printer.printArray(sortedArray3);
				System.out.println("4) Quicksort Median of 3 and switching to Insertion sort on arrays of size less than " + cutoff + ":\n");
				System.out.println("\tRuntime: " + array4RunTime + " microseconds");
				System.out.print("\tResults: ");
				printer.printArray(sortedArray4);
				System.out.println("5) Mergesort:\n");
				System.out.println("\tRuntime: " + array5RunTime + " microseconds");
				System.out.print("\tResults: ");
				printer.printArray(sortedArray5);
				System.out.println("6) HeapSort:\n");
				System.out.println("\tRuntime: " + array6RunTime + " microseconds");
				System.out.print("\tResults: ");
				printer.printArray(sortedArray6);

			//Else run algorithms on Integer arrays
			} else if (Integer.parseInt(type) == 1) {
				
				//Parse array into Integers
				Integer[] integerArray = new Integer[stringArray.length];
				for (int i = 0; i < stringArray.length; i++) integerArray[i] = Integer.parseInt(stringArray[i]);
				
				//Initialize classes
				Printer<Integer> printer = new Printer<Integer>();
				InsertionSort<Integer> inSort = new InsertionSort<Integer>();
				QuickSort<Integer> quickSort = new QuickSort<Integer>();
				QuickInsertionSort<Integer> quickInsertionSort = new QuickInsertionSort<Integer>();
				QuickSortMedianOf3<Integer> quickSortMedianOf3 = new QuickSortMedianOf3<Integer>();
				MergeSort<Integer> mergeSort = new MergeSort<Integer>();
				HeapSort<Integer> heapSort = new HeapSort<Integer>();
				
				//InsertionSort
				long array1Start = System.nanoTime();
				Integer[] sortedArray1 = inSort.sort(integerArray);
				long array1End = System.nanoTime();
				long array1RunTime = array1End - array1Start;

				//QuickSort
				long array2Start = System.nanoTime();
				Integer[] sortedArray2 = quickSort.sort(integerArray);
				long array2End = System.nanoTime();
				long array2RunTime = array2End - array2Start;

				//QuickSort switching to InsertionSort
				long array3Start = System.nanoTime();
				Integer[] sortedArray3 = quickInsertionSort.sort(integerArray, cutoff);
				long array3End = System.nanoTime();
				long array3RunTime = array3End - array3Start;

				//QuickSort median of 3 switching to InsertionSort
				long array4Start = System.nanoTime();
				Integer[] sortedArray4 = quickSortMedianOf3.sort(integerArray, cutoff);
				long array4End = System.nanoTime();
				long array4RunTime = array4End - array4Start;

				//MergeSort
				long array5Start = System.nanoTime();
				Integer[] sortedArray5 = mergeSort.sort(integerArray);
				long array5End = System.nanoTime();
				long array5RunTime = array5End - array5Start;

				//HeapSort
				long array6Start = System.nanoTime();
				Integer[] sortedArray6 = heapSort.sort(integerArray);
				long array6End = System.nanoTime();
				long array6RunTime = array6End - array6Start;

				//Print info
				System.out.println("1) InsertionSort:\n");
				System.out.println("\tRuntime: " + array1RunTime + " microseconds");
				System.out.print("\tResults: ");
				printer.printArray(sortedArray1);
				System.out.println("2) Quicksort:\n");
				System.out.println("\tRuntime: " + array2RunTime + " microseconds");
				System.out.print("\tResults: ");
				printer.printArray(sortedArray2);
				System.out.println("3) Quicksort switching to InsertionSort on arrays of size less than " + cutoff + ":\n");
				System.out.println("\tRuntime: " + array3RunTime + " microseconds");
				System.out.print("\tResults: ");
				printer.printArray(sortedArray3);
				System.out.println("4) Quicksort Median of 3 and switching to Insertion sort on arrays of size less than " + cutoff + ":\n");
				System.out.println("\tRuntime: " + array4RunTime + " microseconds");
				System.out.print("\tResults: ");
				printer.printArray(sortedArray4);
				System.out.println("5) Mergesort:\n");
				System.out.println("\tRuntime: " + array5RunTime + " microseconds");
				System.out.print("\tResults: ");
				printer.printArray(sortedArray5);
				System.out.println("6) HeapSort:\n");
				System.out.println("\tRuntime: " + array6RunTime + " microseconds");
				System.out.print("\tResults: ");
				printer.printArray(sortedArray6);
				
			}
			
			System.out.println("######################################################################################\n");
		}
		
		scanner.close();
	}
}
