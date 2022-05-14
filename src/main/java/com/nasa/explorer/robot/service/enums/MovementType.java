package com.nasa.explorer.robot.service.enums;

import java.util.HashMap;
import java.util.Map;

public enum MovementType {
    LEFT('L'),
    RIGHT('R'),
    MOVE_FORWARD('M');

    private final Character code;

    MovementType(Character code) {
        this.code = code;
    }

    private static final Map<Character, MovementType> map = new HashMap<>(values().length);

    static {
        for (MovementType movementType : values()) map.put(movementType.code, movementType);
    }

    public static MovementType getMovementByCode(Character code){
        return map.get(code);
    }

    public Character getCode() {
        return code;
    }
}
