package com.how2.knowledge_management.service;

import com.how2.knowledge_management.model.Task;
import com.how2.knowledge_management.repository.FormsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormsService {

    @Autowired
    private FormsRepository formRepo;

    // CREATE
    public Task createTask(Task forms){
        return formRepo.save(forms);
    }

    // READ
    public List<Task> getAllForms(){
        return formRepo.findAll();
    }

    public Optional<Task> getFormById(String id){
        return formRepo.findById(id);
    }

    // UPDATE
    public ResponseEntity<Task> updateForm(Task form){
       Optional<Task> existing = formRepo.findById(form.getId());
       if(existing.isPresent()){
           Task updated = formRepo.save(form);
           return ResponseEntity.ok(updated);

       }else {
           return ResponseEntity.notFound().build();
       }
    }

    // DELETE
    public ResponseEntity<String> removeForm(String id){
        if(formRepo.existsById(id)){
            formRepo.deleteById(id);
            return ResponseEntity.ok("Form Deleted");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
