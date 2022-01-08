import java.util.*;

class Birthday {

    public static void main(String[] args) {
        
        System.out.println("Please enter a list of space separated integers and your birthday month (m) and date (d). The number of times m consecutive array entries add to d is returned.");

        Scanner scanner = new Scanner(System.in);
        String list = scanner.nextLine();
        // Converting list to an array
        String [] arr = list.split(" ");
        int [] intArr = new int [arr.length];

        // Converting original array of strings to integers (FIX-ME: error-handling)
        for (int i = 0; i < intArr.length; i++) {
           intArr[i] = Integer.parseInt(arr[i]);
        }

        System.out.println("Please enter your birthday month (number).");
        int m = scanner.nextInt();

        System.out.println("Please enter your birthday date.");
        int d = scanner.nextInt();

        System.out.println(birthday(intArr, d, m));    

        scanner.close();
    }
    
    // Returns number of times m (month) consecutive array entries add to d (day)
    public static int birthday(int [] arr, int d, int m) {
    
        int count = 0;
        int sum = 0;
        
        // The last m - 1 positions cannot be starter positions 
        for (int i = 0; i < arr.length - (m - 1); i++) { 
            for (int j = i; j < m + i; j++) { // Starting at i, 
                sum += arr[j]; // we add m consecutive numbers
            }
            if (sum == d) count++;
            sum = 0;
        }
        
        return count;
    }
}

