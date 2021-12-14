package com.mall.common.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置全局跨域请求
 *
 *
 * <p>
 * 跨域问题出现原因
 * <p>
 * 1.浏览器限制
 * 2.跨域
 * 3.XHR(XMLHttpRequest)
 *
 * <p>
 * 浏览器针对网络请求的处理
 * 1.简单请求：get等，ajax请求直接发送
 * 2.非简单请求：post，delete等，ajax请求发送之前浏览器会发送预检命令检查，检查符合发送正式请求
 *
 * <p>
 * 跨域问题解决思路
 * 1.jsonp(将请求修改为script函数，后端需要修改代码，非官方方法为前后端的约定)
 * ，更改为非XHR(XMLHttpRequest)请求
 * 2.filter服务端设置，spring框架可以作用于controller或方法@CrossOrigin
 * 3.隐藏跨域，使用nginx，apache等服务器反向代理
 *
 * @author wqi
 * @date 2021/11/25
 */
//@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //这里：是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*")
                //跨域允许时间
                .maxAge(3600);
    }
}
