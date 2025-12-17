public class EnrollmentManager {
    private Enrollment[] enrollments = new Enrollment[100];
    private int count = 0;
    InputManager input = new InputManager();

    public void addTestData(){ // For adding test data
        enrollments[0] = new UndergraduateEnrollment("cs01085330", "chdg2342", "ali", "2", "Computer Science", 2);
        enrollments[1] = new PostgraduateEnrollment("cs01085331", "math3456", "abu", "2", "Data Science", "Dr. Brown");
        enrollments[2] = new UndergraduateEnrollment("cs01085332", "math3456", "jamal", "2", "Data Science", 1);
        count = 3;
    }
    public void showMenu(){ // Print menu options
        System.out.println("\n=== Course Enrollment System ===");
        System.out.println("1. Add Enrollment");
        System.out.println("2. Delete Enrollment");
        System.out.println("3. Update Enrollment");
        System.out.println("4. View Enrollments");
        System.out.println("5. Display Statistics");
        System.out.println("6. Exit");
        System.out.print("Choose: ");
    }

    public void addEnrollment() { // Add new enrollment into array
        if(count>=enrollments.length) {
            System.err.println("The enrollment is full");
            return;
        }
        String id = input.readEnrollID("Enter enrollment ID: ");
        if (id == null) {
            System.out.println("Invalid ID input. Please try again.");
            return;
        }
        String course = input.readCourseCode("Enter Course code: ");
        if (course == null) {
            System.out.println("Invalid course code input. Please try again.");
            return;
        }
        String name = input.readString("Enter student name: ");
        if (name == null) {
            System.out.println("Invalid name input. Please try again.");
            return;
        }
        String sem = input.readString("Enter semester: ");
        if (sem == null) {
            System.out.println("Invalid semester input. Please try again.");
            return;
        }

        System.out.println("Choose your level: ");
        System.out.println("1. Under Graduate");
        System.out.println("2. Post Graduate");
        int level = input.readInt("Level: ");

        if (level==1) {
            String program = input.readString("Enter program name: ");
            int year = input.readInt("Enter year: ");
            enrollments[count] = new UndergraduateEnrollment(id, course, name, sem, program, year);
            count++;
            System.out.println("Enrollment added successfully");
        }

        else if (level==2) {
            String researchArea = input.readString("Enter research area: ");
            String supervisorName = input.readString("Enter supervisor name: ");
            enrollments[count] = new PostgraduateEnrollment(id, course, name, sem, researchArea, supervisorName);
            count++;
            System.out.println("Enrollment added successfully");
        } 

        else {
            System.out.println("Invalid level");
        }

    }
    
    public void deleteEnrollment() { // Delete enrollment from array
        String id = input.readEnrollID("Enter enrollment ID to delete: ");

        for (int i = 0; i < count; i++) {
            if (enrollments[i].getID().equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    enrollments[j] = enrollments[j + 1];
                }
                enrollments[count - 1] = null;
                count--;
                System.out.println("Enrollment deleted successfully.");
                return;
            }
        }
        System.out.println("Enrollment ID not found.");
    }

    public void updateEnrollment(){ // Update existing enrollment (course code, program/year or research area/supervisor)
        String id = input.readEnrollID("Enter enrollment ID to update: ");

        int index = -1;

        for (int i = 0; i < count; i++) { // to find the enrollment by ID
            if (enrollments[i].getID().equals(id)) {
                index = i; // Get the matching enrollment index
                break;
            }
        }

        if (index == -1){ // If none found; index remains -1, show error message
            System.out.println("Enrollment ID not found.");
            return;
        }

        Enrollment oldEnrollment = enrollments[index];
        System.out.println("Enrollment found. Proceed to update.\n");
        String newCourse = input.readCourseCode("Enter new course code: "); // Get new course code

        if (oldEnrollment instanceof UndergraduateEnrollment) {  // Check enrollment type
            String newProgram = input.readString("Enter new program name: ");
            int newYear = input.readInt("Enter new study year: ");
            enrollments[index] = new UndergraduateEnrollment(oldEnrollment.getID(), newCourse, oldEnrollment.getStudent(), oldEnrollment.getSem(), newProgram, newYear);

        } else if (oldEnrollment instanceof PostgraduateEnrollment) {
            String newResearchArea = input.readString("Enter new research area: ");
            String newSupervisorName = input.readString("Enter new supervisor name: ");
            enrollments[index] = new PostgraduateEnrollment(oldEnrollment.getID(), newCourse, oldEnrollment.getStudent(), oldEnrollment.getSem(), newResearchArea, newSupervisorName);
        }
        
    }


    public void displayEnrollment(int filterType) {
        String filterValue = null;

        switch (filterType) {
            case 1:
                filterValue = input.readString("Enter student name: ");
                break;
            case 2:
                filterValue = input.readCourseCode("Enter course code: ");
                break;
            case 3:
                filterValue = input.readString("Enter semester: ");
                break;
            case 4:
                filterValue = input.readString("Enter level (UG/PG): ");
                break;
            case 5: 
                viewAll();
                return;
            default:
                System.out.println("Invalid filter type.");
                return;
        }

        if (filterValue == null) { // Input validation
            System.out.println("Invalid input. Please try again.");
            return;
        }

        filterValue = filterValue.toUpperCase();

        int num = 0; // to count number of matched records
        boolean found = false;

        for (int i = 0; i < count; i++) { // Loop through enrollments
            Enrollment e = enrollments[i]; // current enrollment object
            boolean matches = false; // to check if it matches the filter
            switch (filterType) {
                case 1:
                    String studentName = e.getStudent();
                    matches = studentName.equals(filterValue);
                    break;

                case 2:
                    String courseCode = e.getCourse();
                    matches = courseCode.equals(filterValue);
                    break;
                case 3:
                    String semester = e.getSem();
                    matches = semester.equals(filterValue);
                    break;
                case 4:
                    if (filterValue.equals("UG") && e instanceof UndergraduateEnrollment) {
                        matches = true;
                    } else if (filterValue.equals("PG") && e instanceof PostgraduateEnrollment) {
                        matches = true;
                    }
                    break;

                default:
                    System.out.println("Invalid filter type.");
                    return;
            }

            if (matches){ // if matched, display the enrollment
                num += 1;
                if (num == 1) { // if first matched record, print header
                    System.out.println("\n\n====Filtered Enrollment List====");
                    found = true;
                }
                System.out.println("\n------Record " + (num) + " ------"); // display numbered record
                System.out.println(e); // print current enrollment details 
            }
        }
        if (!found) { // if no records matched, show message
            System.out.println("No enrollments found matching the criteria.");
        }
    }

    public void viewAll() { // View all enrollments
            if(count==0) {
                System.out.println("The enrollment list is empty");
                return;
            }

            System.out.println("\n\n====All the enrollment list====");
            for(int i =0; i<count; i++) {
                System.out.println("\n------Record " + (i + 1) + " ------");
                System.out.println(enrollments[i]);
            }
        }


    public void displayStatistics(){ // Display total number of UG and PG enrollments
        int pgCount = 0;
        int ugCount = 0;
        for (int i = 0; i < count; i++){
            if (enrollments[i] instanceof PostgraduateEnrollment){
                pgCount++;
            } else if (enrollments[i] instanceof UndergraduateEnrollment){
                ugCount++;
            }
        }
        System.out.println("Total Undergraduate Enrollments: " + ugCount);
        System.out.println("Total Postgraduate Enrollments: " + pgCount);

    }
}