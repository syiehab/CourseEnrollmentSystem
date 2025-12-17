import java.util.Scanner;

public class InputManager {
    private Scanner sc = new Scanner(System.in);

    public InputManager(){
    }
    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Please enter a number.");
                continue;
            }

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public String readEnrollID(String prompt) {
        while (true) {
            System.out.print(prompt);
            String id = sc.nextLine().trim();

            if (id.matches("^[A-Za-z]{2}[0-9]{8}$")) {
                return id.toLowerCase(); 
            }

            System.out.println("Invalid ID. Example: cs00190123 (2 letters + 8 digits)");
        }
    }

    public String readCourseCode(String prompt) {
        while (true) {
            System.out.print(prompt);
            String code = sc.nextLine().trim();

            if (code.matches("^[A-Za-z]{3,4}[0-9]{4}$")) {
                return code.toLowerCase(); 
            }

            System.out.println("Invalid course code. Example: chdg2342 (4 letters + 4 digits)");
        }
    }

    public String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("This field cannot be empty.");
        }
    }

    public String readString(String prompt) {
        while (true) {
            String str = readNonEmpty(prompt);
            return str;
        }
    }
}