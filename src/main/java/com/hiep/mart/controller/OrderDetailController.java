package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.OrderDetailDTO;
import com.hiep.mart.domain.dto.PurchasedProductDTO;
import com.hiep.mart.service.OrderDetailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
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

    @GetMapping("/purchased-product")
    public List<PurchasedProductDTO> getPurchaseOrderDetailsByOrderId(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        return orderDetailService.getProductsPurchased(authorizationHeader);
    }
}
