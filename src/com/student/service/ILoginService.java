package com.student.service;

import com.student.entity.LoginUsers;

import java.util.List;

public interface ILoginService {
    //查询是否有该用户名和密码
    public boolean queryLogin(String name, String pwd);
    //增加用户名和密码
    public boolean addLoginUser(LoginUsers loginUsers);
    //查询所有用户
    public List<LoginUsers> queryAllLoginusers();

}
