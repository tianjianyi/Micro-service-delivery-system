package com.yifeng.controller;

import com.yifeng.dao.OrderDao;
import com.yifeng.domain.Order;
import com.yifeng.domain.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderDao orderDao;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderDao.save(order);
    }

    @GetMapping("/findAllByUid/{uid}/{page}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("page") int page, @PathVariable("limit") int limit){
        int index = (page-1)*limit;
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderDao.countByUid(uid));
        orderVO.setData(orderDao.findAllByUid(uid,index,limit));
        System.out.println(orderDao.findAllByUid(uid,index,limit));
        return orderVO;
    }

    @DeleteMapping("/deleteByMid/{mid}")
    public void deleteByMid(@PathVariable("mid") long mid){
        orderDao.deleteByMid(mid);
    }

    @DeleteMapping("/deleteByUid/{uid}")
    public void deleteByUid(@PathVariable("uid") long uid){
        orderDao.deleteByUid(uid);
    }

    @GetMapping("/findAllByState/{state}/{page}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state, @PathVariable("page") int page, @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderDao.countByState(0));
        orderVO.setData(orderDao.findAllByState(0,(page-1)*limit,limit));
        return orderVO;
    }

    @PutMapping("/updateState/{id}/{state}/{aid}")
    public void updateState(@PathVariable("id") long id, @PathVariable("state") int state, @PathVariable("aid") long aid){
        orderDao.updateState(id,aid,state);
    }
}
