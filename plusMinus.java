import java.text.*;
import java.util.*;

class PlusMinus {

    public static void main(String[] args) {

       System.out.println("Please enter a list of comma separated integers. The ratios of positive, negative and zero numbers will be returned to exactly 6 decimal places.");

       Scanner scanner = new Scanner(System.in);
       String list = scanner.nextLine();
       // Converting list to an array
       String [] arr = list.split(",");
       int [] arr2 = new int [arr.length];

       // Converting original array of strings to integers (FIX-ME: error-handling)
       for (int i = 0; i < arr2.length; i++) {
           arr2[i] = Integer.parseInt(arr[i]);
       }
       
       double [] ratios = plusMinus(arr2);
       // To ensure that ratios are returned to exactly 6 decimal places
       DecimalFormat df = new DecimalFormat("0.000000");
       // Ratios printed to 6 decimal places with DecimalFormat df
       for (int i = 0; i < ratios.length; i++) {
           System.out.println(df.format(ratios[i]));
       }
    }
    
    // Method returns ratio of positive, negative and zero numbers in an array
    public static double [] plusMinus(int [] arr) {
    
        double numOfPositiveIntegers = 0;
        double numOfNegativeIntegers = 0;
        double numOfZeroes = 0;
        
        // Looping over array, above variables are incremented depending on
        // status of number in each position
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                numOfPositiveIntegers++;
            if (arr[i] < 0)
                numOfNegativeIntegers++;
            if (arr[i] == 0) 
                numOfZeroes++; 
        }
        
        // Ratios
        double ratioOfPositives = numOfPositiveIntegers / arr.length; 
        double ratioOfNegatives = numOfNegativeIntegers / arr.length;             
        double ratioOfZeroes = numOfZeroes / arr.length;

        double [] ratios = {ratioOfPositives, ratioOfNegatives, ratioOfZeroes};
        
        return ratios;                
    }
}