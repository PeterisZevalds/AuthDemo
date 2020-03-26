package com.auth.AuthDemo.dto;


import com.auth.AuthDemo.entity.UserTests;

import java.math.BigDecimal;
import java.util.List;

public class DtoUser {

    private Long id;
    private String name;
    private String password;
    private BigDecimal score;
    private List<UserTests> userTests;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public List<UserTests> getUserTests() {
        return userTests;
    }

    public void setUserTests(List<UserTests> userTests) {
        this.userTests = userTests;
    }
}
