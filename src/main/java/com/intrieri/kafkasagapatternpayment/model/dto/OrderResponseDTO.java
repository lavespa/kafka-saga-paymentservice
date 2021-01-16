package com.intrieri.kafkasagapatternpayment.model.dto;

import com.intrieri.kafkasagapatternpayment.model.enums.OrderStatus;

import lombok.Data;

@Data
public class OrderResponseDTO {

    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer price;
    private OrderStatus status;

}
