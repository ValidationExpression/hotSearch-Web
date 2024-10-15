package com.haolan.hotsearchweb.service.user;

import com.github.pagehelper.PageInfo;
import com.haolan.hotsearchweb.model.UserDO;

import java.util.List;

public interface UserService {

    //查询用户
    UserDO selectUserNameInfo(String username);

    //注册用户
    void userRegister(UserDO user);


    //分页查询用户
    PageInfo<UserDO> selectUserByPage(Integer pageSize, Integer pageNumber);
}