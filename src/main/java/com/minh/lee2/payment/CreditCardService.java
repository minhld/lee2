package com.minh.lee2.payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
@Slf4j
public class CreditCardService implements PaymentService {

    @Override
    public PaymentResult pay(PaymentInfo paymentInfo) {
        log.info("Pay using CreditCard");
        return null;
    }
}
