package com.haolan.hotsearchweb.controller;

import com.haolan.hotsearchweb.model.Result;
import com.haolan.hotsearchweb.model.UserDO;
import com.haolan.hotsearchweb.service.user.UserService;
import com.haolan.hotsearchweb.util.JwtUtil;
import com.haolan.hotsearchweb.util.ThreadLocalUtil;
import jakarta.validation.Valid;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import com.haolan.hotsearchweb.util.Md5Util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
     * @return
     */
    @PostMapping("/login")
    public Result login(String username, String password){
        //查询当前注册的用户是否存在
        UserDO userName = userService.selectUserNameInfo(username);
        if(userName == null){
            return Result.error("用户名不存在");
        }
        //校验用户名和密码
        if (!userName.getPassword().equals(Md5Util.getMD5String(password))){
            return Result.error("密码错误，请重新输入！");
        }

        // 生成token，将登录的用户id和用户账号放到token中
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", userName.getId());
        claims.put("username", userName.getUsername());
        String token = JwtUtil.genToken(claims);

        //把token存储到redis中
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(token,token,1, TimeUnit.HOURS);

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
     * 修改当前登录的用户信息(也可以修改头像)
     * @param user
     */
    @PostMapping("/updateUser")
    public Result updateUser(@Valid @RequestBody UserDO user){
        // 从ThreadLocal中获取用户信息
        Map<String, Object> map = ThreadLocalUtil.get();
        user.setId((Integer) map.get("id"));
        //修改用户信息
        userService.updateUserInfo(user);
        return Result.success();
    }

    /**
     * 修改密码
     */
    @PatchMapping("/updatePassword")
    public Result updatePassword(@RequestParam("oldPassword") String oldPassword,
                                  @RequestParam("newPassword") String newPassword,
                                 @RequestHeader("Authorization") String token){
        // 从ThreadLocal中获取用户信息
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        //获取当前用户的密码
        UserDO userDo = userService.selectUserNameInfo(username);
        if(!userDo.getPassword().equals(Md5Util.getMD5String(oldPassword))){
            return Result.error("旧密码错误");
        }
        // 调用mapper层进行密码修改
        userService.updatePassword(userDo.getId(),newPassword);

        // 删除redis中的token
        stringRedisTemplate.delete(token);
        return Result.success();
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
    public Result selectUserByPage(@Param("pageSize") Integer pageSize,
                                   @Param("pageNumber") Integer pageNumber){
        System.out.println("pageSize:"+pageSize);
        return Result.success(userService.selectUserByPage(pageSize, pageNumber));

    }

    /**
     * 获取用户信息
     * @return
     * 通过token获取用户信息
     */
    @GetMapping("/getUserInfo")
    public Result<UserDO> getUserInfo(/**@RequestHeader(name = "Authorization") String token*/){
        // 从ThreadLocal中获取用户信息
        Map<String, Object> map = ThreadLocalUtil.get();
        return Result.success(userService.selectUserNameInfo((String) map.get("username")));
    }
}
