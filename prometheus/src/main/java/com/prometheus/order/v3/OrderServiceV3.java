package com.prometheus.order.v3;

import com.prometheus.order.OrderService;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV3 implements OrderService {

    private final MeterRegistry registry;

    public OrderServiceV3(MeterRegistry registry) {
        this.registry = registry;
    }

    private AtomicInteger stock = new AtomicInteger(100);
    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();
    }
    @Override
    public AtomicInteger getStock() {
        return stock;
    }

}
