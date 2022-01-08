import java.util.*;

class DiagonalDifference {

    public static void main(String[] args) {

        System.out.println("Input: n lists of n comma separated integers. This input represents a square matrix. The absolute difference of the sums of the diagonals is returned.");

        System.out.println("Please enter the size of the matrix.");
 
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt(); // Size of square matrix

        int [][] arr = new int [size][size]; // To store matrix entries
        for (int i = 0; i < size; i++) {
            System.out.println("Please enter row " + (i + 1) + " of your " + size + "x" + size + " matrix.");

            String row = scanner.next();
            String [] array = row.split(",");
            for (int j = 0; j < size; j++) { // Store row i + 1 entries
                arr[i][j] = Integer.parseInt(array[j]);
            }
        }

        System.out.println(diagonalDifference(arr)); // Print out difference

        scanner.close();
    }

// Computes the absolute difference for a square matrix' diagonal sums
    public static int diagonalDifference(int [][] arr) {
        
        int size = arr.length; // Get length of matrix
        
        int sumLeftToRightDiagonal = 0; 
        
        for (int i = 0; i < size; i++) { // Left to right diagonal entries are 
            sumLeftToRightDiagonal += arr[i][i]; // at position (i,i)   
        }
        
        int sumRightToLeftDiagonal = 0;
        
        for (int j = 0; j < size; j++) { // Right to left diagonal entries are at
            sumRightToLeftDiagonal += arr[j][size - j - 1]; // (j, size-j-1)   
        }
        
        return Math.abs(sumLeftToRightDiagonal - sumRightToLeftDiagonal);
    }
}