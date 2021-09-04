package com.student.service.impl;

import com.student.dao.impl.LoginDaoImpl;
import com.student.entity.LoginUsers;
import com.student.service.ILoginService;

import java.util.List;

public class LoginServiceImpl implements ILoginService {
    LoginDaoImpl loginDaoImpl = new LoginDaoImpl();

    //查询是否有该用户名和密码
    @Override
    public boolean queryLogin(String name, String pwd) {
        return loginDaoImpl.isExist(name, pwd);
    }
    //增加用户
    @Override
    public boolean addLoginUser(LoginUsers loginUsers) {
        return loginDaoImpl.addLoginUser(loginUsers);
    }
    //查询所有登录用户
    public List<LoginUsers> queryAllLoginusers(){
        return loginDaoImpl.queryAllLoginUsers();
    }
}
