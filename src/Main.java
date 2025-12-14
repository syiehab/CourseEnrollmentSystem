import java.util.Scanner;

public class Main{
    static Enrollment[] enrollments = new Enrollment[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        System.out.println("Welcome to Course Enrollment");
        System.out.println("Please choose the options below");

        

        while (true) {
            System.out.println("\n=== Course Enrollment System ===");
            System.out.println("1. Add Enrollment");
            System.out.println("2. View All");
            System.out.println("3. Delete Enrollment");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
            case 1 :
                addEnrollment();
                break;
            case 2 :
                viewAll();
                break;
            case 3:
                //deleteEnrollment;
                break;
            case 0:
                System.out.println("Thank you for using this system");
                return;
            default:
                System.out.println("The option is invalid");           
                System.out.print("Choose: ");
                choice = Integer.parseInt(sc.nextLine());        
            }

        }
        
        
    }

    static int readInt(String prompt) {
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

    static String readEnrollID(String prompt) {
    while (true) {
        System.out.print(prompt);
        String id = sc.nextLine().trim();

        if (id.matches("^[A-Za-z]{2}[0-9]{8}$")) {
            return id.toLowerCase(); 
        }

        System.out.println("Invalid ID. Example: cs00190123 (2 letters + 8 digits)");
    }
}

static String readCourseCode(String prompt) {
    while (true) {
        System.out.print(prompt);
        String code = sc.nextLine().trim();

        if (code.matches("^[A-Za-z]{4}[0-9]{4}$")) {
            return code.toLowerCase(); 
        }

        System.out.println("Invalid course code. Example: chdg2342 (4 letters + 4 digits)");
    }
}

static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("This field cannot be empty.");
        }
    }

static String readName(String prompt) {
        while (true) {
            String name = readNonEmpty(prompt);
            if (name.matches("[a-zA-Z ]+")) return name;
            System.out.println("Invalid name. Use letters only.");
        }
    }


    static void addEnrollment() {
        if(count>=enrollments.length) {
            System.err.println("The enrollment is full");
            return;
        }

        String id = readEnrollID("Enter enrollment ID: ");

        String course = readCourseCode("Enter Course code: ");

        String name = readName("Enter student name: ");

        String sem = readName("Enter semester: ");

        System.out.println("Choose your level: ");
        System.out.println("1. Under Graduate");
        System.out.println("2. Post Graduate");
        int level = readInt("Level: ");

        if (level==1) {
            String program = readName("Enter program name: ");
            int year = readInt("Enter year: ");

            enrollments[count] = new UndergraduateEnrollment(id, course, name, sem, program, year);
            count++;
            System.out.println("Enrollment added successfully");
        } 

        else if (level==2) {
            String researchArea = readName("Enter research area: ");
            String supervisorName = readName("Enter supervisor name: ");

            enrollments[count] = new PostgraduateEnrollment(id, course, name, sem, researchArea, supervisorName);
            count++;
            System.out.println("Enrollment added successfully");
        } 

        else {
            System.out.println("Invalid level");
        }

    }

    static void viewAll() {
            if(count==0) {
                System.out.println("The enrollment list is empty");
                return;
            }

            System.out.println("====All the enrollment list====");
            for(int i =0; i<count; i++) {
                System.out.println("------Record " + (i + 1) + " ------");
                System.out.println(enrollments[i]);
            }
        }
}