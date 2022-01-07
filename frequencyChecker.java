import java.util.*;

class FrequencyChecker {

    public static void main(String[] args) {

       System.out.println("Input: Two lists of comma separated strings - inputs and queries. The frequency of the queries in the input list are returned. Please enter the input list.");

       Scanner scanner = new Scanner(System.in);
       String listOfInputs = scanner.nextLine();
       // Converting list to an array
       String [] inputs = listOfInputs.split(",");

       System.out.println("Please enter the query list.");
       
       String listOfQueries = scanner.nextLine();
       String [] queries = listOfQueries.split(",");
       
       int [] frequencies = matchingStrings(inputs, queries);
       for (int i = 0; i < frequencies.length; i++) {
           System.out.print(frequencies[i] + " ");
       }
    }

    // Method to list the number of times each query occurs
    public static int [] matchingStrings(String [] strings, String [] queries) {
        
        // Initial query frequencies are 0
        int [] queryFrequencies = new int[queries.length];
        
        // Compare each query string with each input string
        // If equal, set queryFrequencies value at position i to 1 more 
        // than previous value
        // NOTE: Whitespace at beginning and end is ignored
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (queries[i].trim().equals(strings[j].trim())) {
                    queryFrequencies[i]++;
                }
            }
        }
        
        return queryFrequencies;  
    }
}

