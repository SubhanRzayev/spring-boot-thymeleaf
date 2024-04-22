package com.subhan.springbootthymeleaf.controller;

import com.subhan.springbootthymeleaf.entity.User;
import com.subhan.springbootthymeleaf.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
public class UserController {


    private final UserService userService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listUsers",userService.getUser());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("user") User user,Model model ) {
        if (userService.isEmailExist(user.getEmail())) {
            model.addAttribute("error","Email address already exists ");
            return "new_employee";
        }
        userService.saveEmployee(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user",userService.getUserById(id));
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        userService.removeByEmployeeId(id);
            return "redirect:/";
    }




}
