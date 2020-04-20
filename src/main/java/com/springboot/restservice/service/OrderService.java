package com.springboot.restservice.service;/* 
@Author : Yogesh Deshmukh
*/

import com.springboot.restservice.entity.Order;

import java.util.Optional;


public interface OrderService {

    public void createOrder(Order order);

    public Optional<Order> getOrderByOrderId(Long orderid);
}
