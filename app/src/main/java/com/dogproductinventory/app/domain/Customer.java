package com.dogproductinventory.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "firstname")
    @NotBlank(message = "Can't contain only blank spaces!")
    @Size(max = 20, message = "Max 20 characters!")
    private String firstName;
    
    @Column(name = "lastname")
    @NotBlank(message = "Can't contain only blank spaces!")
    @Size(max = 20, message = "Max 20 characters!")
    private String lastName;
    
    @Size(max = 50, message = "Max 50 characters!")
    @NotBlank(message = "Can't contain only blank spaces!")
    private String address;
    
    @Postcode
    private String postcode;

    @PhoneNumber
    private String phone;

    @Email(message = "Must be valid email address!")
    @NotBlank(message = "Can't contain only blank spaces!")
    private String email;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phone, String email, String address, String postcode) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
        + phone + ", email=" + email + ", address=" + address + ", postcode=" + postcode + "]";
    }

}
