package com.example.demo.repo;

import com.example.demo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface TodoRepo extends JpaRepository<TodoItem, Integer> {


}
