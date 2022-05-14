package com.nasa.explorer.robot.service.impl;

import com.nasa.explorer.robot.config.RobotProperties;
import com.nasa.explorer.robot.entity.Robot;
import com.nasa.explorer.robot.service.MovementService;
import com.nasa.explorer.robot.service.enums.MovementType;
import org.springframework.stereotype.Service;

@Service
public class MovementServiceImpl implements MovementService {

    private final RobotProperties robotProperties;
    private final Robot robot;

    public MovementServiceImpl(RobotProperties robotProperties, Robot robot) {
        this.robotProperties = robotProperties;
        this.robot = robot;
    }

    @Override
    public String moveRobot(String instructions) {
        for(int i = 0; i < instructions.length(); i++){
            robot.move(MovementType.getMovementByCode(instructions.charAt(i)), robotProperties);
        }
        final String finalPosition = robot.getFinalPosition();
        robot.resetRobot();
        return finalPosition;
    }
}
