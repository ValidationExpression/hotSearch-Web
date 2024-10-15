package com.haolan.hotsearchweb.controller;

import com.haolan.hotsearchweb.controller.vo.UserPwdVO;
import com.haolan.hotsearchweb.model.Result;
import com.haolan.hotsearchweb.model.UserDO;
import com.haolan.hotsearchweb.service.user.UserService;
import jakarta.validation.Valid;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.haolan.hotsearchweb.util.Md5Util;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //注册
    @PostMapping("/register")  // 通过validation校验用户名、密码
    // 数据校验：当使用@Valid注解时，Spring会根据在对象字段上定义的约束条件（如@NotNull, @Size, @Pattern等）来验证传入的对象是否符合要求。
    // 请求体绑定：@RequestBody用来将HTTP请求体中的数据绑定到方法的参数上。对于POST或PUT请求，请求体通常包含了需要创建或更新资源的数据。
    public Result register(@Valid @RequestBody UserDO user){
        //查询当前注册的用户是否存在
        UserDO id = userService.selectUserNameInfo(user.getUsername());
        // 如果当前注册的用户已经存在，则返回错误信息
        if(id != null){
            return Result.error("用户名已存在");
        }
        userService.userRegister(user);
        return Result.success();
    }

    // 登录接口，用于后台的登录。
    @PostMapping("/login")
    public Result login(@Valid @RequestBody UserDO user){
        //查询当前注册的用户是否存在
        UserDO userName = userService.selectUserNameInfo(user.getUsername());
        if(userName == null){
            return Result.error("用户名不存在，请注册！");
        }
        //校验用户名和密码
        if (!userName.getPassword().equals(Md5Util.getMD5String(user.getPassword()))){
            return Result.error("密码错误，请重新输入！");
        }
        return Result.success("登录成功...");
    }

    // 修改用户信息
    @PostMapping("/update")
    public Result update(@Valid @RequestBody UserDO user){
        return Result.success();
    }

    //修改用户密码
    @PutMapping("/update-password")
    public Result updatePassword(@Valid @RequestBody UserPwdVO userPwd){
        return Result.success();
    }

    //修改用户状态
    @PutMapping("/update-status")
    public Result updateStatus(@RequestParam("id") String id, @RequestParam("status") Integer status){
        return Result.success();
    }

    // 删除用户
    @DeleteMapping("/delete")
    public Result delete(@RequestParam("id") String id){
        return Result.success();
    }

    /**
     * 分页查询用户
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @GetMapping("/selectUserPage")
    public Result selectUserByPage(@Param("pageSize") Integer pageSize,
                                   @Param("pageNumber") Integer pageNumber){
        return Result.success(userService.selectUserByPage(pageSize, pageNumber));
    }

    //获取用户
    @GetMapping("/getUserInfo")
    public Result getUserInfo(@RequestParam("id") Long id){

        return Result.success();
    }

}
