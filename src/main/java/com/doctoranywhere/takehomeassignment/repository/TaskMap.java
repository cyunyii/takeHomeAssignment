package com.doctoranywhere.takehomeassignment.repository;

import com.doctoranywhere.takehomeassignment.model.Task;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class TaskMap {
    public HashMap<Long, Task> repository=new HashMap<>();

}
