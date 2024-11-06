package com.haolan.hotsearchweb.service.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haolan.hotsearchweb.mapper.UserMapper;
import com.haolan.hotsearchweb.model.UserDO;
import com.haolan.hotsearchweb.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @Override
    public UserDO selectUserNameInfo(String username) {
        // 查询用户
        return userMapper.selectUserNameInfo(username);
    }

    /**
     * 用户注册
     * @param user
     */
    @Override
    public void userRegister(UserDO user) {
        //由于密码是明文，所以需要加密,使用utils工具类进行加密
        //Md5Util.getMD5String(user.getPassword());
        //获取原密码
        String oldPassword = user.getPassword();
        //将加密后的密码进行保存
        userMapper.insertPassword(oldPassword,Md5Util.getMD5String(user.getPassword()));
        // 将明文密码进行加密
        user.setPassword(Md5Util.getMD5String(user.getPassword()));
        // 调用mapper层进行插入
        userMapper.insert(user);
    }

    /**
     * 分页查询用户信息
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @Override
    public PageInfo<UserDO> selectUserByPage(Integer pageSize, Integer pageNumber) {
        // 这句代码要放在查询 mapper 语句的前面
        PageHelper.startPage(pageNumber, pageSize);
        List<UserDO> users = userMapper.selectUser();
        PageInfo<UserDO> UserPageInfo = new PageInfo<>(users);
        return UserPageInfo;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Override
    public int updateUser(UserDO user) {
        //修改用户信息
        return userMapper.updateById(user);
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @Override
    public int deleteUser(String id) {
        return userMapper.deleteById(id);
    }

    /**
     * 修改当前登录用户的基本信息
     * @param user
     */
    @Override
    public void updateUserInfo(UserDO user) {
        userMapper.updateUserInfo(user);
    }

    /**
     * 修改密码
     * @param newPassword
     */
    @Override
    public void updatePassword(Integer id ,String newPassword) {
        // 将明文密码进行加密
        newPassword = Md5Util.getMD5String(newPassword);
        userMapper.updatePassword(id,newPassword);
    }
}
