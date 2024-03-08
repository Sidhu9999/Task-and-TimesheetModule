package com.time_sheeet.service.impl;

import com.time_sheeet.dto.TaskDto;
import com.time_sheeet.entity.Task;
import com.time_sheeet.exception.ResourceNotFoundException;
import com.time_sheeet.repository.TaskRepository;
import com.time_sheeet.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;


import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Task createTask(Task task) {
        return this.repo.save(task);
    }

    @Override
    public Task updateTask(Task task, Long id) {
        Task existingTask = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task" , "Task id" , id));

        // Update task fields if they are not null in the provided task object
        if (task.getName() != null) {
            existingTask.setName(task.getName());
        }
        if (task.getAssignee() != 0) {
            existingTask.setAssignee(task.getAssignee());
        }
        if (task.getDescription() != null) {
            existingTask.setDescription(task.getDescription());
        }
        if (task.getPriority() != null) {
            existingTask.setPriority(task.getPriority());
        }
        if (task.getDueDate() != null) {
            existingTask.setDueDate(task.getDueDate());
        }

        return repo.save(existingTask);
    }


    @Override
    public Task getTaskById(Long id) {
        Task task = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task","Task id", id));
        return task;
    }

    @Override
    public void deleteTaskById(Long id) {
        Task task = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task" , "Task id", id));
        repo.delete(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return repo.findAll();
    }
}