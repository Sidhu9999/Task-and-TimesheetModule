package com.time_sheeet.service.impl;

import com.time_sheeet.dto.TimeSheetDto;
import com.time_sheeet.entity.TimeSheet;
import com.time_sheeet.exception.ResourceNotFoundException;
import com.time_sheeet.repository.TimeSheetRepository;
import com.time_sheeet.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TimeSheetServiceImpl implements TimeSheetService {

    @Autowired
    private TimeSheetRepository repo;

    @Override
    public TimeSheet createTimeSheet(TimeSheetDto td)

    {
        TimeSheet t=new TimeSheet();

        t.setTimeId(td.getTimeId());
        t.setEmpId(td.getEmpId());
        t.setTime_In(td.getTime_In());
        t.setTime_Out(td.getTime_Out());
        t.setNote(td.getNote());
        t.setDate(td.getDate());
        t.setProject(td.getProject());
        return repo.save(t);

    }

    @Override
    public TimeSheet updateTimeSheet(TimeSheetDto td, long tid) {
        TimeSheet t = repo.findById(tid)
                .orElseThrow(()-> new ResourceNotFoundException("TimeSheetDto","timeId",tid ));

        if (td.getTime_In() != null) {
            t.setTime_In(td.getTime_In());
        }
        if (td.getTime_Out() != null) {
            t.setTime_Out(td.getTime_Out());
        }
        if (td.getProject() != 0) {
            t.setProject(td.getProject());
        }
        if (td.getEmpId() != 0) {
            t.setEmpId(td.getEmpId());
        }
        if (td.getDate() != null) {
            t.setDate(td.getDate());
        }
        if (td.getNote() != null) {
            t.setNote(td.getNote());
        }

        return repo.save(t);
    }


    @Override
    public TimeSheet getTimeSheetBytimeId(long timeId)

    {
        TimeSheet t=new TimeSheet();
        t=repo.findById(timeId).get();
        return t;
    }

    @Override
    public void deleTimeSheet(long timeId)

    {
        TimeSheet t=new TimeSheet();
        repo.deleteById(timeId);
    }

    @Override
    public List<TimeSheet> ViewTimeSheetByEmployee(long empId) {
        return repo.findTimeSheetByempId(empId);
    }


}
