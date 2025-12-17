public class UndergraduateEnrollment extends Enrollment {
    private String programme;
    private int studyYear;

    public UndergraduateEnrollment(String enrollID, String courseCode, String studentName, String Semester, String programme, int studyYear){
        super(enrollID, courseCode, studentName, Semester);
        this.programme = programme;
        this.studyYear = studyYear;
    }

    public String getProgramme(){return programme;}
    public int getStudyYear(){return studyYear;}

    public void setProgramme(String newProgramme){this.programme = newProgramme;}
    public void setStudyYear(int newStudyYear){this.studyYear = newStudyYear;}

    @Override
    public String toString(){
        return super.toString() + 
                "\nLevel: Undergraduate" +
                "\nProgramme: " + programme +
                "\nStudy Year: " + studyYear;
    }
}