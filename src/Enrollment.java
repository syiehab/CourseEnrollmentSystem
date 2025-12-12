public class Enrollment {
    private String enrollID;
    private String courseCode;
    private String studentName;
    private String semester;

    public Enrollment(String ID, String Course, String Student, String Sem){
        String enrollID = ID;
        String courseCode = Course;
        String studentName = Student;
        String Semester = Sem;
        
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
        return semester;
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

}
