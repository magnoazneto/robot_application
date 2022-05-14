package com.nasa.explorer.robot.entity;

import com.nasa.explorer.robot.config.RobotProperties;
import com.nasa.explorer.robot.exception.RobotOutOfFieldException;
import com.nasa.explorer.robot.service.enums.MovementType;
import com.nasa.explorer.robot.service.enums.Orientation;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class Robot {
    private static final String ROBOT_OUT_OF_FIELD = "Robot out of allowed field.";
    private int xCoordinate;
    private int yCoordinate;
    private Orientation orientation;

    public Robot() {
        resetRobot();
    }

    public void resetRobot() {
        this.xCoordinate = 0;
        this.yCoordinate = 0;
        this.orientation = Orientation.NORTH;
    }

    public void move(MovementType movementType, RobotProperties robotProperties) {
        switch (movementType) {
            case LEFT:
            case RIGHT:
                orientation = orientation.changeByCommand(movementType.getCode());
                break;
            case MOVE_FORWARD:
                moveForward();
                validateFieldSize(robotProperties);
                break;
        }
    }

    private void moveForward() {
        switch (orientation) {
            case NORTH:
                yCoordinate += 1;
                break;
            case EAST:
                xCoordinate += 1;
                break;
            case SOUTH:
                yCoordinate -= 1;
                break;
            case WEST:
                xCoordinate -= 1;
                break;
        }
    }

    private void validateFieldSize(RobotProperties fieldSize) {
        if (xCoordinate < 0
                || yCoordinate < 0
                || xCoordinate >= fieldSize.getxAxisFieldLength()
                || yCoordinate >= fieldSize.getyAxisFieldLength()) {
            this.resetRobot();
            throw new RobotOutOfFieldException(ROBOT_OUT_OF_FIELD);
        }
    }

    public String getFinalPosition() {
        return "(" + xCoordinate + ", "
                + yCoordinate + ", "
                + orientation.code
                + ")";
    }
}
