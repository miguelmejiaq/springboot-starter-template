package com.example.miguelmejiaq.labs.docker_lab.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class InfoResponse {
    private String environment;
    private String version;
}
