import java.util.*;

class ReorderingArrays {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter two space separated lists of the same length, and an integer k. Program checks if lists can be rearranged so that list entries at same position sum to greater than or equal to k.");

        System.out.println();
        
        System.out.println("Please enter your first list...");
        String list1 = scanner.nextLine();
        String [] strArr1 = list1.split(" ");
        int [] intArr1 = new int [strArr1.length];
        for (int i = 0; i < intArr1.length; i++) {
            intArr1[i] = Integer.parseInt(strArr1[i]);
        }

        System.out.println("Please enter your second list...");
        String list2 = scanner.nextLine();
        String [] strArr2 = list2.split(" ");
        int [] intArr2 = new int [strArr2.length];
        for (int i = 0; i < intArr2.length; i++) {
            intArr2[i] = Integer.parseInt(strArr2[i]);
        }

        System.out.println("Please enter your integer.");
        int k = scanner.nextInt();

        System.out.println(twoArrays(k, intArr1, intArr2));

        scanner.close();
    }

    // Checks if two arrays A,B can be reordered so that A[i] + B[i] >= k, all i
    public static String twoArrays(int k, int [] A, int [] B) {
        
        // Bubble sort descending
        for (int j = 0; j < A.length; j++) {
            for (int i = 0; i < A.length - j - 1; i++) {
                if (A[i] < A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }   
        }
        
        // Bubble sort ascending
        for (int j = 0; j < B.length; j++) {
            for (int i = 0; i < B.length - j - 1; i++) {
                if (B[i] > B[i + 1]) {
                    int temp = B[i];
                    B[i] = B[i + 1];
                    B[i + 1] = temp;
                }
            }   
        }
        
        // IDEA: greatest + least < k? If so, 
        // anything else + least < k. 
        
        for (int i = 0; i < A.length; i++) {
            // If sum of corresponding entries is ever less than k
            if (A[i] + B[i] < k) return "NO";
        }
        
        // Otherwise
        return "YES";
    }
}