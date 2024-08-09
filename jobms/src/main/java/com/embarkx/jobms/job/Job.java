package com.embarkx.jobms.job;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//@Table(name = "job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    // @ManyToOne
    private Long companyId;

    public Job(){
        
    }

    public Job(Long id, String title,String description, String minSalary, String maxSalary, String location ){
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Long getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setminSalary(String minSalary){
        this.minSalary = minSalary;
    }
    public void setMaxSalary(String maxSalary){
        this.maxSalary = maxSalary;
    }
    public void setLocation(String location){
        this.location = location;
    }

    public Long getId(){
        return this.id ;
    }
    public String getTitle(){
        return this.title ;
    }
    public String getDescription(){
        return this.description;
    }
    public String getminSalary(){
        return this.minSalary ;
    }
    public String getMaxSalary(){
        return this.maxSalary ;
    }
    public String getLocation(){
        return this.location ;
    }

}
