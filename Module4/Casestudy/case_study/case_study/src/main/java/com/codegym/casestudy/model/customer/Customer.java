package com.codegym.casestudy.model.customer;

import com.codegym.casestudy.model.contract.Contract;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name")
    @NotEmpty(message = "Không được để trống")
    @Size(min = 5, max = 255,message = "Phải có từ 5 đến 255 ký tự")
    private String name;

    @Column(name = "customer_birth_day")
    @NotNull
    private Date birthday;

    @Column(name = "customer_gender")
    @NotNull
    private Boolean gender;

    @Column(name = "customer_id_card")
    @NotBlank(message = "Không được để trống và không có dấu cách")
    private String idCard;

    @Column(name = "customer_phone_number")
    @NotBlank(message = "Không được để trống và không có dấu cách")
    @Size(min = 9, max = 10, message = "SĐT chỉ có thể có 9 hoặc 10 số")
    private String phoneNumber;

    @Column(name = "customer_email")
    @Email
    @NotBlank(message = "Không được để trống và không có dấu cách")
    private String email;

    @Column(name = "customer_address")
    @NotEmpty(message = "Không được để trống")
    @Size(min = 5, max = 128, message = "Phải có từ 5 đến 128 ký tự")
    private String address;

    @ManyToOne(targetEntity = CustomerType.class)
    private CustomerType customerType;

    @OneToMany(mappedBy = "id")
    private Set<Contract> contract;

    public Customer() {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }
}
