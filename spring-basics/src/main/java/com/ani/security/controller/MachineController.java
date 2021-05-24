package com.ani.security.controller;

import com.ani.security.domain.Machine;
import com.ani.security.domain.ResponseDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/machine")
@RestController
public class MachineController {

    @PreAuthorize("hasAnyRole('ROLE_MACHINE')")
    @GetMapping("/status") // http://localhost:8085/api/machine/status
    public Machine status() {
        return new Machine(1L, "abc", true, "idle");
    }

    @PreAuthorize("hasAnyRole('ROLE_MACHINE')")
    @PutMapping("/start/{status}") // http://localhost:8085/api/machine/start/start
    public ResponseDTO start(@PathVariable String status) {
        return new ResponseDTO("machine started", "success");
    }

    @PreAuthorize("hasAuthority('machine:stop')")
    @PutMapping("/stop")
    public ResponseDTO stop() {
        return new ResponseDTO("machine stopped", "success");
    }
}
