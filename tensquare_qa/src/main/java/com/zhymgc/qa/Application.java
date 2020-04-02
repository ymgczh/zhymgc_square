package com.zhymgc.qa;
import com.zhymgc.utils.IdWorker;
import com.zhymgc.utils.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}


	@Bean public JwtUtil jwtUtil(){ return new JwtUtil(); }
}
