public class PostgraduateEnrollment extends Enrollment {

    private String researchArea;
    private String supervisorName;

    public PostgraduateEnrollment(String enrollID, String courseCode, String studentName, String semester,
                                  String researchArea, String supervisorName) {
        super(enrollID, courseCode, studentName, semester);
        this.researchArea = researchArea;
        this.supervisorName = supervisorName;
    }

    
    public String getResearchArea() {return researchArea;}

    public String getSupervisorName() {return supervisorName;}

    
    public void setResearchArea(String newResearchArea) {this.researchArea = newResearchArea;}

    public void setSupervisorName(String newSupervisorName) {this.supervisorName = newSupervisorName;}

    @Override
    public String toString() {
        return super.toString() +
                "\nLevel: Postgraduate" +
                "\nResearch Area: " + researchArea +
                "\nSupervisor Name: " + supervisorName;
    }
}
