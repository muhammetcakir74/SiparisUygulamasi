package org.muhammetcakir.model;

import java.time.LocalDateTime;
import java.util.Date;

public class BaseModel {

    public BaseModel(String id, LocalDateTime createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }

    private String id;
    private LocalDateTime createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
