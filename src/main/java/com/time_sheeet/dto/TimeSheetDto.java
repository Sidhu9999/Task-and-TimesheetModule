package com.time_sheeet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimeSheetDto {


    private long timeId;

    private long empId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-mm-dd hh:ss")
    @NotNull
    private Date time_In;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-mm-dd hh:ss")
    private Date time_Out;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-mm-dd")
    private Date date;

    @NotNull(message = "Npte should not be null")
    private String note;

    private long project;

}
