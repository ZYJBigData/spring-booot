package com.zyj.bean.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;

@Slf4j
public abstract class AbstractShapeFuncDes implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        log.error("bean销毁的动作");
    }
}
