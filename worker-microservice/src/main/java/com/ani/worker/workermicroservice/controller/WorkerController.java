package com.ani.worker.workermicroservice.controller;

import com.ani.worker.workermicroservice.domain.Worker;
import com.ani.worker.workermicroservice.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping(value = "/api/worker")
@RestController
public class WorkerController {

    private final WorkerRepository repository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody Worker worker) {
        repository.save(worker);
        return "worker saved successfully";
    }

    @GetMapping
    public List<Worker> findAll() {
        return repository.findAll();
    }
}
