package com.n2n.ssnz.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funders")
public class Funder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funder_id")
    private int funderId;
    @Column(name = "funder_name")
    private String funderName;
    @Column(name = "funder_type")
    private String funderType;
    private String email;
    @Column(name = "phone_number")
    private long phoneNumber;
    private String website;
    private String city;
    private String country;
    @Column(name = "funder_details")
    private String funderDetails;

    @OneToMany(mappedBy = "funder", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Project> projects;

    public int getFunderId() {
        return funderId;
    }

    public void setFunderId(int funderId) {
        this.funderId = funderId;
    }

    public String getFunderName() {
        return funderName;
    }

    public void setFunderName(String funderName) {
        this.funderName = funderName;
    }

    public String getFunderType() {
        return funderType;
    }

    public void setFunderType(String funderType) {
        this.funderType = funderType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFunderDetails() {
        return funderDetails;
    }

    public void setFunderDetails(String funderDetails) {
        this.funderDetails = funderDetails;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Funder{" + "funderId=" + funderId + ", funderName=" + funderName + ", funderType=" + funderType + ", email=" + email + ", phoneNumber=" + phoneNumber + ", website=" + website + ", city=" + city + ", country=" + country + ", funderDetails=" + funderDetails + ", projects=" + projects + '}';
    }

}
