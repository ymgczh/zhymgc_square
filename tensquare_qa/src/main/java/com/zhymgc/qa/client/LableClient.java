package com.zhymgc.qa.client;

import com.zhymgc.entity.Result;
import com.zhymgc.qa.client.impl.LabelClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类 {@code } INFO
 *
 * @author 张昊 zhanghao_nmgjc@bosssoft.com.cn
 * @version v2.0
 * @since 2020-4-4 21:38
 * <p>
 * copyright: 内蒙古金财信息技术有限公司 (c)
 * </p>
 */
@FeignClient(value = "tensquare-base", fallback = LabelClientImpl.class)
public interface LableClient {
    @RequestMapping(value = "/label/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId);
}
