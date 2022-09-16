package com.adtec.crowd.entity.po;

public class AddressPO {
    private Integer id;

    private String receiveName;

    private String phoneNum;

    private String address;

    private Integer memberId;

    public AddressPO(Integer id, String receiveName, String phoneNum, String address, Integer memberId) {
        this.id = id;
        this.receiveName = receiveName;
        this.phoneNum = phoneNum;
        this.address = address;
        this.memberId = memberId;
    }

    public AddressPO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName == null ? null : receiveName.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}