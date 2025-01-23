package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Table;
import java.util.Date;

public class TodoDto {
    private String name;

    private Date duedate;
    private String status;

    public TodoDto(String name, Date duedate, String status) {
        this.name = name;
        this.duedate = duedate;
        this.status = status;
    }

    public TodoDto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

