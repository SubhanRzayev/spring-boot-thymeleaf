package com.subhan.springbootthymeleaf.service;

import com.subhan.springbootthymeleaf.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUser();
    boolean isEmailExist(String email);
    public void saveEmployee(User user);
    User getUserById(Long id);
    public void removeByEmployeeId(Long id);

}
