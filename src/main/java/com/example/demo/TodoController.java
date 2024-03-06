package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepo;

    @GetMapping("/todos")
    public Iterable<Todo> findAll() {
        return this.todoRepo.findAll();
    }
}
