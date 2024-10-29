package com.haolan.hotsearchweb.controller;

import com.haolan.hotsearchweb.model.Result;
import com.haolan.hotsearchweb.model.UserDO;
import com.haolan.hotsearchweb.service.user.UserService;
import com.haolan.hotsearchweb.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.haolan.hotsearchweb.util.Md5Util;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param user
     * @return
     */
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

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result login(@Valid @RequestBody UserDO user){
        //查询当前注册的用户是否存在
        UserDO userName = userService.selectUserNameInfo(user.getUsername());
        if(userName == null){
            return Result.error("用户名不存在");
        }
        //校验用户名和密码
        if (!userName.getPassword().equals(Md5Util.getMD5String(user.getPassword()))){
            return Result.error("密码错误，请重新输入！");
        }

        // 生成token，将登录的用户id和用户账号放到token中
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", userName.getId());
        claims.put("username", userName.getUsername());
        String token = JwtUtil.genToken(claims);

        return Result.success(token);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result update(@Valid @RequestBody UserDO user){
        //判断用户是否存在
        UserDO userName = userService.selectUserNameInfo(user.getUsername());
        if(userName == null){
            return Result.error("用户不存在");
        }
        //修改用户信息
        int userId = userService.updateUser(user);
        return Result.success(userId);
    }


    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Result delete(@RequestParam("id") String id){
        int delId = userService.deleteUser(id);
        return Result.success(delId);
    }

    /**
     * 分页查询用户
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @GetMapping("/selectUserPage")
    // 注解说明：@RequestHeader(name = "Authorization") 获取请求头中的token。
    // HttpServletResponse response：相应状态码。
    public Result selectUserByPage(@RequestHeader(name = "Authorization") String token, HttpServletResponse response, @Param("pageSize") Integer pageSize,
                                   @Param("pageNumber") Integer pageNumber){
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            return Result.success(userService.selectUserByPage(pageSize, pageNumber));
        }catch (Exception e){
            response.setStatus(401);
            return Result.error("用户未登录！");
        }
    }
}
