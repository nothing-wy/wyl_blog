package com.wyl.common.core.security.util;

import com.wyl.common.core.constant.TokenConstants;
import com.wyl.common.core.security.entity.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description Jwt 工具类 生成token 以及验证token、刷新token相关方法
 * @Author wy
 * @Date 2021/8/14
 */
@Slf4j
@Component
public class TokenUtil {
    /**
     * 生成Jwt
     *
     * @param sysUser security用户实体
     * @return Jwt
     */
    public static String createToken(SysUser sysUser) {
        return Jwts.builder()
                // 主题
                .setSubject(sysUser.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer(TokenConstants.ISS)
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + TokenConstants.EXPIRATION))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, TokenConstants.SECRET)
                .compact();
    }

    /**
     * 解析token，拿到负载信息
     *
     * @param token token
     * @return 负载信息
     */
    private static Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(TokenConstants.SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("JWT反解析失败，token已过期或不正确，token:{}", token);
        }
        return claims;
    }

    /**
     * 从token中获得主题Subject(用户名username)
     *
     * @param token token
     * @return username
     */
    public static String getSubjectFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        if (claims != null) {
            return claims.getSubject();
        } else {
            return null;
        }
    }

    /**
     * 校验token是否还有效
     *
     * @param token       客户端传来的token
     * @param userDetails 从数据库查询出来的用户信息
     */
    public static boolean validateToken(String token, UserDetails userDetails) {
        Claims claims = getClaimsFromToken(token);
        return claims.getSubject().equals(userDetails.getUsername()) && !isTokenExpired(claims);
    }

    /**
     * 判断token是否已经过期
     *
     * @param claims 负载信息
     */
    private static boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }

}
