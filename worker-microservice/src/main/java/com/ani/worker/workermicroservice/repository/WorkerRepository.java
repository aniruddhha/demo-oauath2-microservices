package com.ani.worker.workermicroservice.repository;

import com.ani.worker.workermicroservice.domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
