package com.example.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees_test1")
@ApiModel(description = "Employee's details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The employee ID.")
    private long id;

    @NotBlank
    @Column(name = "first_name")
    @Size(min = 2, message = "First Name should have atleast 2 characters")
    @ApiModelProperty(notes = "The employee first name.")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    @Size(min = 2, message = "Last Name should have atleast 2 characters")
    @ApiModelProperty(notes = "The employee last name.")
    private String lastName;

    @NotBlank
    @Column(name = "email_address")
    @ApiModelProperty(notes = "The employee email address.")
    private String emailAddress;

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
