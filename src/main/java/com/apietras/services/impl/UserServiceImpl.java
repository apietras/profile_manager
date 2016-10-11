package com.apietras.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apietras.model.User;
import com.apietras.model.dao.UserRepository;
import com.apietras.services.UserService;
import com.apietras.services.exceptions.UserAlreadyExistsException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;



    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    @Transactional
    public User create(User user) throws UserAlreadyExistsException{
        log.info("Creating {}", user);
       Optional <User> existingUser = userRepository.findOneByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException(
                    String.format("There already exists a user with id", user.getId()));
        }
        user = userRepository.save(user);
        log.info("User {} {} was created with id: {}", user.getFirstName(), user.getLastName(), user.getId());
        return user;

    }

    @Override
    public User update(User user) {
        log.info("Updating {}", user);
        User existing = userRepository.findOne(user.getId());
        existing.setSalutation(user.getSalutation());
        existing.setFirstName(user.getFirstName());
        existing.setLastName(user.getLastName());
        existing.setCity(user.getCity());
        existing.setStreet(user.getStreet());
        existing.setHouseNumber(user.getHouseNumber());
        existing.setCountry(user.getCountry());
        existing.setEmail(user.getEmail());
        log.info("User {}  was updated", existing);
        return userRepository.save(existing);
    }

}
