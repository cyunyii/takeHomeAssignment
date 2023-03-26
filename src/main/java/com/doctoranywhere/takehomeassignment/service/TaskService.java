package com.doctoranywhere.takehomeassignment.service;

import com.doctoranywhere.takehomeassignment.model.Task;
import com.doctoranywhere.takehomeassignment.model.createTaskVo;
import com.doctoranywhere.takehomeassignment.model.updateTaskVo;
import com.doctoranywhere.takehomeassignment.util.ReturnObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {


    ReturnObject<List<Task>> getAllTask();
    ReturnObject createTask(createTaskVo newVo);

    ReturnObject getTaskById(Long id);

    ReturnObject updateTaskById(Long id, updateTaskVo updateVo);

    ReturnObject deleteTaskById(Long id);

//    ReturnObject<VoObject> createTask();
//
//    ReturnObject<VoObject> getSingleTask(Long id);
//
//    ReturnObject<VoObject> updateTask(Long id, );
//
//    ReturnObject<VoObject> deleteTask(Long id);

}
