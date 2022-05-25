package de.vslab.demo;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TodoItem {
    @Id
    private String todo;

    private int priority;

    public String getTodo() {
        return todo;
    }

    public int getPriority() {
        return priority;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}