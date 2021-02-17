package com.example.design.controller;

import com.example.design.entity.UsersAccount;
import com.example.design.service.UsersAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersAccountService usersAccountService;

    @ResponseBody
    @RequestMapping(value = "/getUserAccount/{id}", method = RequestMethod.GET)
    public UsersAccount getUser(@PathVariable int id) {
        return usersAccountService.getUsersAccount(id);
    }


}
