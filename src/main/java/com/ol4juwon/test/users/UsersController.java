package com.ol4juwon.test.users;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ol4juwon.test.repository.UsersRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UsersController {
    @Autowired
    UsersRepository userrepo;

    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody Users newUser) {
        List<Users> users = userrepo.findAll();
        System.out.println("New User: "+ newUser.toString());

        for(Users user: users){
            System.out.println("Registered user: " + newUser.toString());
            if(user.equals(newUser)){
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userrepo.save(newUser);
        return Status.SUCCESS;
    }

    @PostMapping("users/login")
    public Status loginUser(@Valid @RequestBody Users user){
        List<Users> users = userrepo.findAll();
        for(Users others: users){
            if(others.equals(user)){
                // user.setLoggedIn(true);
                userrepo.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @GetMapping("users/all")
    public List<Users> getAll(){
        return userrepo.findAll();
    }
}
