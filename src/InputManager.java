import java.util.Scanner;

// Our InputManager class to handle user inputs and validations
public class InputManager {
    private Scanner sc = new Scanner(System.in);
    int MAX_RETRIES = 3;

    public int readInt(String prompt) { // Read integer with validation

        System.out.print(prompt);

        try {
            int number = sc.nextInt();
            sc.nextLine(); // Clear the buffer
            return number;
        } catch (Exception e) {
            System.out.println("Invalid number. Try again.");
            sc.nextLine();
        }
        
        return -1;
    }

    public String readEnrollID(String prompt) {
        for (int i = 0 ; i < MAX_RETRIES; i++) {
            System.out.print(prompt);
            String id = sc.nextLine().trim();

            if (id.matches("^[A-Za-z]{2}[0-9]{8}$")) { // EnrollID pattern validation
                return id.toUpperCase(); 
            }

            System.out.println("Invalid ID. Example: cs00190123 (2 letters + 8 digits)");
        }
        return null;
    }

    public String readCourseCode(String prompt) {
        for (int i = 0 ; i < MAX_RETRIES; i++) {
            System.out.print(prompt);
            String code = sc.nextLine().trim();

            if (code.matches("^[A-Za-z]{3,4}[0-9]{4}$")) { // Course code pattern validation
                return code.toUpperCase(); 
            }
            System.out.println("Invalid course code. Example: chdg2342 (4 letters + 4 digits)");
        }
        return null;
    }

    public String readNonEmpty(String prompt) { // Read non-empty string
        for (int i = 0 ; i < MAX_RETRIES; i++) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("This field cannot be empty.");
        }
        return null;
    }

    public String readString(String prompt) {
        while (true) {
            String str = readNonEmpty(prompt);
            return str;
        }
    }
}