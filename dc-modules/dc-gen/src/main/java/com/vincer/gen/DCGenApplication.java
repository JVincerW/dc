package com.vincer.gen;

import com.vincer.common.security.annotation.EnableCustomConfig;
import com.vincer.common.security.annotation.EnableRyFeignClients;
import com.vincer.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 代码生成
 *
 * @author vincer
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class DCGenApplication {
    public static void main(String[] args) {
        SpringApplication.run(DCGenApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  代码生成模块启动成功   ლ(´ڡ`ლ)ﾞ");
    }
}
