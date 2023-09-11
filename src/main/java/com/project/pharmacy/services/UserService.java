package com.project.pharmacy.services;

import com.project.pharmacy.dtos.UserDto;
import com.project.pharmacy.models.Login;
import com.project.pharmacy.models.User;
import com.project.pharmacy.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(@Valid UserDto userDto){
        Login login = new Login();
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        BeanUtils.copyProperties(userDto, login);
        user.setDateRegister(LocalDateTime.now());
        User user1 = userRepository.save(user);
        login.setUser(user1);

        return userRepository.save(user);
    }
}
