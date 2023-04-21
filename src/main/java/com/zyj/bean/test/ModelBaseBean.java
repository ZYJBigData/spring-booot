package com.zyj.bean.test;

import java.util.List;

public class ModelBaseBean {

    /**
     * 模型层级
     */
    private Integer levelId;
    /**
     * 层级中文
     */
    private String levelName;

    /**
     * 模型名称
     */
    private String modelName;

    private String operatorPhone;

    private String operatorEmail;
    private String operatorUser;

    /**
     * 备注
     */
    private String comments;

    private Integer modelId;

    /**
     * 是否给指标绑定编目
     */
    private boolean createMetricCatalog = false;
    /**
     * 业务ID ，通过 xiebo 那边获取
     */
    private Integer bizCategoryId;

    private List<Integer> categorys;
    /**
     * 业务分类中文网描述
     */
    private String bizCategoryName;

    /**
     * 自动建模还是手动建模，默认手动建模
     */
    private String modelMethod = "manual";
    /**
     * 指标类型
     * 0---generalMetric--通用指标
     * 1----individuationMetric--个性化指标
     */
    private String metricCategory;

    /**
     * 个性化指标的时候，需要传入业务系统id
     */
    private Integer businessSystemId;
}
