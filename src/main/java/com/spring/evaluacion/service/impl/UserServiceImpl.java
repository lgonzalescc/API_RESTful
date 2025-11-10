package com.spring.evaluacion.service.impl;

import com.spring.evaluacion.dto.request.UserRequest;
import com.spring.evaluacion.dto.response.UserResponse;
import com.spring.evaluacion.exception.EmailAlreadyExistsException;
import com.spring.evaluacion.persistence.entity.User;
import com.spring.evaluacion.persistence.repository.UserRepository;
import com.spring.evaluacion.security.JwtTokenUtil;
import com.spring.evaluacion.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public UserResponse createUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
                throw new EmailAlreadyExistsException();
        }
        User user = modelMapper.map(request, User.class);
        user.getPhones().forEach(p -> p.setUser(user));

        String jwt = jwtTokenUtil.generateToken(user.getEmail());
        user.setToken(jwt);

        User userSaved = userRepository.save(user);
        return modelMapper.map(userSaved, UserResponse.class);
    }
}
