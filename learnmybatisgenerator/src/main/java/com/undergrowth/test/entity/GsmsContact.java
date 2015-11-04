package com.undergrowth.test.entity;

import java.util.Date;

public class GsmsContact {
    private Integer id;

    private String name;

    private String phone;

    private Boolean sex;

    private String identifier;

    private Date birthday;

    private Integer birthMonth;

    private Integer birthDay;

    private Boolean vip;

    private String remark;

    private String extension1;

    private String extension2;

    private String extension3;

    private Integer groupId;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getExtension1() {
        return extension1;
    }

    public void setExtension1(String extension1) {
        this.extension1 = extension1 == null ? null : extension1.trim();
    }

    public String getExtension2() {
        return extension2;
    }

    public void setExtension2(String extension2) {
        this.extension2 = extension2 == null ? null : extension2.trim();
    }

    public String getExtension3() {
        return extension3;
    }

    public void setExtension3(String extension3) {
        this.extension3 = extension3 == null ? null : extension3.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}