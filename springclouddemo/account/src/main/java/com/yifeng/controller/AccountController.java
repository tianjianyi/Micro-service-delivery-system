package com.yifeng.controller;

import com.yifeng.dao.AdminDao;
import com.yifeng.dao.UserDao;
import com.yifeng.domain.Account;
import com.yifeng.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AdminDao adminDao;
    @GetMapping("/login/{username}/{password}/{type}")
    public Account login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type){
        Account account = null;
        System.out.println(type);
        switch (type){
            case "user":
                account = userDao.login(username, password);
                break;
            case "admin":
                account = adminDao.login(username, password);
                System.out.println(account);
                break;
        }
        return account;
    }
}
