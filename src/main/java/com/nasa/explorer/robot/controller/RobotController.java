package com.nasa.explorer.robot.controller;

import com.nasa.explorer.robot.service.MovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/rest/mars")
@Validated
public class RobotController {

    private MovementService service;

    public RobotController(MovementService service) {
        this.service = service;
    }

    @PostMapping("/{instructions}")
    public ResponseEntity<String> moveRobot(
            @PathVariable("instructions") @Valid @Pattern(regexp = "[LRM]+") String instructions) {
        return ResponseEntity.ok(service.moveRobot(instructions));
    }
}
