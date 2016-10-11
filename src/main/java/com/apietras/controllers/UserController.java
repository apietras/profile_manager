package com.apietras.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apietras.dto.CreateUserDTO;
import com.apietras.dto.ModifyUserDTO;
import com.apietras.model.User;
import com.apietras.model.mappers.UserMapper;
import com.apietras.services.UserService;
import com.apietras.services.exceptions.UserAlreadyExistsException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;
    
    @RequestMapping("/user/edit")
    public String getUserPage(@ModelAttribute("currentUser") UserDetails currentUser, Model model) {
        //the user is one that is logged in - it has to exist
        User user = userService.getUserByEmail(currentUser.getUsername()).get();
        model.addAttribute("user", user);
        model.addAttribute("form", userMapper.map(user));
        return "welcome";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        return new ModelAndView("register", "form", new CreateUserDTO());
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") CreateUserDTO form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        try {
            userService.create(userMapper.map(form));
        } catch (UserAlreadyExistsException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "register";
        }
        return "redirect:/login?created";
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("currentUser") UserDetails currentUser, @Valid @ModelAttribute("form") ModifyUserDTO form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "welcome";
        }
        User user = userService.getUserByEmail(currentUser.getUsername()).get();
        User updatedUser = userMapper.map(form);
        updatedUser.setId(user.getId());
        userService.update(updatedUser);
        return "redirect:/user/edit";
    }
}


