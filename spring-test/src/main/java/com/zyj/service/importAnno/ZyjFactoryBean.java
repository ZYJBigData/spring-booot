package com.zyj.service.importAnno;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class ZyjFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Object newProxyInstance = Proxy.newProxyInstance(ZyjFactoryBean.class.getClassLoader(),new Class[]{AService.class}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                return null;
            }
        });
        return newProxyInstance;
    }

    @Override
    public Class<?> getObjectType() {
        return AService.class;
    }
}
