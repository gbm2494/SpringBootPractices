package com.supermarket.virtualsupermarket.entity;

import javax.persistence.*;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="supplier_id")
    private Long id;

    @Column(name="supplier_name")
    private String name;

    @Column(name="supplier_phone")
    private String phone;

    @Column(name="supplier_email")
    private String email;

    @Column(name="contact_name")
    private String contact_name;

    public Supplier() {
    }

    public Supplier(String name, String phone, String email, String contactName) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.contact_name = contactName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", contact_name='" + contact_name + '\'' +
                '}';
    }
}
