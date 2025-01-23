package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "todotable")
@Table(name = "todotable")
public class TodoItem{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date duedate;
    private String status;

    public TodoItem(int id, String name, Date duedate, String status) {
        this.id = id;
        this.name = name;
        this.duedate = duedate;
        this.status = status;
    }

    public TodoItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
