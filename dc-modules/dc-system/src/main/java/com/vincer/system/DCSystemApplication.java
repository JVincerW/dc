package com.vincer.system;

import com.vincer.common.security.annotation.EnableCustomConfig;
import com.vincer.common.security.annotation.EnableRyFeignClients;
import com.vincer.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 系统模块
 *
 * @author vincer
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class DCSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(DCSystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ");
    }
}
