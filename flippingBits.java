import java.util.*;

class Result {

    public static void main(String[] args) {

        System.out.println("Please enter an integer - range: 0 to 2^32 - 1. Integer is converted to binary, bits are flipped, and decimal number is returned.");

        Scanner scanner = new Scanner(System.in);
        // FIX-ME: error-handling
        long input = scanner.nextLong();

        System.out.println(flippingBits(input));
    }
    
    // Takes a long, converts to binary, flips bits, converts to decimal
    public static long flippingBits(long n) {
        
       int position = 32; // The number of bits  
       String bits = "";
       
       while (position > 0) {
           bits = ((n + 1) % 2) + bits; // n % 2 is last bit, so this appends flipped bit
           n = n / 2; // (n / 2) mod 2 is next bit that will be flipped
           position--; // Decremented, ensuring 32 bits
       }
       
       int pos = 0;
       long decimal = 0;
       
       while (pos < bits.length()) {
           if (bits.substring(pos, pos + 1).equals("1")) // If bit is a 1,
                decimal += (long) Math.pow(2, bits.length() - pos - 1); // add appropriate power of 2 to decimal
            pos++; 
       }
       
       return decimal;
    }
}