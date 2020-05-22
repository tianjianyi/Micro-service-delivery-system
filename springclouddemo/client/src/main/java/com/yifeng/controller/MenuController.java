package com.yifeng.controller;

import com.yifeng.domain.Menu;
import com.yifeng.domain.MenuVo;
import com.yifeng.fegin.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVo findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page - 1) * limit;
        return menuFeign.findAll(index, limit);
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long  id){
        menuFeign.deleteById(id);
        return "redirect:/menu/redirect/menu_manage";
    }

    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("menu_add");
        mv.addObject("list", menuFeign.findTypes());
        return mv;
    }

    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/menu/redirect/menu_manage";
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("menu_update");
        mv.addObject("menu", menuFeign.findById(id));
        mv.addObject("list", menuFeign.findTypes());
        return mv;
    }
    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/menu/redirect/menu_manage";
    }

}
