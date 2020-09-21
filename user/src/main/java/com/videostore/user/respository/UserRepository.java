package com.videostore.user.respository;

import com.videostore.user.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

public interface UserRepository extends CrudRepository<User, String> {
    User findByUserEmailAndPassword(String userName, String userPassword);
    User findByUserEmail(String userEmail);
}
