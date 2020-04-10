package com.zhymgc.qa.client.impl;

import com.zhymgc.entity.Result;
import com.zhymgc.entity.StatusCode;
import com.zhymgc.qa.client.LableClient;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2020-4-10.
 */
@Component
public class LabelClientImpl implements LableClient {
    @Override
    public Result findById(String labelId) {
        return new Result(false, StatusCode.ERROR,"熔断器启动了");    }
}
