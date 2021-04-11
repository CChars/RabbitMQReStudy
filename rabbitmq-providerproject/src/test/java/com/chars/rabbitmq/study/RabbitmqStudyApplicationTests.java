package com.chars.rabbitmq.study;
import com.chars.rabbitmq.study.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqStudyApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder("11","22",12);
    }

    @Test
    void contextLoads2() {
        orderService.makeOrderByDirect("11","22",12);
    }

    @Test
    void contextLoads3() {
        orderService.makeOrderByTopic("11","22",12);
    }

    @Test
    public void tttltest(){
        for (int i = 0; i < 5; i++) {
            orderService.makeOrderByTTL_Direct("22","33",56);
        }
    }
}
