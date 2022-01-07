import java.util.*;

class MinMaxSum {

    public static void main(String[] args) {

       System.out.println("Please enter a list of comma separated integers. The sum of all integers bar the maximum, and the sum of all integers bar the minimum will be respectively returned.");

       Scanner scanner = new Scanner(System.in);
       String list = scanner.nextLine();
       // Converting list to an array
       String [] arr = list.split(",");
       int [] arr2 = new int [arr.length];

       // Converting original array of strings to integers (FIX-ME: error-handling)
       for (int i = 0; i < arr2.length; i++) {
           arr2[i] = Integer.parseInt(arr[i]);
       }

       long [] minAndMax = minMaxSum(arr2);
       
       System.out.println(minAndMax[0] + " " + minAndMax[1]);
    }

    public static long [] minMaxSum(int [] arr) {
        
        long totalSum = 0; 
        int min = arr[0]; // Initial min and max set to array's first entry
        int max = arr[0];
        
        // Looping over arr to get max, min and total sum of array entries
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
            totalSum += arr[i];
        }
        
        long minSum = totalSum - max; // Sum of smallest 4 is totalSum minus max
        long maxSum = totalSum - min; // Sum of greatest 4 is totalSum minus min
        
        long [] sums = {minSum, maxSum};
        return sums;
    }
}