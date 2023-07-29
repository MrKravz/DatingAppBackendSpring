package com.example.datingApp.requests;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private int age;
    private String email;
    private String password;
}
