import java.util.*;

class TimeConversion {

    public static void main(String [] args) {

        System.out.println("Please enter a valid am/pm time. The time will be converted to military time. Valid input format is xx:xx:xxAM or xx:xx:xxPM");

        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();

        System.out.println(timeConversion(time));
    }

    // Method converts am/pm time to military time
    // FIX-ME: error-handling
    public static String timeConversion(String s) {
    
        // IDEA: Minutes and seconds stay the same. Hours may change, and AM/PM is dropped
        int hours = Integer.parseInt(s.substring(0,2));
        String ampm = s.substring(s.length() - 2);
        String militaryTime = "";
        
        // Standard time conversion operations
        if (hours < 12 && ampm.equals("AM")) {
            militaryTime = s.substring(0, s.length() - 2);
        } else if (hours < 12 && ampm.equals("PM")) {
            militaryTime = (hours + 12) + s.substring(2, s.length() - 2);
        } else if (hours == 12 && ampm.equals("PM")) {
            militaryTime = s.substring(0, s.length() - 2);
        } else if (hours == 12 && ampm.equals("AM")) {
            militaryTime = "00" + s.substring(2, s.length() - 2);  
        }
        
        return militaryTime;
    }
}