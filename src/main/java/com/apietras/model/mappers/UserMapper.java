package com.apietras.model.mappers;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.apietras.dto.CreateUserDTO;
import com.apietras.dto.ModifyUserDTO;
import com.apietras.model.User;

@Component
public class UserMapper {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User map(CreateUserDTO form) {
        User user = new User();
        user.setSalutation(form.getSalutation());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setCity(form.getCity());
        user.setStreet(form.getStreet());
        user.setHouseNumber(form.getHouseNumber());
        user.setCountry(form.getCountry());
        user.setEmail(form.getEmail());
        user.setPasswordHash(getEncode(form.getPassword()));
        return user;
    }
    
    public ModifyUserDTO map(User user) {
        ModifyUserDTO form = new ModifyUserDTO();
        form.setSalutation(user.getSalutation());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setCity(user.getCity());
        form.setStreet(user.getStreet());
        form.setHouseNumber(user.getHouseNumber());
        form.setCountry(user.getCountry());
        form.setEmail(user.getEmail());
        return form;
    }

    public User map(ModifyUserDTO form) {
        User user = new User();
        user.setSalutation(form.getSalutation());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setCity(form.getCity());
        user.setStreet(form.getStreet());
        user.setHouseNumber(form.getHouseNumber());
        user.setCountry(form.getCountry());
        user.setEmail(form.getEmail());
        return user;
    }

    private String getEncode(String text) {
        return passwordEncoder.encode(text);
    }


}
