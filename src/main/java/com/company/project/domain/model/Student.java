package com.company.project.domain.model;

import javax.persistence.*;

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "stu_name")
    private String stuName;

    @Column(name = "cource_name")
    private String courceName;

    private Integer score;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return stu_name
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * @param stuName
     */
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    /**
     * @return cource_name
     */
    public String getCourceName() {
        return courceName;
    }

    /**
     * @param courceName
     */
    public void setCourceName(String courceName) {
        this.courceName = courceName;
    }

    /**
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}