package com.doctoranywhere.takehomeassignment.model;

import lombok.Data;

@Data
public class updateTaskVo {

    private String title;
    private String description;
    private boolean completed;

    public Task createTask(){
        Task newTask=new Task();
        newTask.setTitle(this.title);
        newTask.setDescription(this.description);
        newTask.setCompleted(this.completed);
        return newTask;
    }
}