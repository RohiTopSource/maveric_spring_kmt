package com.how2.knowledge_management.controller;

import com.how2.knowledge_management.model.Rate;
import com.how2.knowledge_management.service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rates")
public class RatesController {

    @Autowired
    private RatesService rateService;

    @PostMapping("/create")
    public ResponseEntity<Rate> createRate(@RequestBody Rate rate){
        Rate createdRate = rateService.createRate(rate);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRate);
    }

    @GetMapping("/getAllRates")
    public ResponseEntity<?> getAll(){
       try {
            List<Rate> result = rateService.getAllRate();
            if (result.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No rates found");
            } else {
                return ResponseEntity.ok(result);
            }
        }
       catch (Exception e){
           throw new ResponseStatusException(
                   HttpStatus.INTERNAL_SERVER_ERROR,"Failed to retrieve rates", e
           );
       }
    }

    @PutMapping("/updateRate/{id}")
    public ResponseEntity<Rate> updateRate(@PathVariable String id, @RequestBody Rate rate){
        try {
            Rate updated = rateService.updateRate(id, rate);
            return ResponseEntity.ok(updated);
        }
        catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,"Failed to Update",e
            );
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeRates(@PathVariable String id){
        try {
            return rateService.deleteRate(id);
        }
        catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete the Rate"
            );
        }
    }
}
