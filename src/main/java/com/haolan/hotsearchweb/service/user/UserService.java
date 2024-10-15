package com.haolan.hotsearchweb.service.user;

import com.haolan.hotsearchweb.model.UserDO;

public interface UserService {

    //查询用户
    UserDO selectUserNameInfo(String username);

    //注册用户
    void userRegister(UserDO user);


}
