package com.time_sheeet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.time_sheeet.dto.TimeSheetDto;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TimeSheet extends TimeSheetDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long timeId;

    private long empId;

    private Date time_In;

    private Date time_Out;

    private Date date;

    private String note;

    private long project;

}
