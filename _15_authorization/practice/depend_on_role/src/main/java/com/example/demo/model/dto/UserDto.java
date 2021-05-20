package com.example.demo.model.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    @Column(unique = true)
    @NotEmpty(message = "Email không đượcc để trống")
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Email không đúng định dạng")
    private String email;

    @NotEmpty(message = "Mật khẩu không được để trống")
    @Size(min = 6, max = 8, message = "Mật khẩu từ 6 đến 8 kí tự")
    private String password;

    @NotEmpty(message = "Xác nhận mật khẩu không được để trống")
    private String matchingPassword;

    public UserDto() {
    }

    public UserDto(@NotEmpty(message = "Email không đượcc để trống") @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Email không đúng định dạng") String email, @NotEmpty(message = "Mật khẩu không được để trống") String password, @NotEmpty(message = "Xác nhận mật khẩu không được để trống") String matchingPassword) {
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto userDto = (UserDto) o;
        String password = userDto.getPassword();
        String matchPassword = userDto.getMatchingPassword();
        if(!matchPassword.equals(password)){
            errors.rejectValue("matchingPassword", "not.match");
        }
    }
}
