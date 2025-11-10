package com.spring.evaluacion.service.impl;

import com.spring.evaluacion.dto.request.PhoneRequest;
import com.spring.evaluacion.dto.request.UserRequest;
import com.spring.evaluacion.dto.response.UserResponse;
import com.spring.evaluacion.exception.EmailAlreadyExistsException;
import com.spring.evaluacion.persistence.entity.User;
import com.spring.evaluacion.persistence.repository.UserRepository;
import com.spring.evaluacion.security.JwtTokenUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtTokenUtil jwtTokenUtil;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private UserRequest request;
    private User user;

    @BeforeEach
    void setUp() {
        request = new UserRequest();
        request.setName("Luis Gonzales");
        request.setEmail("luis@example.com");
        request.setPassword("Luis27042025#");
        request.setPhones(Collections.singletonList(new PhoneRequest("987654321", "01", "51")));

        user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
    }

    @Test
    void shouldCreateUserSuccessfully() {
        when(userRepository.existsByEmail(request.getEmail())).thenReturn(false);
        when(modelMapper.map(request, User.class)).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(jwtTokenUtil.generateToken(anyString())).thenReturn("fake-jwt-token");
        when(modelMapper.map(user, UserResponse.class)).thenReturn(new UserResponse());

        UserResponse response = userService.createUser(request);

        assertNotNull(response);
        verify(userRepository, times(1)).save(any(User.class));
        verify(jwtTokenUtil, times(1)).generateToken(anyString());
    }

    @Test
    void shouldThrowWhenEmailAlreadyExists() {
        when(userRepository.existsByEmail(request.getEmail())).thenReturn(true);
        assertThrows(EmailAlreadyExistsException.class, () -> userService.createUser(request));
        verify(userRepository, never()).save(any());
    }
}
