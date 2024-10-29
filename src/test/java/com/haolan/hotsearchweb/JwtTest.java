package com.haolan.hotsearchweb;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt测试类
 */
public class JwtTest {

    @Test
    public void test() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("username", "haolan");

        String token = JWT.create()
                .withClaim("user", map)  //载荷信息
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60))  //token过期时间
                .sign(Algorithm.HMAC256("haolan"));  //通过算法，设置密钥，生成token

        System.out.println(token);
    }

    @Test
    public void test2() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoiMSIsInVzZXJuYW1lIjoiaGFvbGFuIn0sImV4cCI6MTczMDIxMTczM30.LVI3_6tQhOEjnzu1IIQEnKKMzX9ZgKiTerMfvQM2DHk";

        // 解析token
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("haolan")).build();
        // 验证token
        DecodedJWT verify = verifier.verify(token);
        // 获取token信息
        Map<String, Claim> claims = verify.getClaims();
        System.out.println(claims.get("user"));
    }
}
