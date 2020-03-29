package com.zhymgc;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Administrator on 2020-3-29.
 */
@Component
@RabbitListener(queues = "sms")
public class SMSListener {
    @RabbitHandler
    public void sendSms(Map<String, String> message) {
        System.out.println("手机号：" + message.get("mobile"));
        System.out.println("验证码：" + message.get("code"));
    }

}
