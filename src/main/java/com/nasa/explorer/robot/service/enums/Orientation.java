package com.nasa.explorer.robot.service.enums;

import java.util.HashMap;
import java.util.Map;

public enum Orientation {
    NORTH('N', 'W', 'E'),
    EAST('E', 'N', 'S'),
    SOUTH('S', 'E', 'W'),
    WEST('W', 'S', 'N');

    public final Character code;
    private final Character commandRightResult;
    private final Character commandLeftResult;
    private static final Map<Character, Orientation> map = new HashMap<>(values().length, 1);

    static {
        for (Orientation orientation : values()) map.put(orientation.code, orientation);
    }

    Orientation(Character code, Character commandLeft, Character commandRightResult) {
        this.code = code;
        this.commandLeftResult = commandLeft;
        this.commandRightResult = commandRightResult;
    }

    public Orientation changeByCommand(Character command) {
        Orientation resultOrientation;
        switch (command) {
            case 'L':
                resultOrientation = map.get(this.commandLeftResult);
                break;
            case 'R':
                resultOrientation = map.get(this.commandRightResult);
                break;
            default:
                throw new IllegalArgumentException("unrecognized command");
        }
        return resultOrientation;
    }
}
