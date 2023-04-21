package com.zyj.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public abstract class AbstractShapeFunc implements ShapeFunc, InitializingBean {
    protected abstract String supportType();

    @Override
    public void afterPropertiesSet() {
        ShapeFactory.getInstance().register(supportType(), this);
    }
}