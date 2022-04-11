package com.codegym.casestudy.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDto {
    @NotEmpty(message = "Email không được để trống")
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Email không đúng định dạng")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "Nick name không được để trống")
    private String name;

    @NotEmpty(message = "Mật khẩu không được để trống")
    private String password;

    @NotEmpty(message = "Xác nhận mật khẩu không được để trống")
    private String matchingPassword;

    public UserDto() {
    }

    public UserDto(@NotNull @NotEmpty String email, @NotEmpty String name, @NotNull @NotEmpty(message = "Mật khẩu không được để trống") String password, @NotNull @NotEmpty(message = "Xác nhận mật khẩu không được để trống") String matchingPassword) {
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

}
