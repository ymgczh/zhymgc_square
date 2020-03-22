package com.zhymgc.controller;

import com.zhymgc.entity.PageResult;
import com.zhymgc.entity.Result;
import com.zhymgc.entity.StatusCode;
import com.zhymgc.pojo.Label;
import com.zhymgc.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020-3-15.
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class BaseController {

    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "success",
                labelService.findAll());
    }
    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId){
        return new Result(true, StatusCode.OK, "success",
                labelService.findById(labelId));
    }
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK, "success");
    }
    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId, @RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "success");
    }
    @RequestMapping(value = "/{labelId}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId){
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "success");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findBySearch(@RequestBody Map searchMap) {
        List<Label> labels = labelService.findSearch(searchMap);
        return new Result(true, StatusCode.OK, "success", labels);
    }

    @RequestMapping(value = "/label/search/{page}/{size}", method = RequestMethod.POST)
    public Result findByPage(@RequestBody Map searchMap,
                             @PathVariable int page,
                             @PathVariable int size) {
        Page<Label> pageData = labelService.findByPage(searchMap, page, size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<>(pageData.getTotalElements(),pageData.getContent() ));
    }


}
