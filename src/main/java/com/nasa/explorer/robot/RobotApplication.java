package com.nasa.explorer.robot;

import com.nasa.explorer.robot.config.RobotProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RobotProperties.class)
public class RobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotApplication.class, args);
	}

}
