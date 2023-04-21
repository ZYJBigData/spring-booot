package com.zyj.bean.test;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class MetricModelCreateBean {
    private ModelBaseBean modelBase;
    private ModelCategoryBean modelCategory;
    private MetricBaseBean metricBase;
    private List<MetricDimensionBean> metricDimensions;
}