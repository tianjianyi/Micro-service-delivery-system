package com.yifeng.controller;

import com.yifeng.domain.Menu;
import com.yifeng.domain.MenuVo;
import com.yifeng.domain.User;
import com.yifeng.domain.UserVO;
import com.yifeng.fegin.MenuFeign;
import com.yifeng.fegin.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
//        System.out.println("--------");
//        System.out.println(userFeign.findAll(page,limit));
        return userFeign.findAll(page,limit);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userFeign.findById(id);
    }

    @PostMapping("/save")
    public String save(User user){
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }

}
