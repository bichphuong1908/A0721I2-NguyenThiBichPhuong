package com.codegym.casestudy.model.employee;

import com.codegym.casestudy.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 255)
    @Pattern(regexp = "[a-zA-Z]", message = "Chỉ có thể nhập chữ")
    private String name;

    private Date birthDay;

    @NotBlank
    @Size(min = 9, max = 9, message = "Chỉ có thể nhập 9 ký tự")
    @Pattern(regexp = "(^$|[0-9]{9})")
    private String idCard;

    @NotNull
    @Min(value = 5000000, message = "Tối thiểu là 5 triệu")
    @Max(value = 12000000, message = "Tối đa là 12 triệu")
    private Double salary;

    @NotBlank
    @Size(min = 9,max = 10, message = "Số điện thoại chỉ có 9 hoặc 10 ký tự")
    @Pattern(regexp = "(^$|[0-9])")
    private String phoneNumber;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 10, max = 255, message = "Phải có ít nhất 10 ký tự")
    private String address;

    @ManyToOne(targetEntity = Position.class)
    private Position position;

    @ManyToOne(targetEntity = EducationDegree.class)
    private EducationDegree educationDegree;

    @ManyToOne(targetEntity = Division.class)
    private Division division;

    public Employee() {
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

}
