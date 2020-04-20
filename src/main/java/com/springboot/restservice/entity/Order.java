package com.springboot.restservice.entity;/* 
@Author : Yogesh Deshmukh
*/

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name= "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    private String orderDescription;

    //Multiple order can be assoicate with one user ...ManyToOne
    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDescription='" + orderDescription + '\'' +
                ", user=" + user +
                '}';
    }

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
