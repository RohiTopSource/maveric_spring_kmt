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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getAssetSpecialist() {
        return assetSpecialist;
    }

    public void setAssetSpecialist(String[] assetSpecialist) {
        this.assetSpecialist = assetSpecialist;
    }

    public String[] getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(String[] assetManager) {
        this.assetManager = assetManager;
    }

    private String[] assetSpecialist;
    private String[] assetManager;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
