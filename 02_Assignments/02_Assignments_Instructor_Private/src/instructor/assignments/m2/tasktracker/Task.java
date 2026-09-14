package instructor.assignments.m2.tasktracker;

import java.util.Date;

/** Data class used by the Module 2 Task Tracker homework. */
public class Task {

    private String title;
    private String description;
    private Date dueDate;
    private boolean completed;

    public Task(String title, String description, Date dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
