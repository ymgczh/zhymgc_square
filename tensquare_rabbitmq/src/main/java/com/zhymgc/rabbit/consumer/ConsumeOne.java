package com.zhymgc.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2020-3-29.
 */
@Component
@RabbitListener(queues = "itecast")
public class ConsumeOne {

    @RabbitHandler
    public void getMsg(String msg) {
        System.out.println("直接模式消费：：" + msg);
    }
}
