package com.haolan.hotsearchweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haolan.hotsearchweb.model.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
    // 根据用户名查询用户信息
    @Select("SELECT * FROM user WHERE username = #{username}")
    UserDO selectUserNameInfo(String username);

}
