public class UndergraduateEnrollment extends Enrollment {
    private String programme;
    private int studyYear;

    public UndergraduateEnrollment(String enrollID, String courseCode, String studentName, String Semester, String programme, int studyYear){
        super(enrollID, courseCode, studentName, Semester);
        this.programme = programme;
        this.studyYear = studyYear;
    }

    public String setProgramme(){
        return programme;
    }
    public int setStudyYear(){
        return studyYear;
    }

    public void getProgramme(String newProgramme){
        this.programme = newProgramme;
    }
    public void getStudyYear(int newStudyYear){
        this.studyYear = newStudyYear;
    }

    @Override
    public String toString(){
        return super.toString() + 
                "\nLevel: Undergraduate" +
                "\nProgramme: " + programme +
                "\nStudy Year: " + studyYear;
    }
}