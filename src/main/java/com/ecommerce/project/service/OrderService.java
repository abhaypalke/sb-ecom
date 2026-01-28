package com.ecommerce.project.service;

import com.ecommerce.project.payload.OrderDTO;
import com.ecommerce.project.payload.OrderResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

public interface OrderService {

    @Transactional
    OrderDTO placeOrder(String emailId, Long addressId, @Valid String paymentMethod, String pgName,
                        String pgPaymentId, String pgStatus, String pgResponseMessage);

    OrderResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortOrder, String sortBy);

    OrderDTO updateOrder( Long orderId, String status);

    OrderResponse getAllSellerOrder(Integer pageNumber, Integer pageSize, String sortOrder, String sortBy);
}
