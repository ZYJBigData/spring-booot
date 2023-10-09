package com.zyj.service.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;

public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {
    /**
     * 
     * 1,2 两个方法来自于BeanPostProcessor 【初始化】
     */
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化之前执行，这里返回的对象会替换原来的bean，如@PostConstruct @ConfigurationProperties");
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化之后执行，这里返回的对象会替换原来的bean，如代理增强");
        return bean;
    }

    /**
     * 
     * 3,4，5 接口来自于InstantiationAwareBeanPostProcessor 【实例化】
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("实例化之前执行，这里的返回对象会替换为原本的bean");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("实例化之后执行，这里返回false会跳过依赖注入");
        return true;
    }
    
    @Nullable
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        System.out.println("依赖注入阶段执行，如@Autowired @Value @Resource");
        return null;
    }

    /**
     * spring容器关闭的时候，进行销毁
     * DestructionAwareBeanPostProcessor 【销毁】
     */
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
//        new MapperFactoryBean
        System.out.println("销毁之前执行");
    }
    
    
}
