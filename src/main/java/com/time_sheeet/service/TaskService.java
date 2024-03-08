package com.time_sheeet.service;

import com.time_sheeet.dto.TaskDto;
import com.time_sheeet.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    Task createTask(Task task);

    Task updateTask(Task task,Long id);

    Task getTaskById(Long id);

    void deleteTaskById(Long id);

    List<Task> getAllTasks();
}
