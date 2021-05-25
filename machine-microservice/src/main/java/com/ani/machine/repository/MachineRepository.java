package com.ani.machine.repository;

import com.ani.machine.domain.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Long> {
}
