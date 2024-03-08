package com.time_sheeet.repository;

import com.time_sheeet.entity.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSheetRepository extends JpaRepository<TimeSheet , Long> {

    public List<TimeSheet> findTimeSheetByempId(long emp_Id);
}
