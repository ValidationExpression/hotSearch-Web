package com.haolan.hotsearchweb.interceptors;

import com.haolan.hotsearchweb.util.JwtUtil;
import com.haolan.hotsearchweb.util.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.util.Map;

/**
 * 设置拦截器，
 * 作用在用户登录成功之后，将token进行存储，
 * 以便在用户请求时，通过token获取用户信息。
 * 优点：在登录其他页面，需要进行验证才能访问资源，保证资源的安全性。
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Authorization");
        //验证token
        try {
            //从redis中获取相同的token
            //ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            //String redisToken = operations.get(token);
            //if (redisToken==null){
            //    //token已经失效了
            //    throw new RuntimeException();
            //}
            Map<String, Object> claims = JwtUtil.parseToken(token);

            //把业务数据存储到ThreadLocal中，在拦截器中存储，好处当多个地方需要用户数据的时候，直接从ThreadLocal中获取即可。
            // 不在需要解析token的方式获取，而且ThreadLocal是线程安全的。
            ThreadLocalUtil.set(claims);
            //放行
            return true;
        } catch (Exception e) {
            //http响应状态码为401
            response.setStatus(401);
            //不放行
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据, 避免内存泄露
        ThreadLocalUtil.remove();
    }
}
