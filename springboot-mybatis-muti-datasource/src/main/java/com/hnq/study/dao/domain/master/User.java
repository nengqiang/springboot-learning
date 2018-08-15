package com.hnq.study.dao.domain.master;

import com.hnq.study.dao.domain.cluster.City;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 描述
     */
    private String description;

    private City city;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", city=" + city +
                '}';
    }
}