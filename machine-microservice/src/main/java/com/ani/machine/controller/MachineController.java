package com.ani.machine.controller;

import com.ani.machine.domain.Machine;
import com.ani.machine.repository.MachineRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/machine")
@RestController
@AllArgsConstructor
public class MachineController {

    private final MachineRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Machine machine) {
        repository.save(machine);
    }

    @GetMapping
    public List<Machine> all() {
        return repository.findAll();
    }
}
