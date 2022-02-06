package com.xjh.autotask.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;


/**
 * @author xjh
 * @date 2022/2/5 16:58
 */
@Component
public class QuartzService {

    private static final Logger logger = LoggerFactory.getLogger(QuartzService.class);
    private static final String CRON_TIME = "*/5 * * * * ?";
    private static final String TRIGGER_KEY_NAME = "00000000001";


    @PostConstruct
    public void taskInit() {
        logger.info("=========系统初始化加载定时任务开始========");
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(TRIGGER_KEY_NAME, Scheduler.DEFAULT_GROUP);
            JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class).withDescription("quartz测试定制化定时任务").withIdentity(TRIGGER_KEY_NAME, Scheduler.DEFAULT_GROUP).build();
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(CRON_TIME);
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();
            logger.info("=========初始化定时任务加载完成=========");
        } catch (Exception e) {
            logger.info("==============初始化加载定时任务失败==============" + e);
            e.printStackTrace();
        }
    }

}
