package com.intrieri.kafkasagapatternpayment.model.dto;

import lombok.Data;

@Data
public class OrderRequestDTO {

    private Integer userId;
    private Integer productId;

}
