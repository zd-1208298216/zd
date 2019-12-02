package com.example.jxxy.myapplication.http.entity;

public class MemberEntity {
    public int member_id;//":35,
    public String uname;//":"123",
    public String password;//":"ICy5YqxZBluWSwVLSNLcA==",
    public String email;//":"123@qq.com",
    public int sex;//":0,
    public String mobile;//":"",
    public long regtime;//":1538211511000,
    public long lastlogin;//":1540285150000,
    public String image;//":"",
    public String memberAddresses;//":null

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public long getRegtime() {
        return regtime;
    }

    public void setRegtime(long regtime) {
        this.regtime = regtime;
    }

    public long getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(long lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMemberAddresses() {
        return memberAddresses;
    }

    public void setMemberAddresses(String memberAddresses) {
        this.memberAddresses = memberAddresses;
    }

    @Override
    public String toString() {
        return "MemberEntity{" +
                "member_id=" + member_id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", regtime=" + regtime +
                ", lastlogin=" + lastlogin +
                ", image='" + image + '\'' +
                ", memberAddresses='" + memberAddresses + '\'' +
                '}';
    }
}
