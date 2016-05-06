package com.mengka.model;

import java.io.Serializable;

/**
 *   1.java序列化
 *   2.对象hashcode
 *
 * Created by Administrator on 2016/5/6.
 */
public class StudentDO implements Serializable{

    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
