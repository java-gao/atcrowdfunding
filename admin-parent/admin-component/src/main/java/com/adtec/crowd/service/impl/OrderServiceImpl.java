package com.adtec.crowd.service.impl;

import com.adtec.crowd.entity.po.OrderPO;
import com.adtec.crowd.entity.po.OrderPOExample;
import com.adtec.crowd.mapper.OrderPOMapper;
import com.adtec.crowd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderPOMapper orderPOMapper;

    public void saveOrder(OrderPO orderPO) {

        orderPOMapper.insert(orderPO);
        throw new RuntimeException();
    }

    public List<OrderPO> getAll() {
        return orderPOMapper.selectByExample(new OrderPOExample());
    }


}
