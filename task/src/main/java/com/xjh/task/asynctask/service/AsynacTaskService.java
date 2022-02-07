package com.xjh.task.asynctask.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author xjh
 * @date 2022/2/7 14:16
 */
@Service
public class AsynacTaskService {

    /**
     * @Async 异步注解,遇到大数据处理时,不会让客户等待,直接返回结果
     */
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中");
    }
}
