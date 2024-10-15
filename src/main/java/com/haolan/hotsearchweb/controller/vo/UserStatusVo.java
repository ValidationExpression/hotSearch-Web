package com.haolan.hotsearchweb.controller.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserStatusVo {
    @NotNull(message = "角色编号不能为空")
    private Long id;

    private Integer Status;
}
