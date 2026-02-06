package com.spring.java.user.dto;

import lombok.Data;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {

    private String email;
    private String password;
}