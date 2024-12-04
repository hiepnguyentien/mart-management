package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.OrderDetailDTO;
import com.hiep.mart.service.OrderDetailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/order-detail")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderDetailController {

    OrderDetailService orderDetailService;

    @GetMapping("/view-all/{orderId}")
    public List<OrderDetailDTO> getOrderDetailsByOrderId(@RequestParam("orderId") Long orderId) {
        return orderDetailService.viewOrderDetail(orderId);
    }
}
