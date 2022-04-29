package edu.uaslp.objetos.taskslist.taskList;

import edu.uaslp.objetos.taskslist.exceptions.TaskListException;

import java.time.LocalDateTime;

public class Task {
    String Title, Description;
    LocalDateTime DueDate;
    boolean isDone=false;

    public Task(String title, String description, LocalDateTime dueDate, boolean isdone){
        this.Description=description;
        this.DueDate=dueDate;
        this.Title=title;
        this.isDone=isdone;
    }
    public Task (){}

    public void setDone(boolean bool){
        this.isDone=bool;
    }

    public boolean isDone(){
        return isDone;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDateTime getDueDate() {
        return DueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        LocalDateTime current_time = LocalDateTime.now();
        DueDate = dueDate;
        if(dueDate.isBefore(current_time)){
            throw new TaskListException("Due date is set in the past");
        }
        DueDate = dueDate;
    }

}