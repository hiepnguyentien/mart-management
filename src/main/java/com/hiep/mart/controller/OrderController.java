package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.OrderDTO;
import com.hiep.mart.domain.request.OrderRequest;
import com.hiep.mart.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/order")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {

    OrderService orderService;

    @GetMapping("/view-all")
    public List<OrderDTO> viewAll(){
        return orderService.viewAllOrder();
    }

    @GetMapping("/view-by-customer/{customerId}")
    public List<OrderDTO> viewByCustomerId(@PathVariable("customerId") Long customerId){
        return orderService.viewOrderByCustomerId(customerId);
    }

    @PostMapping
    public OrderDTO addNew(@RequestBody OrderRequest request){
        return orderService.addOrder(request);
    }
}
