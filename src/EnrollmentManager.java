public class EnrollmentManager {
    private Enrollment[] enrollments = new Enrollment[100];
    private int count = 0;
    InputManager input = new InputManager();

    public void addTestData(){
        enrollments[0] = new UndergraduateEnrollment("cs00190123", "chdg2342", "Alice Smith", "2", "Computer Science", 2);
        enrollments[1] = new PostgraduateEnrollment("pg00280123", "math3456", "Bob Johnson", "2", "Data Science", "Dr. Brown");
        enrollments[2] = new UndergraduateEnrollment("pg00280123", "math3456", "Bob Johnson", "2", "Data Science", 1);
        count = 3;
    }
    public void showMenu(){
        System.out.println("\n=== Course Enrollment System ===");
        System.out.println("1. Add Enrollment");
        System.out.println("2. Delete Enrollment");
        System.out.println("3. Update Enrollment");
        System.out.println("4. View Enrollments");
        System.out.println("5. Exit");
        System.out.print("Choose: ");
    }

    public void addEnrollment() {
        if(count>=enrollments.length) {
            System.err.println("The enrollment is full");
            return;
        }

        String id = input.readEnrollID("Enter enrollment ID: ");
        String course = input.readCourseCode("Enter Course code: ");
        String name = input.readString("Enter student name: ");
        String sem = input.readString("Enter semester: ");

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
    
    public void deleteEnrollment() {
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

    public void updateEnrollment(){
        String id = input.readEnrollID("Enter enrollment ID to update: ");

        for (int i = 0; i < count; i++) {
            if (enrollments[i].getID().equals(id)) {
            System.out.println("Enrollment found. Proceed to update.");
                return;
            }
        }
        System.out.println("Enrollment ID not found.");
    }


public void displayEnrollment(int filterType) {
    String filterValue = "";

    switch (filterType) {
        case 1:
            filterValue = input.readString("Enter student name: ");
            break;
        case 2:
            filterValue = input.readNonEmpty("Enter semester: ");
            break;
        case 3:
            filterValue = input.readCourseCode("Enter course code: ");
            break;
        case 4:
            filterValue = input.readNonEmpty("Enter level (UG/PG): ").toLowerCase(); // Normalize to lowercase for comparison
            break;
        case 5:
            viewAll();
            return;
        default:
            System.out.println("Invalid filter type.");
            return;
    }

    for (int i = 0; i < count; i++) {
        Enrollment e = enrollments[i];
        boolean matches = false;
        boolean found = false;
        int num = 0;
        switch (filterType) {
            case 1:
                String studentName = e.getStudent().toLowerCase();
                matches = studentName.equals(filterValue);
                break;

            case 2:
                String semester = e.getSem().toLowerCase();
                matches = semester.equals(filterValue);
                break;

            case 3:
                String courseCode = e.getCourse().toLowerCase();
                matches = courseCode.equals(filterValue);
                break;

            case 4:
                if (filterValue.equals("ug") && e instanceof UndergraduateEnrollment) {
                    matches = true;
                } else if (filterValue.equals("pg") && e instanceof PostgraduateEnrollment) {
                    matches = true;
                }
                break;

            default:
                System.out.println("Invalid filter type.");
                return;
        }

        if (matches){
            num += 1;
            if (!found) {
                System.out.println("====Filtered Enrollment List====");
                found = true;
            System.out.println("------Record " + (num) + " ------");
            System.out.println(e);

            }
            if (!found) {
                System.out.println("No enrollments found matching the criteria.");
            }
        }

    }
}
    public void viewAll() {
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


    public void searchByCourceCode(){
        String id = input.readEnrollID("Enter your course code: ");
        for (int i = 0; i < count; i++) {
            if (enrollments[i].getCourse().equals(id)) {
                System.out.println(enrollments[i]);
                return;
            }
        }
        System.out.println("Course code not found! ");
    }

    public void searchByStudentName(){
        String name = input.readString("Enter your name: ");
        for (int i = 0; i < count; i++){
            if (enrollments[i].getStudent().toUpperCase().equals(name.toUpperCase())){
                System.out.println(enrollments[i]);
                return;
            }
        }
        System.out.println("Student name not found! ");
    }
}