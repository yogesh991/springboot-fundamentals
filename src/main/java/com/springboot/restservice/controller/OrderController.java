package com.springboot.restservice.controller;/* 
@Author : Yogesh Deshmukh
*/

import com.springboot.restservice.entity.Order;
import com.springboot.restservice.entity.User;
import com.springboot.restservice.exceptions.DataMismatchException;
import com.springboot.restservice.exceptions.OrderNotFoundException;
import com.springboot.restservice.exceptions.UserNotFoundException;
import com.springboot.restservice.service.OrderServiceImpl;
import com.springboot.restservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
@Validated
public class OrderController {

    private static final Logger log = Logger.getLogger(OrderController.class.getName());

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/{userid}/orders")
    public ResponseEntity<List<Order>> getAllOrders(@Valid @PathVariable("userid") Long userid, UriComponentsBuilder builder) throws UserNotFoundException, OrderNotFoundException {
        Optional<User> optionalUser =userService.getUserById(userid);
        if(!optionalUser.isPresent()){
            log.info("Provided User id : "+ userid + " is not found in the database");
            throw new UserNotFoundException("Provided User id : "+ userid + " is not found in the database");
        }else{
            if(optionalUser.get().getOrders().size() == 0 || optionalUser.get().getOrders().isEmpty()){
                log.info("Order not found for userid  : "+ userid);
                throw new OrderNotFoundException("Order for userid : "+userid+" is not found in Database");
            }
        }
        HttpHeaders header = new HttpHeaders();
        header.setLocation(builder.path("/user/{id}").buildAndExpand(userid).toUri());
        return new ResponseEntity<List<Order>>(optionalUser.get().getOrders(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/{userid}/orders")
    public void createOrder(@Valid @PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException {
        Optional<User> optionalUser =userService.getUserById(userid);
        if(!optionalUser.isPresent()){
            log.info("Provided User id : "+ userid + " is not found in the database");
            throw new UserNotFoundException("Provided User id : "+ userid + " is not found in the database");
        }
        User user = optionalUser.get();
        order.setUser(user);

        orderService.createOrder(order);
    }

    @GetMapping("/{userid}/orders/{orderid}")
    public ResponseEntity<Order> getOrderByOrderId(@Valid @PathVariable("userid") Long userid, @Valid @PathVariable("orderid")Long orderid, UriComponentsBuilder uriComponentsBuilder) throws UserNotFoundException, OrderNotFoundException {
        //userid - valid or not
        //orderid - valid or not
        Optional<User> optionalUser = userService.getUserById(userid);
        if(!optionalUser.isPresent()){
            log.info(" User with userId : "+userid+" is not found in database");
            throw new UserNotFoundException(" User with userId : "+userid+" is not found in database");
        }
        Optional<Order> order = orderService.getOrderByOrderId(orderid);
        if(!order.isPresent()){
            log.info("Order with orderId : "+orderid+" is not found in Database");
            throw new OrderNotFoundException("Order with orderId : "+orderid+" is not found in Database");
        }
        if(order.get().getUser().getId() != userid){
            log.info("User with userId : "+userid+" is not Mapped with this OrderId : "+orderid);
            throw new DataMismatchException("User with userId : "+userid+" is not Mapped with this OrderId : "+orderid);
        }
        HttpHeaders headers = new HttpHeaders();
        Map<String, Long> uriVariables= new HashMap<String,Long>();
        uriVariables.put("userid",userid);
        uriVariables.put("orderid",orderid);
        headers.setLocation(uriComponentsBuilder.path("/user/{userid}/orders/{orderid}").buildAndExpand(uriVariables).toUri());
        return new ResponseEntity<Order>(order.get(),HttpStatus.ACCEPTED);
    }

}
