package com.spring.evaluacion.service;

import com.spring.evaluacion.dto.request.UserRequest;
import com.spring.evaluacion.dto.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest request);
}
