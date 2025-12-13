public class PostgraduateEnrollment extends Enrollment {
    private String researchArea;
    private String supervisorName;

    public PostgraduateEnrollment(String enrollID, String courseCode, String studentName, String Semester, String researchArea, String supervisorName){
        super(enrollID, courseCode, studentName, Semester);
        this.researchArea = researchArea;
        this.supervisorName = supervisorName;
    }

    public String setresearchArea(){
        return researchArea;
    }
    public String setsupervisorName(){
        return supervisorName;
    }

    public void getresearchArea(String newresearchArea){
        this.researchArea = newresearchArea;
    }
    public void getsupervisorName(String newsupervisorName){
        this.supervisorName = newsupervisorName;

    @Override
    public String toString(){
        super.toString();
        return "Level: PG " + 
                "\nResearchArea: " + researchArea +
                "\nSupervisor Name: " + supervisorName;
    }
}