package com.xjh.autotask.job;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;


/**
 * @author xjh
 * @date 2022/2/5 16:53
 */
@Configuration
public class QuartzJobFactory implements Job {

    protected Logger logger = LoggerFactory.getLogger(QuartzJobFactory.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            logger.info("======任务执行:" + LocalDateTime.now().toLocalTime() + "======");
    }
}
