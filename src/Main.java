
    public class Main{

        static EnrollmentManager manager = new EnrollmentManager();
        static InputManager input = new InputManager();
        public static void main(String[] args) {
            int choice;
            System.out.println("Welcome to Course Enrollment");
            System.out.println("Please choose the options below");

            manager.addTestData(); // Add test data

            while (true) {
                manager.showMenu();
                choice = input.readInt("");
                switch (choice) {
                case 1 :
                    manager.addEnrollment();
                    break;
                case 2 :
                    manager.deleteEnrollment();
                    break;
                case 3:
                    manager.updateEnrollment();
                    break;
                case 4:
                    System.out.println("Choose to view by: ");
                    System.out.println("1. Student Name");
                    System.out.println("2. Course code");
                    System.out.println("3. Semester");
                    System.out.println("4. Level");
                    System.out.println("5. All");
                    int filterType = input.readInt("Enter your choice: ");
                    manager.displayEnrollment(filterType);
                    break;
                case 5:
                    System.out.println("Thank you for using this system");
                    return;
                default:
                    System.out.println("The option is invalid");           
                }

            }
            
        }

    }


