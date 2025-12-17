
    public class Main{

        static EnrollmentManager manager = new EnrollmentManager(); // Enrollment manager instance
        static InputManager input = new InputManager(); // INput manager instance
        public static void main(String[] args) {
            int choice;
            System.out.println("Welcome to Course Enrollment");
            System.out.println("Please choose the options below");

            manager.addTestData(); // To add test data into the array

            while (true) {
                manager.showMenu();
                choice = input.readInt("");
                switch (choice) {
                case 1 : // Add enrollment
                    manager.addEnrollment();
                    break;
                case 2 : // Delete enrollment
                    manager.deleteEnrollment();
                    break;
                case 3: // Update enrollment
                    manager.updateEnrollment();
                    break;
                case 4: // View enrollments
                    System.out.println("\nChoose to view by: ");
                    System.out.println("1. Student Name");
                    System.out.println("2. Course code");
                    System.out.println("3. Semester");
                    System.out.println("4. Level");
                    System.out.println("5. All");
                    int filterType = input.readInt("Enter your choice: ");
                    manager.displayEnrollment(filterType);
                    break;
                case 5: // Display statistics
                    manager.displayStatistics();
                    break;
                case 6: // Exit
                    System.out.println("Thank you for using this system");
                    return;
                default: // Invalid option
                    System.out.println("The option is invalid");           
                }

            }
            
        }

    }


