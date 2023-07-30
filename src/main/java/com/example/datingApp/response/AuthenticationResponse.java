package com.example.datingApp.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private int userId;
    private Integer profileId;
    private String token;
}
