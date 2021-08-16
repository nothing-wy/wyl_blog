package com.wyl.common.core.constant;

/**
 * @Description
 * @Author wy
 * @Date 2021/8/14
 */
public class TokenConstants {
    /**
     * 密钥KEY
     */
    public static final String SECRET = "JWTSecret";
    /**
     * 签发者
     */
    public static final String ISS = "wy";
    /**
     * TokenKey
     */
    public static final String TOKEN_HEADER = "Authorization";
    /**
     * Token前缀字符
     */
    public static final String TOKEN_PREFIX = "Bearer ";
    /**
     * 过期时间
     */
    public static final Integer EXPIRATION = 1000 * 60 * 60 * 12;
    /**
     * 不需要认证的接口 antMatchers
     */
    public static final String[] ANTMATCHERS = {
            // register url
//            "/user/signup",
            // swagger ui
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            // 首页功能
            "/index/**"};

    /**
     * 不经过过滤器的静态资源
     */
    public static final String[] ANTMATCHERS_STATIC = {
            // register url
            "/user/signup",
            // swagger ui
            "/swagger-ui.html",
            // 图标
            "/favicon.ico"};
}
