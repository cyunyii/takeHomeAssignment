package com.doctoranywhere.takehomeassignment.service;

import com.doctoranywhere.takehomeassignment.model.Task;
import com.doctoranywhere.takehomeassignment.model.createTaskVo;
import com.doctoranywhere.takehomeassignment.model.updateTaskVo;
import com.doctoranywhere.takehomeassignment.repository.TaskMap;
import com.doctoranywhere.takehomeassignment.util.ResponseCode;
import com.doctoranywhere.takehomeassignment.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {


    @Autowired
    TaskMap taskMap;
    @Override
    public ReturnObject<List<Task>> getAllTask() {
        HashMap<Long,Task> map=taskMap.repository;
        List<Task> resList=new ArrayList<>();
        for(Map.Entry<Long,Task> entry: map.entrySet()){
            resList.add(entry.getValue());
        }
        return new ReturnObject<>(resList);
    }

    @Override
    public ReturnObject createTask(createTaskVo newVo) {
        Task newTask=newVo.createTask();
        HashMap<Long,Task> map=taskMap.repository;
        if(map.containsKey(newTask.getId())){
            return new ReturnObject<>(ResponseCode.RESOURCE_EXIST);
        }else{
            map.put(newTask.getId(), newTask);
            return new ReturnObject<>(ResponseCode.OK);
        }
    }

    @Override
    public ReturnObject getTaskById(Long id) {
        HashMap<Long,Task> map=taskMap.repository;
        if(map.containsKey(id)){
            return new ReturnObject<>(map.get(id));
        }else{
            return new ReturnObject<>(ResponseCode.NOT_FOUND);
        }
    }

    @Override
    public ReturnObject updateTaskById(Long id, updateTaskVo updateVo) {
        HashMap<Long,Task> map=taskMap.repository;
        if(map.containsKey(id)){
            Task oldTask=map.get(id);
            if(updateVo.getDescription()!=null){
                oldTask.setDescription(updateVo.getDescription());
            }
            if(updateVo.getTitle()!=null){
                oldTask.setTitle(updateVo.getTitle());
            }
            if(updateVo.isCompleted()==true){
                oldTask.setCompleted(true);
            }
            return new ReturnObject(ResponseCode.OK);
        }else{
            return new ReturnObject<>(ResponseCode.NOT_FOUND);
        }
    }

    @Override
    public ReturnObject deleteTaskById(Long id) {
        HashMap<Long,Task> map=taskMap.repository;
        if(map.containsKey(id)){
            map.remove(id);
            return  new ReturnObject<>(ResponseCode.OK);
        }else{
            return new ReturnObject<>(ResponseCode.NOT_FOUND);
        }
    }
}
