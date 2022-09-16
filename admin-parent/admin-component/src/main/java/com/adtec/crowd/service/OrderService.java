package com.adtec.crowd.service;

import com.adtec.crowd.entity.po.OrderPO;

import java.util.List;

public interface OrderService {

    void saveOrder(OrderPO orderPO);

    List<OrderPO> getAll();
}
