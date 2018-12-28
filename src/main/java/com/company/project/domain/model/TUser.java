package com.company.project.domain.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class TUser {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_age")
    private Integer userAge;

    @Column(name = "user_gender")
    private Byte userGender;

    @Column(name = "user_salary")
    private BigDecimal userSalary;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "user_remark")
    private String userRemark;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_age
     */
    public Integer getUserAge() {
        return userAge;
    }

    /**
     * @param userAge
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    /**
     * @return user_gender
     */
    public Byte getUserGender() {
        return userGender;
    }

    /**
     * @param userGender
     */
    public void setUserGender(Byte userGender) {
        this.userGender = userGender;
    }

    /**
     * @return user_salary
     */
    public BigDecimal getUserSalary() {
        return userSalary;
    }

    /**
     * @param userSalary
     */
    public void setUserSalary(BigDecimal userSalary) {
        this.userSalary = userSalary;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return user_remark
     */
    public String getUserRemark() {
        return userRemark;
    }

    /**
     * @param userRemark
     */
    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }
}