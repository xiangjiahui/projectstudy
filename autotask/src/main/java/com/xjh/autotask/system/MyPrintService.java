package com.xjh.autotask.system;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author xjh
 * @date 2022/2/5 17:04
 */
@Service
public class MyPrintService {

    public Runnable printInfo(){
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("======任务执行中:" + LocalDateTime.now().toLocalTime() + "======");
            }
        };
    }
}
