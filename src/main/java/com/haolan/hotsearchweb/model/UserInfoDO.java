package com.haolan.hotsearchweb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
@TableName("user")
public class UserInfoDO {
    //自动生成主键
    @TableId(type = IdType.AUTO)
    private Long id;

    //用户注册的账号
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{4,15}$")
    @Size(min = 4, max = 15, message = "用户账号长度为 4-15 个字符")
    private String username;


    //用户的密码
    @Pattern(regexp = "^[a-zA-Z0-9]{6,16}$")
    @Length(min = 6, max = 16, message = "密码长度为 6-16 位")
    private String password;
}
