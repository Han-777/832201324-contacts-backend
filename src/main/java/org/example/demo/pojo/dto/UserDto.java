package org.example.demo.pojo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

// data transfer object
public class UserDto {

    private Integer userId;
    @NotBlank(message = "用户名不能为空") // 去掉空格
    private String userName;
    @Email(message = "邮箱格式不正确")
    private String userEmail;
    @Length(min = 3, max = 12, message = "电话号码长度必须为3-12位")
    private String userPhone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public @NotBlank(message = "用户名不能为空") String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank(message = "用户名不能为空") String userName) {
        this.userName = userName;
    }

    public @Email(message = "邮箱格式不正确") String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(@Email(message = "邮箱格式不正确") String userEmail) {
        this.userEmail = userEmail;
    }

    public @Length(min = 3, max = 12, message = "电话号码长度必须为3-12位") String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(@Length(min = 3, max = 12, message = "电话号码长度必须为3-12位") String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }

}
