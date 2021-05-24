package com.ani.security.controller;

import com.ani.security.domain.Machine;
import com.ani.security.domain.ResponseDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/machine")
@RestController
public class MachineController {

    @GetMapping("/status") // http://localhost:8085/api/machine/status
    public Machine status() {
        return new Machine(1L, "abc", true, "idle");
    }

    @PutMapping("/start/{status}") // http://localhost:8085/api/machine/start/start
    public ResponseDTO start(@PathVariable String status) {
        return new ResponseDTO("machine started", "success");
    }
}
