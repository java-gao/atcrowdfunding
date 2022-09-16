package com.adtec.crowd.entity.po;

public class RolePO {
    private Integer id;

    private String name;

    public RolePO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public RolePO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}