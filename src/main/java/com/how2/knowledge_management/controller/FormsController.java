package com.how2.knowledge_management.controller;

import com.how2.knowledge_management.model.Task;
import com.how2.knowledge_management.service.FormsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/getAllForms")
    public ResponseEntity<?> getAllForms(){
        try{
             List<Task> result = service.getAllForms();
             if(result.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No forms found");
             }
             return ResponseEntity.ok(result);
        }
        catch(Exception e){
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrive the form" , e
            );
        }
        
    }

    @PutMapping("/updateForm/{id}")
    public ResponseEntity<Task> updateForm(@PathVariable String id, @RequestBody Task formData){
        try{
            return service.updateForm(id, formData);
        }
        catch(Exception e){
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "Con't find form", e
            );
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeForm(@PathVariable String id){
        try{
            return service.removeForm(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "Can't remove",e
            );
        }
        

    }
}
