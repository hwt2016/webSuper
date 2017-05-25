package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by hwt on 2017/5/25.
 */
@SpringBootApplication
//开启注解事务管理
@EnableTransactionManagement
//扫描com.mapper下的文件
@MapperScan("com.mapper")
public class Application {

    public static void main(String args[]){
        SpringApplication.run(Application.class);
    }
}
