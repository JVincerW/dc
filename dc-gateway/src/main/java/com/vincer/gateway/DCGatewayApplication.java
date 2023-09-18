package com.vincer.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 网关启动程序
 *
 * @author vincer
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DCGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DCGatewayApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  数据中台网关启动成功   ლ(´ڡ`ლ)ﾞ");
    }
}
