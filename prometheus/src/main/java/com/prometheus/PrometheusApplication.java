package com.prometheus;

import com.prometheus.order.gauge.StockConfigV1;
import com.prometheus.order.gauge.StockConfigV2;
import com.prometheus.order.v0.OrderConfigV0;
import com.prometheus.order.v1.OrderConfigV1;
import com.prometheus.order.v2.OrderConfigV2;
import com.prometheus.order.v3.OrderConfigV3;
import com.prometheus.order.v4.OrderConfigV4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(OrderConfigV0.class)
//@Import(OrderConfigV1.class)
//@Import(OrderConfigV2.class)
//@Import(OrderConfigV3.class)
@Import({OrderConfigV4.class, StockConfigV2.class})
@SpringBootApplication(scanBasePackages = "com.prometheus.controller")
public class PrometheusApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrometheusApplication.class, args);
	}

	// HTTP 요청과 응답 과거 기록을 확인
	@Bean
	public InMemoryHttpExchangeRepository httpExchangeRepository() {
		return new InMemoryHttpExchangeRepository();
	}

}
