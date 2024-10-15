package com.haolan.hotsearchweb.service.user;

import com.haolan.hotsearchweb.mapper.UserMapper;
import com.haolan.hotsearchweb.model.UserDO;
import com.haolan.hotsearchweb.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDO selectUserNameInfo(String username) {
        // 查询用户
        return userMapper.selectUserNameInfo(username);
    }

    @Override
    public void userRegister(UserDO user) {
        System.out.println("-----------user/register"+user.toString());
        //由于密码是明文，所以需要加密,使用utils工具类进行加密
        //Md5Util.getMD5String(user.getPassword());
        user.setPassword(Md5Util.getMD5String(user.getPassword()));
        System.out.println("加密后的密码："+user.toString());
        // 调用mapper层进行插入
        userMapper.insert(user);
    }
}
