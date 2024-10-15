package com.haolan.hotsearchweb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("help_password")
public class HelpPasswordDO {
    @TableId(type = IdType.AUTO)
    private Long id;

    // 密码
    private String password;

    // MD5加密后的密码
    private String md5Password;

}
