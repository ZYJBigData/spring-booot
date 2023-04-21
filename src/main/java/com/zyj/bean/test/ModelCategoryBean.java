package com.zyj.bean.test;

public class ModelCategoryBean {

    /**
     * 数据源ID，可能暂时用不到
     */
    private Integer sourceId = -1;

    /**
     * 数据源类型
     */
    private String sourceType;
    private Integer sourceTypeCode;

    /**
     * influxDB 库名称
     */
    private String databaseName;

    /**
     * influxDB 表名
     */
    private String measurementName;
    /**
     * 保留时长
     */
    private String reserve;
    private Integer reserveCode;
}