package com.mengka.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heidou.f
 *         2016/5/10.
 */
public class WorkmateDO implements Serializable {
    private Long id;
    private String name;
    private String address;
    private Date createTime;
    private Date modifiedTime;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
