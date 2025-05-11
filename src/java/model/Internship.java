package model;

public class Internship {
    private int id;
    private String title;
    private String description;
    private int companyId;
    private String deadline;

    public Internship(int id, String title, String description, int companyId, String deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.companyId = companyId;
        this.deadline = deadline;
    }

    // **Add this getter** so JSP can call getId()
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getCompanyId() {
        return companyId;
    }
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDeadline() {
        return deadline;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
