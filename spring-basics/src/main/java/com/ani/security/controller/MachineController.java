package com.ani.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/machine")
@RestController
public class MachineController {

    @GetMapping
    public String start() {
        return "Started";
    }
}
