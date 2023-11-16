package com.example.job.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity

public class Job implements Serializable{
    private  static final long SerialVersionUID=6;
    @Id
    @GeneratedValue
    private int id;
    private String service;
    private Boolean etat;

    public Job() {
        super();
    }

    public Job(String service, Boolean etat) {
        this.service = service;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
}


