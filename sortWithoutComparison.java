import java.util.*;

class SortWithoutComparison {

    public static void main(String[] args) {

        System.out.println("Please enter a space separated list of non-negative integers. The list will be sorted in ascending order.");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] array = input.split(" "); // Creating array

        // Converting string array to int array
        int [] array2 = new int [array.length];
        for (int i = 0; i < array.length; i++) {
            array2[i] = Integer.parseInt(array[i]);
        }

        // Sorting array of ints
        int [] sortedArray = countingSort(array2);

        // Printing
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }

        scanner.close();
    }

    public static int [] countingSort(int [] arr) {

        int max = arr[0]; // Get max of input array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        
        int [] frequencies = new int[max + 1]; // Create frequency array, size is max + 1 (max + 1 numbers between 0 and max inclusive). All entries automatically set to 0.
        
        for (int i = 0; i < arr.length; i++) { // For each element of array,
            // arr[i] is between 0 and max inclusive.
            // Set this as index in frequency array,
            // increase the current frequency by 1.       
            frequencies[arr[i]]++;
        } 

        int [] sorted = new int[arr.length]; // Sorted array has same length as input array

        // IDEA: Given position i in frequencies array, the entry at position i is the number of times i appears in original array 
        int positionInSorted = 0;
        for (int i = 0; i < frequencies.length; i++) {
            for (int j = 0; j < frequencies[i]; j++) {
                sorted[positionInSorted] = i;
                positionInSorted++;
            }
        }
        
        return sorted;
    }
}