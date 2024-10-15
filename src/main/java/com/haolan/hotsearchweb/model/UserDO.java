package com.haolan.hotsearchweb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
@TableName("user")
public class UserDO {

    //自动生成主键
    @TableId(type = IdType.AUTO)
    private Long id;

    //用户注册的账号
    @NotBlank(message = "用户账号不能为空")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{4,15}$")
    @Size(min = 4, max = 15, message = "用户账号长度为 4-15 个字符")
    private String username;

    //用户的展示昵称
    @Pattern(regexp = "^\\S{1,10}$")
    @Size(max = 10, message = "用户昵称长度不能超过10个字符")
    private String nickname;

    //用户的密码
    @NotBlank(message = "用户密码不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,16}$")
    @Length(min = 6, max = 16, message = "密码长度为 6-16 位")
    private String password;

    private int sex;
    private int age;

    //状态
    private int status;
}
