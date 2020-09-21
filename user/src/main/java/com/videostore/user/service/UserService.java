package com.videostore.user.service;

import com.videostore.user.model.User;
import com.videostore.user.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserRepository userRepository;

    public User userLogin(String userEmail, String userPassword){
        return userRepository.findByUserEmailAndPassword(userEmail, userPassword);
    }

    public User userPersist(User user){
        User userSaved = userRepository.save(user);
        return userSaved;
    }

    public User findUserByEmail(String userEmail){
        return userRepository.findByUserEmail(userEmail);
    }

    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }
}
