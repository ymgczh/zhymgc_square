package com.zhymgc.spit;

import com.zhymgc.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2020-3-25.
 */
@SpringBootApplication
public class SpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class, args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
