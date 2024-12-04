package com.prometheus.order.v4;

import com.prometheus.order.OrderService;
import com.prometheus.order.v3.OrderServiceV3;
import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV4 {

    @Bean
    OrderService orderService() {
        return new OrderServiceV4();
    }

    @Bean
    public CountedAspect countedAspect(MeterRegistry registry) {
        return new CountedAspect(registry);
    }

}
