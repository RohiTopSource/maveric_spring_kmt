package com.how2.knowledge_management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.how2.knowledge_management.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface FormsRepository extends MongoRepository<Task, String> {

}
