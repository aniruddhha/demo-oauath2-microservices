package com.ani.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class Machine {
    private Long id;
    private String name;
    private Boolean isPlc;
    private String status;
}
