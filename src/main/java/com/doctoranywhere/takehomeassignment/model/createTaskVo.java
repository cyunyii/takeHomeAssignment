package com.doctoranywhere.takehomeassignment.model;

import lombok.Data;

@Data
public class createTaskVo {

    private long id;
    private String title;
    private String description;

    public Task createTask(){
        Task newTask=new Task();
        newTask.setId(this.id);
        newTask.setTitle(this.title);
        newTask.setDescription(this.description);
        newTask.setCompleted(false);
        return newTask;
    }


}
