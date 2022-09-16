package com.adtec.crowd.controller;

import com.adtec.crowd.entity.po.OrderPO;
import com.adtec.crowd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class TestController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap){
        List<OrderPO> orderlist = orderService.getAll();
        modelMap.addAttribute("orderlist",orderlist);
        int i = 10/0;
        return "target";

    }
    @RequestMapping("/send/array.html")
    @ResponseBody
    public String testReceive(@RequestParam("array[]") List<Integer> array){
        for(Integer number:array){
            System.out.println(number);
        }
        return "success";
    }
}

