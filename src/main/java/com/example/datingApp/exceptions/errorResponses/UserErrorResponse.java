package com.example.datingApp.exceptions.errorResponses;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserErrorResponse {
    private String message;
    private long timestamp;
}
