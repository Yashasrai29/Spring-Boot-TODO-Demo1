package com.example.demo.controller;


import com.example.demo.dto.TodoDto;
import com.example.demo.model.TodoItem;
import com.example.demo.repo.TodoRepo;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/todo")
@CrossOrigin(origins = "*")
public class TodoController {
    @Autowired
    private TodoDto todoDto;

    @Autowired
    private TodoRepo todoRepo;

    @GetMapping
    public List<TodoItem> findAll() {
        return todoRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public List<TodoItem> findAllById(@PathVariable Integer id) {
        return todoRepo.findAllById(Collections.singleton(id));
    }


    @PostMapping
    public TodoItem save(@NotNull @RequestBody TodoItem todoItem) {
        return todoRepo.save(todoItem);
    }

    @PostMapping(value = "/multiSave")
    public List<TodoItem> save(@NotNull @RequestBody List<TodoItem> todoItem) {
        return todoRepo.saveAll(todoItem);
    }

    @PutMapping(path = "{id}")
    public TodoItem update(@PathVariable Integer id, @RequestBody TodoItem todoItem) {
        return todoRepo.save(todoItem);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity partialUpdate(@RequestBody TodoDto todoDto, @PathVariable Integer id) {

        Optional<TodoItem> itemOptional = todoRepo.findById(id);
        if (itemOptional.isPresent()) {
            TodoItem item = itemOptional.get();
            if (todoDto.getName() != null) {
                item.setName(todoDto.getName());
            } else {
                item.setName(item.getName());
            }

            if (todoDto.getStatus() != null) {
                item.setStatus(todoDto.getStatus());
            } else {
                item.setStatus(item.getStatus());
            }

            if (todoDto.getDuedate() != null) {
                item.setDuedate(todoDto.getDuedate());
            } else {
                item.setDuedate(item.getDuedate());
            }

            todoRepo.save(item);
            return ResponseEntity.status(200).body(item);

        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Integer id) {
        todoRepo.deleteById(id);
    }

    @GetMapping(value = "/")
    public List<TodoItem> findByPage(
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "filter", defaultValue = "Completed", required = false) String filter) {
        Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<TodoItem> pageTodo = this.todoRepo.findAll(p);
        List<TodoItem> content = pageTodo.getContent();
        return content.stream().filter(todoItem -> todoItem.getStatus().equals(filter)).map((TodoItem) -> TodoItem).collect(Collectors.toList());
    }


}