package com.haolan.hotsearchweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haolan.hotsearchweb.model.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
    // 根据用户名查询用户信息
    @Select("SELECT username,password FROM user WHERE username = #{username}")
    UserDO selectUserNameInfo(String username);


    @Insert("insert into help_password(password,md5_password) values (#{oldPassword},#{md5Password})")
    void insertPassword(String oldPassword, String md5Password);


    List<UserDO> selectUser();


    void update(UserDO user);
}
