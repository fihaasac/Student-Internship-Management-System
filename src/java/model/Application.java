package model;

public class Application {
    private int studentId;
    private int internshipId;
    private String coverLetter;

    private String studentName;
    private String internshipTitle;
    private String status;

    // Constructor for insert
    public Application(int studentId, int internshipId, String coverLetter) {
        this.studentId = studentId;
        this.internshipId = internshipId;
        this.coverLetter = coverLetter;
    }

    // Constructor for displaying in table
    public Application(String studentName, String internshipTitle, String status) {
        this.studentName = studentName;
        this.internshipTitle = internshipTitle;
        this.status = status;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public int getInternshipId() {
        return internshipId;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getInternshipTitle() {
        return internshipTitle;
    }

    public String getStatus() {
        return status;
    }
}
