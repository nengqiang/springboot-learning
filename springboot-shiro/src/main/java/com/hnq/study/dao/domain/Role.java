package com.hnq.study.dao.domain;

import java.io.Serializable;
import java.util.*;

public class Role implements Serializable {
    /**
     * 主键,角色id
     */
    private Integer id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    private List<Permission> permissions = new ArrayList<>();

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table s_role
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role.id
     *
     * @return the value of s_role.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role.id
     *
     * @param id the value for s_role.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role.role_name
     *
     * @return the value of s_role.role_name
     *
     * @mbggenerated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role.role_name
     *
     * @param roleName the value for s_role.role_name
     *
     * @mbggenerated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role.user_id
     *
     * @return the value of s_role.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role.user_id
     *
     * @param userId the value for s_role.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role.create_date
     *
     * @return the value of s_role.create_date
     *
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role.create_date
     *
     * @param createDate the value for s_role.create_date
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role.last_update_date
     *
     * @return the value of s_role.last_update_date
     *
     * @mbggenerated
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role.last_update_date
     *
     * @param lastUpdateDate the value for s_role.last_update_date
     *
     * @mbggenerated
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", userId=" + userId +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", permissions=" + permissions +
                '}';
    }

}