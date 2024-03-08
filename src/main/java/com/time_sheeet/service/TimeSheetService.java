package com.time_sheeet.service;

import com.time_sheeet.dto.TimeSheetDto;
import com.time_sheeet.entity.TimeSheet;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TimeSheetService {

    public TimeSheet createTimeSheet(TimeSheetDto timesheetdto);
    public TimeSheet updateTimeSheet(TimeSheetDto timesheetdto ,long tid);

    public TimeSheet getTimeSheetBytimeId(long time_Id);

    void deleTimeSheet(long time_Id);

    public List<TimeSheet> ViewTimeSheetByEmployee(long empId);

}
