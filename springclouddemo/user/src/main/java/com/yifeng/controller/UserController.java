package com.yifeng.controller;


import com.yifeng.dao.UserDao;
import com.yifeng.domain.User;
import com.yifeng.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("/findAll/{page}/{limit}")
    public UserVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit){
//        System.out.println("222222222222");
        int index = (page-1)*limit;
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userDao.count());
        userVO.setData(userDao.findAll(index,limit));
//        System.out.println(page + "--" + limit);
//        System.out.println(userDao.findAll(page, limit));
        return userVO;
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userDao.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        user.setRegisterdate(new Date());
        System.out.println("---------");
        System.out.println(user);
        userDao.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userDao.deleteById(id);
    }

}
