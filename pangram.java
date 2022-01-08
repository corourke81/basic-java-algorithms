import java.util.*;

class Pangram {

    public static void main(String[] args) {

        System.out.println("A pangram is a sentence that contains all letters of the alphabet. Pleae enter a sentence, and it will be checked to see if it is a pangram.");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(pangrams(input));

        scanner.close();
    }
    
    // Takes a string of characters and returns whether it contains all letters of alphabet
    public static String pangrams(String s) {
        
        String lowerCase = s.toLowerCase();
        String lettersOnly = "";
        int alphabetLength = 26;
        
        // Append (lower case) letters only to lettersOnly. IDEA: a has ASCII value 97
        for (int i = 0; i < s.length(); i++) {
            if (lowerCase.charAt(i) >= 97 && lowerCase.charAt(i) < 97 + alphabetLength) {
                lettersOnly += lowerCase.charAt(i);
            }  
        }
        
        int [] frequencies = new int [alphabetLength]; // Will store frequencies
                                                       // of letters                     
        // Looping over characters of lettersOnly                                 
        for (int i = 0; i < lettersOnly.length(); i++) {
            // Frequency of character is incremented based on ASCII value  
            frequencies[lettersOnly.charAt(i) - 97]++;
        }
        
        // Frequencies now checked, if any are zero, return
        for (int i = 0; i < alphabetLength; i++) {
            if (frequencies[i] == 0) {
               return "not pangram";   
            } 
        }
        
        return "pangram";
    }
}

