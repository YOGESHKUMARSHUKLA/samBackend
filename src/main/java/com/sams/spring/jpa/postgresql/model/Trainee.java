package com.sams.spring.jpa.postgresql.model;

import javax.persistence.*;
// import com.sams.spring.jpa.postgresql.model.EducationDetails;

@Entity
@Table(name = "trainee")
public class Trainee  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long traineeid;

    @Column(name = "salutation")
    private String salutation;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "surName")
    private String surName;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "maritalStatus")
    private String maritalStatus;

    @Column(name = "casteCategory")
    private String casteCategory;

    // @Column(name = "educationDetails")
    // private EducationDetails educationDetails;

    public Trainee() {

    }

    public Trainee(String salutation, String firstName, String middleName, String surName, String dateOfBirth,
            String gender, String maritalStatus, String casteCategory){// ,EducationDetails educationDetails) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.middleName = middleName;

        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;

        this.maritalStatus = maritalStatus;
        this.casteCategory = casteCategory;
        // this.educationDetails = educationDetails;
    }

    public long getTraineeid() {
        return this.traineeid;
    }

    public void setTraineeid(long traineeid) {
        this.traineeid = traineeid;
    }

    public String getSalutation() {
        return this.salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurName() {
        return this.surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getCasteCategory() {
        return this.casteCategory;
    }

    public void setCasteCategory(String casteCategory) {
        this.casteCategory = casteCategory;
    }

    // public EducationDetails getEducationDetails() {
    //     return this.educationDetails;
    // }

    // public void setEducationDetails(EducationDetails educationDetails) {
    //     this.educationDetails = educationDetails;
    // }

    @Override
    public String toString() {
        return "Tutorial [salutation=" + salutation + ", firstName=" + firstName + ", middleName=" + middleName
                + ", surName=" + surName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", maritalStatus=" + maritalStatus
                + ", casteCategory=" + casteCategory +"]";// ", educationDetails=" + educationDetails +  "]";
    }
}
