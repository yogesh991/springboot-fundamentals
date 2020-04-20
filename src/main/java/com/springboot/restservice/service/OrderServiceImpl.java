package com.springboot.restservice.service;/* 
@Author : Yogesh Deshmukh
*/

import com.springboot.restservice.entity.Order;
import com.springboot.restservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Optional<Order> getOrderByOrderId(Long orderid) {
        return orderRepository.findById(orderid);
    }


}
