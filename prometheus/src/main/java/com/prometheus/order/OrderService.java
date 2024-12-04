package com.prometheus.order;

import java.util.concurrent.atomic.AtomicInteger;

public interface OrderService {
    void order();
    void cancel();
    AtomicInteger getStock(); // 멀티쓰레드 상에서 값을 안전하게 증가시키는 인티저

}
