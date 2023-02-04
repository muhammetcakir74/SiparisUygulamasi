package org.muhammetcakir.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Company extends BaseModel{
    public Company(String id, LocalDateTime createdDate, String name,String field) {
        super(id, createdDate);
        this.name = name;
        this.field = field;
    }

    private String name;
    private String field;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
