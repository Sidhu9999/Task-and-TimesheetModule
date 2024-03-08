package com.time_sheeet.controller;

import com.time_sheeet.dto.TimeSheetDto;
import com.time_sheeet.entity.TimeSheet;
import com.time_sheeet.service.TimeSheetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.Map;

@RequestMapping("/timesheet/emp")
@RestController
public class TimeSheetController {

    @Autowired
    private TimeSheetService service;

    @PostMapping("/add")
    public ResponseEntity<?> createTimeSheet(@Valid @RequestBody TimeSheetDto td){
        TimeSheetDto tdo= service.createTimeSheet(td);
        return new ResponseEntity<>(tdo , HttpStatus.CREATED);

    }

    @PutMapping("update/{timeId}")
    public ResponseEntity<?> updateTimeSheet(@Valid @RequestBody TimeSheetDto td, @PathVariable long timeId){
        TimeSheetDto updatedsheet= service.updateTimeSheet(td , timeId);
        return ResponseEntity.ok(updatedsheet);
    }

    @DeleteMapping("delete/{timeId}")
    public ResponseEntity<?> deleteTimeSheet(@Valid @PathVariable long timeId){
         service.deleTimeSheet(timeId);
         return new ResponseEntity(Map.of("message","timesheet deleted successfully"),HttpStatus.OK);
    }

    @GetMapping("empid/{empId}")
    public ResponseEntity<?> viewTimeSheetByEmp(@Valid @PathVariable long empId){
        List<TimeSheet> sheets=service.ViewTimeSheetByEmployee(empId);
        return new ResponseEntity<>(sheets , HttpStatus.OK);
    }

    @GetMapping("timeid/{timeId}")
    public ResponseEntity<?> getTimeSheetBytimeId(@Valid @PathVariable long timeId){
        TimeSheetDto time=service.getTimeSheetBytimeId(timeId);
        return new ResponseEntity<>(time , HttpStatus.OK);
    }


}
