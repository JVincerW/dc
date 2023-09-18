package com.vincer.job;

import com.vincer.common.security.annotation.EnableCustomConfig;
import com.vincer.common.security.annotation.EnableRyFeignClients;
import com.vincer.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 定时任务
 *
 * @author vincer
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class DCJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(DCJobApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  定时任务模块启动成功   ლ(´ڡ`ლ)ﾞ");
    }
}
