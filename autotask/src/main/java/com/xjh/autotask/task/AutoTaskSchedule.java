package com.xjh.autotask.task;

import com.xjh.autotask.mapper.CronMapper;
import com.xjh.autotask.system.MyPrintService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;


/**
 * @author xjh
 * @date 2022/2/5 16:11
 */
@Configuration
@EnableScheduling
public class AutoTaskSchedule implements SchedulingConfigurer {

    @Resource
    private CronMapper cronMapper;

    @Resource
    private MyPrintService myPrintService;


    /**
     * 执行定时任务
     * @param taskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
//                () -> System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
                myPrintService.printInfo(),
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronMapper.getCron();
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );

    }
}
