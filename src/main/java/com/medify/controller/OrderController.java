package com.medify.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medify.entity.Order;
import com.medify.service.OrderService;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getOrder() {
        return orderService.fetchAllOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/getOrdersByStoreId/{storeId}")
    public List<Order> getOrderByStoreId(@PathVariable Long storeId) {
        return orderService.fetchAllOrdersByStoreId(storeId);
    }
    
    @GetMapping("/getSalesReportByStoreId/{storeId}")
    public Map<?, ?> getSalesReportByStoreId(@PathVariable Long storeId) {
        return orderService.getSalesReportByStoreId(storeId);
    }
    
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
        Order currentOrder = orderService.updateOrderById(null, order);
        return ResponseEntity.ok(currentOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrderById(orderId);
        return ResponseEntity.ok().build();
    }
    
    
    
    

}
