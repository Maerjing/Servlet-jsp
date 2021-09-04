package com.student.dao;

import com.student.entity.LoginUsers;

import java.util.List;

public interface ILoginDaoImpl {
    public boolean isExist(String name, String pwd);
    //查询用户
    public LoginUsers login(String name, String pwd);
    //增加用户
    public boolean addLoginUser (LoginUsers loginUsers);
    //查询所有用户
    public List<LoginUsers> queryAllLoginUsers();
}
