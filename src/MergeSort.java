import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MergeSort {

	/**
	 * Internal method that merges two sorted halves of a subarray (from Weiss Data Structures and Algorithm Analysis in Java)
	 * @param a an array of Comparable items.
	 * @param tmpArray an array to place the merged result.
	 * @param leftPos the left-most index of the subarray.
	 * @param rightPos the index of the start of the second half.
	 * @param rightEnd the right-most index of the subarray.
	 */
	private static void merge(Integer[] a, Integer[] tmpArray, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		// Main loop
		while(leftPos <= leftEnd && rightPos <= rightEnd) {
			if( a[leftPos] <= a[rightPos ]) { 
				tmpArray[tmpPos++] = a[leftPos++];
			} else {
				tmpArray[tmpPos++] = a[rightPos++];
			}   
		}  
		while( leftPos <= leftEnd ) {   // Copy rest of first half
			tmpArray[tmpPos++] = a[leftPos++];

		}

		while( rightPos <= rightEnd ) { // Copy rest of right half
			tmpArray[tmpPos++] = a[rightPos++];
		}

		// Copy tmpArray back
		for( int i = 0; i < numElements; i++, rightEnd-- ) {
			a[rightEnd] = tmpArray[rightEnd];
		}
	}

	/**
	 * Merge Sort algorithm.
	 * This is the Merge Sort algorithm from from Weiss, Data Structures and Algorithm Analysis in Java, 
	 * as presented in class. 
	 * @param a an array of Comparable items.
	 */
	public static void mergeSort(Integer[] a ) {
		Integer[] tmpArray = new Integer[a.length];
		mergeSort(a, tmpArray, 0, a.length - 1 );
	}
	/**
	 * Internal method that makes recursive calls. 
	 * This is part of the MergeSort algorithm from from Weiss, Data Structures and Algorithm Analysis in Java, 
	 * as presented in class. 
	 * @param a an array of Comparable items.
	 * @param tmpArray an array to place the merged result.
	 * @param left the left-most index of the subarray.
	 * @param right the right-most index of the subarray.
	 */
	private static void mergeSort(Integer[] a, Integer[] tmpArray, int left, int right) {
		if(left < right) {
			int center = (left + right) / 2;
			mergeSort(a, tmpArray, left, center);
			mergeSort( a, tmpArray, center + 1, right);
			merge(a, tmpArray, left, center + 1, right);
		}
	}


	/** 
	 * Problem 5: Iterative Bottom-up Merge Sort
	 */
	public static void mergeSortB(Integer[] inputArray) 
	{
		int sliceSize = 2;
		ArrayList<int []> list = new ArrayList<int []>();


		for(int j = 0; j < inputArray.length; j++){
			//System.out.print(inputArray[j] + ", ");
		}

		System.out.println("");
		//while(list.size() != 1 )
		//{
		int numFrames = inputArray.length/sliceSize;
		int [] tempArray = new int[sliceSize];
		int counter = 0;
		boolean isOdd = false;

		if(inputArray.length % 2 != 0){
			numFrames++;
			isOdd = true;
		}

		for(int i = 0; i < inputArray.length; i++)
		{
			tempArray[counter] = inputArray[i];
			counter++;

			if(counter >= sliceSize)
			{
				list.add(tempArray);
				//System.out.print("[ " + tempArray[0] + ", " + tempArray[1] + "], \n");
				tempArray = new int[sliceSize];
				counter = 0;
			}
			if (isOdd == true && i == inputArray.length-1){
				int [] lonelyTemp = new int[1];
				//System.out.println("[ " + lonelyTemp[0] + " ]");
				list.add(lonelyTemp);

			}
		}

		for(int i = 0; i < list.size(); i++)
		{
			//System.out.println(list.get(i));
			int [] temp = list.get(i);


			if(temp.length == 2 && temp[0] > temp[1])
			{
				int temp1 = temp[0];
				temp[0] = temp[1];
				temp[1] = temp1;
			}	
			list.set(i, temp);
		}
		sliceSize = sliceSize * 2;
		int [] mergeArray = new int[sliceSize];
		int [] mergeArray1 = new int[sliceSize/2];
		int [] mergeArray2 = new int[sliceSize/2];

		for(int i = 0; i < list.size(); i = i + 2)
		{
			mergeArray1 = list.get(i);
			mergeArray2 = list.get(i+1);
			counter = 0;

			for(int j = 0; j < mergeArray1.length; j++){
				mergeArray[counter] = mergeArray1[j];
				counter++;
			}
			for(int j = 0; j < mergeArray2.length; j++){
				mergeArray[counter] = mergeArray2[j];
				counter++;
			}

			list.set(i, mergeArray);
			list.remove(i+1);
		}

		for(int i = 0; i < list.size(); i++){
			int [] temp = list.get(i);
			for(int j = 0; j < temp.length; j++){
				System.out.println(temp[j]);
			}
		}


	}			



	/** 
	 * Problem 6: Merge Sort for Lists, Without Side Effects
	 */
	public static List<Integer> sortList(List<Integer> inputList) 
	{


		return null;
	}


	/**
	 * New merge method that merges two lists and returns a new list.
	 * Use this method to implement sortList.
	 */
	public static List<Integer> mergeLists(List<Integer> left, List<Integer> right) { 

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int leftPos = 0;
		int rightPos = 0;
		int leftEnd = left.get(left.size()-1);
		int rightEnd = right.get(right.size()-1);


		while(leftPos <= leftEnd && rightPos <= rightEnd) 
		{
			if( left.get(leftPos) < right.get(rightPos)) 
			{ 
				list.add(left.get(leftPos));
				leftPos++;
			}
			else
			{
				list.add(right.get(rightPos));
				rightPos++;
			}

		}  
		while( leftPos <= leftEnd ) 
		{   
			list.add(left.get(leftPos));
			leftPos++;

		}

		while( rightPos <= rightEnd ) 
		{ 
			list.add(right.get(rightPos));
			rightPos++;
		}
		return list;
	}





	public static void main(String[] args) {
		// Weiss sort
		Integer[] a = {1,4,9,131,0,2,7,19,245,18};
		Integer[] b = {1,4,9,131,0,2,7,19,245,18,34};

		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer> testList2 = new ArrayList<Integer>();

		testList.add(1);
		testList.add(4);
		testList.add(5);
		testList.add(7);
		testList.add(16);
		testList.add(50);


		testList2.add(1);
		testList2.add(3);
		testList2.add(9);
		testList2.add(14);
		testList2.add(36);
		testList2.add(42);


		System.out.println(mergeLists(testList, testList2));


		//MergeSort.mergeSort(a);
		//System.out.println(Arrays.toString(a)); // Should be [0, 1, 2, 4, 7, 9, 18, 19, 131, 245]
	}

}
