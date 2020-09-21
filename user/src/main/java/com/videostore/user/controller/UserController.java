package com.videostore.user.controller;

import com.videostore.user.model.User;
import com.videostore.user.model.UserAuthJSON;
import com.videostore.user.model.UserJSON;
import com.videostore.user.service.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Fernando Lima
 * @date 21/09/2020
 **/

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "User Service", description = "Version 1.0")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ApiOperation(value = "Return user or users in database with or without filter")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User(s) found"),
            @ApiResponse(code = 204, message = "Users not found"),
            @ApiResponse(code = 401, message = "Not Found user"),
            @ApiResponse(code = 400, message = "Invalid email format"),
            @ApiResponse(code = 404, message = "Not Found user")
    })
    public ResponseEntity<?> getUsers(
            @ApiParam(value="User email to find (Optional)", name = "User Email")
            @RequestParam("emailUser") Optional<String> emailUser){

        if(!emailUser.isEmpty()){
            if(!EmailValidator.getInstance().isValid(emailUser.get())) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            User userDB = userService.findUserByEmail(emailUser.get());
            if(userDB != null) return new ResponseEntity<>(userDB,HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<User> users = userService.findAllUsers();
        if(users == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(users,HttpStatus.OK);

    }





    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a user access", notes = "Provide user information's to create access.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully generate response"),
            @ApiResponse(code = 400, message = "User not persisted")
    })
    public ResponseEntity<?> postCreateUser(@ApiParam(value="JSON format with user information", name = "User Information") @RequestBody UserJSON user){
        if(!EmailValidator.getInstance().isValid(user.getUserEmail()) || userService.findUserByEmail(user.getUserEmail()) != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        User userCreation = new User();
        userCreation.setUserEmail(user.getUserEmail());
        userCreation.setUserName(user.getUserName());
        userCreation.setPassword(DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes()));

        userCreation = userService.userPersist(userCreation);
        if(userCreation == null) return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(userCreation,HttpStatus.OK);
    }




    @PostMapping(value = "/auth", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Authenticate endpoint", notes = "Provide username and password to authenticate in to the system.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully generate response"),
            @ApiResponse(code = 401, message = "Unauthorized access response")
    })
    public ResponseEntity<?> postLogin(@ApiParam(value="JSON format with user credentials", name = "User Information") @RequestBody UserAuthJSON user){
        User userDB = userService.userLogin(user.getUserEmail(), DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes()));
        if(userDB == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(userDB,HttpStatus.OK);
    }

}
