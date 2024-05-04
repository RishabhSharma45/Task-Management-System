
package java8project;

import java.time.LocalDate;

public class Task {
    private String title;
    private boolean completed;
    private LocalDate deadline;

    public Task(String title, LocalDate deadline) {
        this.title = title;
        this.completed = false;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                ", deadline=" + deadline +
                '}';
    }
}

