package com.riwi.io.dailyTask.Services;

import com.riwi.io.dailyTask.Models.TaskModel;
import com.riwi.io.dailyTask.Repositories.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTask {
    @Autowired
    private TaskRepo taskRepo;

    public List<TaskModel> getAllTasks () {return taskRepo.findAll();}

    public TaskModel loadNewTask(TaskModel taskModel) {return taskRepo.save(taskModel);}

    public TaskModel getTaskById(Long id) {return  taskRepo.findById(id).orElse(null);}

    public void deleteTask(Long id) {taskRepo.deleteById(id);}
}
