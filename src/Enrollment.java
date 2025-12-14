public class Enrollment {
    private String enrollID;
    private String courseCode;
    private String studentName;
    private String Semester;

    public Enrollment(String ID, String Course, String Student, String Sem){
        this.enrollID = ID;
        this.courseCode = Course;
        this.studentName = Student;
        this.Semester = Sem;
        
    }

    public String getID(){
        return enrollID;
    }
    public String getCourse(){
        return courseCode;
    }
    public String getStudent(){
        return studentName;
    }
    public String getSem(){
        return Semester;
    }

    public void setID(String newID){
        this.enrollID = newID;
    }
    public void setCourse(String newCourse){
        this.courseCode = newCourse;
    }
    public void setStudent(String newStudent){
        this.studentName = newStudent;
    }
    public void setSemester(String newSem){
        this.courseCode = newSem;
    }

    @Override

    public String toString(){
        return "Enrollment ID: " + enrollID +
                "\nCourse Code: " + courseCode + 
                "\nStudent Name: " + studentName +
                "\nSemester: " + Semester;
    }

}
