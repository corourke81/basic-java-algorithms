import java.util.*;

class FirstSoloInteger {

    public static void main(String[] args) {

        System.out.println("Please enter a list of comma separated integers. The first integer that occurs only once will be returned. If no integer occurs only once, -1 is returned.");
 
        Scanner scanner = new Scanner(System.in);
        String list = scanner.nextLine();
        // Converting list to an array
        String [] arr = list.split(",");
        int [] arr2 = new int [arr.length];
 
        // Converting original array of strings to integers (FIX-ME: error-handling)
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(arr[i]);
        }
        
        System.out.println(firstSoloInteger(arr2));
     }

    // Method takes an array of integers of input, and returns the FIRST integer that occurs only once. If no integer occurs only once, return -1.
    public static int firstSoloInteger(int [] arr) {
        
        for (int i = 0; i < arr.length; i++) { // Traverse list
            int count = 1; // Indicates an integer occurs once at position i
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j) { // If integer occurs again at a different position,
                    count = 2; // change count and stop traversing inner loop
                    break;
                }
            }
            if (count == 1) { // If count is 1,
                return arr[i]; // no duplicates of position i integer, return integer
            }
        }
        return -1; // if no integer occurs only once
    }
}