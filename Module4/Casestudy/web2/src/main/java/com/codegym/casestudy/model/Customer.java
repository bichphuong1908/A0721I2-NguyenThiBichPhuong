package com.codegym.casestudy.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Khong duoc de trong")
    @Size(min = 0, max = 50, message ="ten phai tu 6 den 50 ki tu" )
    private String name;

    private Date birthday;
    private String gender;

    @Size(max = 9, message ="phai du 9 ki tu")
    private String idcard;

//    @NotBlank(message ="Khong duoc de trong")
//    @Pattern(regexp = "/((090|091|(84)+90|(84)+91)+([0-9]{7})\\b)/g", message = "phone khong dung dinh dang")
    @Size(min = 9, max = 10, message = "Không được để trống")
    private String phone;

    @NotEmpty(message = "email không được để trống")
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Email không đúng định dạng")
    private String email;

    private String address;

    @ManyToOne(targetEntity = CustomerType.class)
    private CustomerType customerType;


    public Customer() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
