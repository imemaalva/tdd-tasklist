package edu.uaslp.objetos.taskslist.taskList;

import edu.uaslp.objetos.taskslist.exceptions.TaskNotFoundException;

import java.util.*;

public class TaskList {
    LinkedList<Task> taskList = new LinkedList<>();

    public int getSize() {
        return taskList.size();
    }

    public void add(Task task){
        taskList.add(task);
    }

    public void remove(Task task){
        taskList.remove(task);
    }

    public Task find(String title){
        int i=0;
        int size=taskList.size();
        for (i=0; size>i; i++) {
            if (title == taskList.get(i).getTitle()) {
                return taskList.get(i);
            }
        }
        throw new TaskNotFoundException("Task with title 'Hacer ejercicio' not found");
    }

    public void markAsDone(String title){
        Task task_aux = find(title);

        task_aux.isDone=true;
    }

    public void markAsNotDone(String title){
        Task task_aux = find(title);

        task_aux.isDone=false;
    }

    public Task getNextTask(){
        String title = taskList.element().getTitle();

        int i;
        int size=taskList.size();

        for(i=0; title != taskList.get(i).getTitle() && size>i; i++);
        return taskList.get(i+1);
    }

    public List<Task> getNextTasks(){
        List<Task> taskList = new LinkedList<>();

        for (Task task : this.taskList) {
            if (!task.isDone()) {
                taskList.add(task);
            }
        }
        taskList.sort(Comparator.comparing(Task::getDueDate));

        return taskList;
    }

}