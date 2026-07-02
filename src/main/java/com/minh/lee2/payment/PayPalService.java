package com.minh.lee2.payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PayPalService implements PaymentService {

    @Override
    public PaymentResult pay(PaymentInfo paymentInfo) {
        log.info("Pay using PayPal");
        return null;
    }
}
