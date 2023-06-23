package com.sams.spring.jpa.postgresql.model;

import jakarta.persistence.*;

@Entity
@Table(name = "educationDetails")
public class EducationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long educationDetailsid;

    @Column(name = "highestEducationLevel")
    private String highestEducationLevel;

    @Column(name = "currentlyPursuingEducation")
    private String currentlyPursuingEducation;

    @Column(name = "nameOfLastEducationalInstitution")
    private String nameOfLastEducationalInstitution;

    @Column(name = "technicalEducation")
    private String technicalEducation;

    public long getEducationDetailsid() {
        return this.educationDetailsid;
    }

    public void setEducationDetailsid(long educationDetailsid) {
        this.educationDetailsid = educationDetailsid;
    }

    public String getHighestEducationLevel() {
        return this.highestEducationLevel;
    }

    public void setHighestEducationLevel(String highestEducationLevel) {
        this.highestEducationLevel = highestEducationLevel;
    }

    public String getCurrentlyPursuingEducation() {
        return this.currentlyPursuingEducation;
    }

    public void setCurrentlyPursuingEducation(String currentlyPursuingEducation) {
        this.currentlyPursuingEducation = currentlyPursuingEducation;
    }

    public String getNameOfLastEducationalInstitution() {
        return this.nameOfLastEducationalInstitution;
    }

    public void setNameOfLastEducationalInstitution(String nameOfLastEducationalInstitution) {
        this.nameOfLastEducationalInstitution = nameOfLastEducationalInstitution;
    }

    public String getTechnicalEducation() {
        return this.technicalEducation;
    }

    public void setTechnicalEducation(String technicalEducation) {
        this.technicalEducation = technicalEducation;
    }

    public EducationDetails() {
    }

    public EducationDetails(long educationDetailsid, String highestEducationLevel, String currentlyPursuingEducation, String nameOfLastEducationalInstitution, String technicalEducation) {
        this.educationDetailsid = educationDetailsid;
        this.highestEducationLevel = highestEducationLevel;
        this.currentlyPursuingEducation = currentlyPursuingEducation;
        this.nameOfLastEducationalInstitution = nameOfLastEducationalInstitution;
        this.technicalEducation = technicalEducation;
    }

    
    
}
