package com.subhan.springbootthymeleaf.service.impl;

import com.subhan.springbootthymeleaf.entity.User;
import com.subhan.springbootthymeleaf.exception.DuplicateEmailException;
import com.subhan.springbootthymeleaf.repository.UserRepository;
import com.subhan.springbootthymeleaf.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public boolean isEmailExist(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void saveEmployee(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        User user = null;
        if (byId.isPresent()) {
            user = byId.get();
        }else {
            throw new RuntimeException("User not Found for id ::" + id);
        }
        return user;
    }

    @Override
     public void removeByEmployeeId(Long id) {
        userRepository.deleteById(id);
    }
}
