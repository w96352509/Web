package com.web.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person1")
public class Person1 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//使用資料庫的定義id側略序號向下增加
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "age", nullable = true)
    private String age;
    @Column
    private Date ts = new Date();

    public Person1() {
    }

    public Person1(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person1{" + "id=" + id + ", name=" + name + ", age=" + age + ", ts=" + ts + '}';
    }

}
