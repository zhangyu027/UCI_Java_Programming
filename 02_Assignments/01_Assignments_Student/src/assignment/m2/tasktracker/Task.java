package assignment.m2.tasktracker;

import java.util.Date;

/**
 * Module 2 Homework Task data class.
 * Based on the Task class provided with the Canvas homework.
 */
public class Task {

    private String title;
    private String description;
    private Date dueDate;

    // TODO: Add a field that records whether this task is complete.

    public Task(String title, String description, Date dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
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

    // TODO: Add methods needed to read/change completion status.
    // The homework requires completed tasks to be visually differentiated.
}
