package com.student.entity;

public class Student {
    private String sclass;
    private int son;
    private String sname;
    private double sgrade;
    private int sage;
    private String saddress;

    public Student(String sclass, int son, String sname, double sgrade, int sage, String saddress) {
        this.sclass = sclass;
        this.son = son;
        this.sname = sname;
        this.sgrade = sgrade;
        this.sage = sage;
        this.saddress = saddress;
    }

    public Student() {

    }

    public Student(String sname, int sage, String saddress) {
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
    }

    public Student(int son, String sname, int sage, String saddress) {
        this.son = son;
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public double getSgrade() {
        return sgrade;
    }

    public void setSgrade(double sgrade) {
        this.sgrade = sgrade;
    }

    public int getSon() {
        return son;
    }

    public void setSon(int son) {
        this.son = son;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sclass='" + sclass + '\'' +
                ", son=" + son +
                ", sname='" + sname + '\'' +
                ", sgrade=" + sgrade +
                ", sage=" + sage +
                ", saddress='" + saddress + '\'' +
                '}';
    }
}
