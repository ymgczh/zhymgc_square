package com.zhymgc.test;

import com.zhymgc.rabbit.RabbitApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2020-3-29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class ProductTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send() {
        rabbitTemplate.convertAndSend("itecast", "直接模式测试");
    }

    /**
     * 分裂模式编程
     */
    @Test
    public void send1() {
        rabbitTemplate.convertAndSend("go_forward","","分裂模式发送");
    }

}
