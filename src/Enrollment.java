public class Enrollment {
    private String enrollID;
    private String courseCode;
    private String studentName;
    private String Semester;

    public Enrollment(String enrollID, String courseCode, String studentName, String Semester){
        this.enrollID = enrollID.toUpperCase();
        this.courseCode = courseCode.toUpperCase();
        this.studentName = studentName.toUpperCase();
        this.Semester = Semester.toUpperCase();
        
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
        this.Semester = newSem;
    }

    @Override

    public String toString(){
        return "\nEnrollment ID: " + enrollID +
                "\nCourse Code: " + courseCode + 
                "\nStudent Name: " + studentName +
                "\nSemester: " + Semester;
    }

}
