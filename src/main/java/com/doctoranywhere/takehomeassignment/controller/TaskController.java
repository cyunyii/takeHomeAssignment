package com.doctoranywhere.takehomeassignment.controller;

import com.doctoranywhere.takehomeassignment.model.Task;
import com.doctoranywhere.takehomeassignment.model.createTaskVo;
import com.doctoranywhere.takehomeassignment.model.updateTaskVo;
import com.doctoranywhere.takehomeassignment.service.TaskService;
import com.doctoranywhere.takehomeassignment.util.ResponseCode;
import com.doctoranywhere.takehomeassignment.util.ResponseUtil;
import com.doctoranywhere.takehomeassignment.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    @ResponseBody
    public Object getTask(){
        ReturnObject<List<Task>> retObject= taskService.getAllTask();

        return ResponseUtil.ok(retObject.getData());

    }

    @PostMapping("/tasks")
    @ResponseBody
    public Object createTask(@RequestBody createTaskVo newVo){
        ReturnObject retObject= taskService.createTask(newVo);

        if(retObject.getCode()==ResponseCode.OK){
            return ResponseUtil.ok();
        }else{
            return ResponseUtil.fail(retObject.getCode());
        }
    }

    @GetMapping("/tasks/{id}")
    @ResponseBody
    public Object getSingleTask(@PathVariable("id") Long id){
        ReturnObject retObject= taskService.getTaskById(id);

        if(retObject.getCode()==ResponseCode.OK)
            return ResponseUtil.ok(retObject.getData());
        else
            return ResponseUtil.fail(retObject.getCode());
    }

    @PutMapping("/tasks/{id}")
    @ResponseBody
    public Object updateTask(@PathVariable("id") Long id,@RequestBody updateTaskVo updateVo){
        ReturnObject retObject= taskService.updateTaskById(id,updateVo);

        if(retObject.getCode()==ResponseCode.OK)
            return ResponseUtil.ok();
        else
            return ResponseUtil.fail(retObject.getCode());
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseBody
    public Object deleteTask(@PathVariable("id") Long id){
        ReturnObject retObject= taskService.deleteTaskById(id);

        if(retObject.getCode()==ResponseCode.OK)
            return ResponseUtil.ok();
        else
            return ResponseUtil.fail(retObject.getCode());
    }


}


