package com.xjh.task.asynctask.controller;

import com.xjh.task.asynctask.service.AsynacTaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xjh
 * @date 2022/2/7 14:19
 */
@RestController
public class AsyncController {

    @Resource
    private AsynacTaskService asynacTaskService;

    @GetMapping("/async")
    public String hello(){
        asynacTaskService.hello();
        return "处理数据中,需要等待三秒,请稍后";
    }
}
