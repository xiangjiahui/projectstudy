package com.xjh.autotask.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xjh
 * @date 2022/2/5 16:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cron {

    private String cronId;

    private String cron;
}
