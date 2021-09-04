package com.student.entity;

public class LoginUsers {
    private String uname;
    private String upwd;

    public LoginUsers(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public LoginUsers() {

    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Override
    public String toString() {
        return "LoginUsers{" +
                "uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
