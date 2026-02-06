package com.spring.java.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {

    private String jwtToken;
    private String username;
}
