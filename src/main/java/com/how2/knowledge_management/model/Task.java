package com.how2.knowledge_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "forms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    private String  id;
    private String title;
    private String desc;
    private String[] assetSpecialist;
    private String[] assetManager;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
