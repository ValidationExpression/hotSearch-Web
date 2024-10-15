package com.haolan.hotsearchweb.controller.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserPwdVO {

    @NotNull(message = "用户编号不能为空")
    private Long id;

    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,16}$")
    @Length(min = 6, max = 16, message = "密码长度为 6-16 位")
    private String password;
}
