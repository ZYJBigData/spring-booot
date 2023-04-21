package com.zyj.bean.test;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MetricBaseBean {

    /**
     * 采集来源
     */
    private String source;
    /**
     * 指标类型 1--原子指标 -- origin  ， 2 -- 衍生指标 -- derived
     */
    private String metricType;

    private Integer metricTypeCode;

    private boolean isDerivedMetric = false;

    /**
     * 统计口径
     */
    private String statisticalCaliber;

    /**
     * 指标列表
     */
    private List<MetricBean> metrics;

}