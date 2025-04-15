package com.how2.knowledge_management.repository;
import com.how2.knowledge_management.model.Rate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatesRepository extends MongoRepository<Rate, String> {
}