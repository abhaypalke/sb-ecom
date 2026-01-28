package com.ecommerce.project.controller;

import com.ecommerce.project.config.AppConstants;
import com.ecommerce.project.payload.OrderDTO;
import com.ecommerce.project.payload.OrderRequestDTO;
import com.ecommerce.project.payload.OrderResponse;
import com.ecommerce.project.payload.OrderStatusUpdateDto;
import com.ecommerce.project.security.services.UserDetailsImpl;
import com.ecommerce.project.service.OrderService;
import com.ecommerce.project.util.AuthUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;
    private final AuthUtil authUtil;

    public OrderController(OrderService orderService, AuthUtil authUtil) {
        this.orderService = orderService;
        this.authUtil = authUtil;
    }


    @PostMapping("/order/users/payments/{paymentMethod}")
    public ResponseEntity<OrderDTO> orderProducts(@Valid @PathVariable String paymentMethod,
                                                  @RequestBody OrderRequestDTO orderRequestDTO ) {
        String emailId = authUtil.loggedInEmail();

        OrderDTO order = orderService.placeOrder(emailId, orderRequestDTO.getAddressId(), paymentMethod,
                                orderRequestDTO.getPgName(), orderRequestDTO.getPgPaymentId(),
                                orderRequestDTO.getPgStatus(), orderRequestDTO.getPgResponseMessage());
        return new ResponseEntity<>(order, HttpStatus.CREATED);

    }

    @GetMapping("/admin/orders")
    public ResponseEntity<OrderResponse> getAllOrders(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_ORDERS_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder
    ) {
        OrderResponse orderResponse = orderService.getAllProducts(pageNumber,pageSize, sortOrder,sortBy);
        return new ResponseEntity<OrderResponse> (orderResponse, HttpStatus.OK);
    }

    @GetMapping("/seller/orders")
    public ResponseEntity<OrderResponse> getAllSellerOrders(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_ORDERS_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder
    ) {
        OrderResponse orderResponse = orderService.getAllSellerOrder(pageNumber,pageSize, sortOrder,sortBy);
        return new ResponseEntity<OrderResponse> (orderResponse, HttpStatus.OK);
    }

    @PutMapping("/admin/orders/{orderId}/status")
    public ResponseEntity<OrderDTO> updateOrderStatus(@PathVariable Long orderId,
                                                      @RequestBody OrderStatusUpdateDto orderStatusUpdateDto
                                                      ) {
        OrderDTO order = orderService.updateOrder( orderId,orderStatusUpdateDto.getStatus());
        return  new ResponseEntity<OrderDTO>(order, HttpStatus.OK);

    }

    @PutMapping("/seller/orders/{orderId}/status")
    public ResponseEntity<OrderDTO> updateOrderStatusSeller(@PathVariable Long orderId,
                                                      @RequestBody OrderStatusUpdateDto orderStatusUpdateDto
    ) {
        OrderDTO order = orderService.updateOrder( orderId,orderStatusUpdateDto.getStatus());
        return  new ResponseEntity<OrderDTO>(order, HttpStatus.OK);

    }

}
