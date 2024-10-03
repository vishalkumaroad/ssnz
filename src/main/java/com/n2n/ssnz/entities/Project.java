package com.n2n.ssnz.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "start_date")
    private Date startDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "min_budget")
    private long minBudget;
    @Column(name = "max_budget")
    private long maxBudget;
    @Column(name = "contact_email")
    private String contactEmail;
    @Column(name = "contact_phone")
    private long contactPhoneNumber;
    private String location;
    private String country;
    private int status;
    private int year;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "remainder_date")
    private Date remainderDate;
    private String eligibility;

    @ManyToOne
    @JoinColumn(name = "funder_id")
    private Funder funder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getMinBudget() {
        return minBudget;
    }

    public void setMinBudget(long minBudget) {
        this.minBudget = minBudget;
    }

    public long getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(long maxBudget) {
        this.maxBudget = maxBudget;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public long getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(long contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getRemainderDate() {
        return remainderDate;
    }

    public void setRemainderDate(Date remainderDate) {
        this.remainderDate = remainderDate;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public Funder getFunder() {
        return funder;
    }

    public void setFunder(Funder funder) {
        this.funder = funder;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", minBudget=" + minBudget + ", maxBudget=" + maxBudget + ", contactEmail=" + contactEmail + ", contactPhoneNumber=" + contactPhoneNumber + ", location=" + location + ", country=" + country + ", status=" + status + ", year=" + year + ", remainderDate=" + remainderDate + ", eligibility=" + eligibility + ", funder=" + funder + '}';
    }

}
