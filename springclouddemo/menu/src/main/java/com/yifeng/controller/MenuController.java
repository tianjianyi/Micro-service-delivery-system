package com.yifeng.controller;

import com.yifeng.dao.MenuDao;
import com.yifeng.dao.TypeDao;
import com.yifeng.domain.Menu;
import com.yifeng.domain.MenuVo;
import com.yifeng.domain.Type;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private TypeDao typeDao;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

//    @GetMapping("/findAll")
//    public List<Menu> findAll(){
//        System.out.println("------------");
//        menuDao.count();
//        return null;
//    }
    @GetMapping("/findAll/{index}/{limit}")
    public MenuVo findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
//        System.out.println(menuDao.findAll(index,limit));
        List<Menu> list = menuDao.findAll(index, limit);
        return new MenuVo(0, "", menuDao.count(), list);
    }

    @DeleteMapping("/deleteById/{id}")
    public void  deleteById(@PathVariable("id") long id){
        menuDao.deleteById(id);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return typeDao.findTypes();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuDao.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuDao.findById(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody Menu menu){
        menuDao.update(menu);
    }
}
