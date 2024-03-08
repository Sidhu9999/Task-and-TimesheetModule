package com.time_sheeet.controller;

import com.time_sheeet.dto.TaskDto;
import com.time_sheeet.entity.Task;
import com.time_sheeet.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
     private TaskService service;

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@Valid  @RequestBody Task td){
        Task createdtask = service.createTask(td);
        return new ResponseEntity<>(createdtask , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTask(@Valid @PathVariable Long id , @RequestBody Task td){
        Task updatedtask = service.updateTask(td, id);
        return new ResponseEntity<>(updatedtask , HttpStatus.OK);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?> getTaskById(@Valid @PathVariable Long id){
        Task taskDto = service.getTaskById(id);
        return new ResponseEntity<>(taskDto , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletTaskById(@Valid @PathVariable Long id){
        service.deleteTaskById(id);
        return ResponseEntity.ok("task deleted successfully");
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Task>> getAllTasks(){
        final List<Task> allTasks = service.getAllTasks();
        return ResponseEntity.ok(allTasks);
    }

}
