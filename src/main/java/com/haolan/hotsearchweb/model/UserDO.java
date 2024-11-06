package com.haolan.hotsearchweb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;


@Data
@TableName("user")
public class UserDO {
    //自动生成主键
    @TableId(type = IdType.AUTO)
    private Integer id;

    //用户注册的账号
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{4,15}$")
    @Size(min = 4, max = 15, message = "用户账号长度为 4-15 个字符")
    private String username;

    //用户的展示昵称
    @Pattern(regexp = "^\\S{1,10}$")
    @Size(max = 10, message = "用户昵称长度不能超过10个字符")
    private String nickname;

    //用户的密码
    @Pattern(regexp = "^[a-zA-Z0-9]{6,16}$")
    @Length(min = 6, max = 16, message = "密码长度为 6-16 位")
    @JsonIgnore  //作用：当springmvc把当前对象转换为json时，忽略password属性，不返回这个字段。
    private String password;

    private int sex;
    private int age;

    @URL
    private String user_pic;
    //状态
    private int status;

    public String toString() {
        return "UserDO [id=" + id + ", username=" + username + ", nickname=" + nickname + ", password=" + password
                + ", sex=" + sex + ", age=" + age + ", user_pic=" + user_pic + ", status=" + status + "]";
    }
}
