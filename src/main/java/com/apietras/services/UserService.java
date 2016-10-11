package com.apietras.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apietras.model.User;
import com.apietras.services.exceptions.UserAlreadyExistsException;

/**
 * This service represents functions connected with user.
 */
@Service
public interface UserService {

    /**
     * This method returns user by user id.
     * @param id  user id to look for
     * @return user with given id
     */
    Optional<User> getUserById(long id);

    /**
     * This method returns user by user email.
     * @param email user email to look for
     * @return user with given email

     */
    Optional<User> getUserByEmail(String email);

    /**
     * This method creates new user.
     * @param user to create
     * @return created user
     * @throws UserAlreadyExistsException
     */
    User create(User user)throws UserAlreadyExistsException;

    /**
     * This method update  user.
     * @param user to update
     * @return updated user
     */
    User update(User user);
}
