package com.digital.scripter.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mohammad Aiub Khan
 * Created: 1/6/2024
 */
@RestController
@RequestMapping("/scripts")
public class ScriptController {
    @RequestMapping("/greet")
    public ResponseEntity<String> greetings() {
        return new ResponseEntity<>("Welcome", HttpStatus.OK);
    }
}
