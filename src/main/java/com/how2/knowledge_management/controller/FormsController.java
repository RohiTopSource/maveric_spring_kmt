package com.how2.knowledge_management.controller;

import com.how2.knowledge_management.model.Task;
import com.how2.knowledge_management.service.FormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forms")
public class FormsController {

    @Autowired
    private FormsService service;

    @PostMapping("/create")
    public ResponseEntity<Task> createForm(@RequestBody Task forms){
        Task created =  service.createTask(forms);
        return ResponseEntity.status(201).body(created);
    }
}
