package com.intrieri.kafkasagapatternpayment.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.intrieri.kafkasagapatternpayment.model.evt.OrderEvent;
import com.intrieri.kafkasagapatternpayment.model.evt.PaymentEvent;
import com.intrieri.kafkasagapatternpayment.eventhandlers.OrderEventProcessorService;

import java.util.function.Function;

@Configuration
public class PaymentServiceConfig {

    @Autowired
    private OrderEventProcessorService orderEventProcessorService;

    @Bean
    public Function<OrderEvent, PaymentEvent> orderEventProcessor(){
        return orderEventProcessorService::processOrderEvent;
    }

}
