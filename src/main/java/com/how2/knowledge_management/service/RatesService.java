package com.how2.knowledge_management.service;

import com.how2.knowledge_management.model.Rate;
import com.how2.knowledge_management.repository.RatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatesService {

    @Autowired
    private RatesRepository rateRepo;

    public Rate createRate(Rate rate){
        return rateRepo.save(rate);
    }
    public List<Rate> getAllRate(){
        return rateRepo.findAll();
    }

    public Rate updateRate(String id, Rate updateRate){
        Rate existing = rateRepo.findById(id).orElseThrow(()-> new RuntimeException("Rate not found"));
        existing.setType((updateRate.getType()));
        existing.setValue((updateRate.getValue()));
        return rateRepo.save(existing);
    }

    public ResponseEntity<String> deleteRate(String id){
        if(rateRepo.existsById(id)) {
            rateRepo.deleteById(id);
            return ResponseEntity.ok("Rate deleted");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
