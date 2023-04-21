package com.zyj.bean.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestBean implements InitializingBean, BeanPostProcessor, BeanNameAware {
    private String name;

    @Override
    /**
     * 实现的bean的初始化的时候会调用
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties set======" + name);
    }

    @Override
    /**
     * 以下的方法，所有的bean在初始化的时候都会被调用
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
}
