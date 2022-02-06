package com.xjh.autotask.mapper;


import org.apache.ibatis.annotations.Mapper;

/**
 * @author xjh
 * @date 2022/2/5 16:16
 */
@Mapper
public interface CronMapper {

    /**
     * 获得cron表达式
     * @return
     */
    String getCron();
}
