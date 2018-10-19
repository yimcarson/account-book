package com.my.accountbook.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String headimage;

    private String email;

    private String mobile;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date signupTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date signinTime;

    private String signinIp;

    private Byte status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date insertTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private Boolean isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage == null ? null : headimage.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getSignupTime() {
        return signupTime;
    }

    public void setSignupTime(Date signupTime) {
        this.signupTime = signupTime;
    }

    public Date getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(Date signinTime) {
        this.signinTime = signinTime;
    }

    public String getSigninIp() {
        return signinIp;
    }

    public void setSigninIp(String signinIp) {
        this.signinIp = signinIp == null ? null : signinIp.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"nickname\":\"")
                .append(nickname).append('\"');
        sb.append(",\"headimage\":\"")
                .append(headimage).append('\"');
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"mobile\":\"")
                .append(mobile).append('\"');
        sb.append(",\"signupTime\":\"")
                .append(signupTime).append('\"');
        sb.append(",\"signinTime\":\"")
                .append(signinTime).append('\"');
        sb.append(",\"signinIp\":\"")
                .append(signinIp).append('\"');
        sb.append(",\"status\":")
                .append(status);
        sb.append(",\"insertTime\":\"")
                .append(insertTime).append('\"');
        sb.append(",\"updateTime\":\"")
                .append(updateTime).append('\"');
        sb.append(",\"isDelete\":")
                .append(isDelete);
        sb.append('}');
        return sb.toString();
    }
}