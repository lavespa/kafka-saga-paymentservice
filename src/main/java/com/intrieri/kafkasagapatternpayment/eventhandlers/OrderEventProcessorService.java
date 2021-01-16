package com.intrieri.kafkasagapatternpayment.eventhandlers;

import org.springframework.stereotype.Service;

import com.intrieri.kafkasagapatternpayment.model.enums.PaymentStatus;
import com.intrieri.kafkasagapatternpayment.model.evt.OrderEvent;
import com.intrieri.kafkasagapatternpayment.model.evt.PaymentEvent;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class OrderEventProcessorService {

    // user - credit limit
    public static final Map<Integer, Integer> userMap = new HashMap<>();

    static {
        userMap.put(1, 1000);
        userMap.put(2, 1000);
        userMap.put(3, 1000);
        userMap.put(4, 1000);
        userMap.put(5, 1000);
    }

    public PaymentEvent processOrderEvent(OrderEvent orderEvent){
    	
    	log.info("Consume orderevent id={} ",orderEvent.getOrderId());
    	
        var price = orderEvent.getPrice();
        var creditLimit = userMap.get(orderEvent.getUserId());
        PaymentEvent paymentEvent = new PaymentEvent(orderEvent.getOrderId());
        if(creditLimit >= price){
            paymentEvent.setStatus(PaymentStatus.APPROVED);
            userMap.computeIfPresent(orderEvent.getUserId(), (k, v) -> v - price);
        }else{
            paymentEvent.setStatus(PaymentStatus.REJECTED);
        }
        return paymentEvent;
    }

}
