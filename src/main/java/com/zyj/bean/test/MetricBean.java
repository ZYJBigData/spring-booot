package com.zyj.bean.test;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MetricBean {

    /**
     * 指标英文名
     */
    private String metricCode;

    /**
     * 指标中文名
     */
    private String metricNameCn;

    /**
     * 时间粒度 单位是秒
     */
    private Integer granularity;

    /**
     * 单位
     */
    private String unit;

    /**
     * 重要级别
     */
    private String importantLevel;
    private Integer importantLevelCode;

    /**
     * 指标id
     */
    private Integer metricId;
}