package com.nasa.explorer.robot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "robot")
public class RobotProperties {

    private int xAxisFieldLength;
    private int yAxisFieldLength;

    public int getxAxisFieldLength() {
        return xAxisFieldLength;
    }

    public void setxAxisFieldLength(int xAxisFieldLength) {
        this.xAxisFieldLength = xAxisFieldLength;
    }

    public int getyAxisFieldLength() {
        return yAxisFieldLength;
    }

    public void setyAxisFieldLength(int yAxisFieldLength) {
        this.yAxisFieldLength = yAxisFieldLength;
    }
}
