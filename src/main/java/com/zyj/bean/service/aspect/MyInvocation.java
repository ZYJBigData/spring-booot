package com.zyj.bean.service.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * 环绕通知 底层调用原理
 */
public class MyInvocation implements MethodInvocation {
    private Object target;
    private Method method;
    private Object[] args;
    List<MethodInterceptor> methodInterceptorList ;
    private int count =1;

    public MyInvocation(Object target, Method method, Object[] args, List<MethodInterceptor> methodInterceptorList) {
        this.target = target;
        this.method = method;
        this.args = args;
        this.methodInterceptorList = methodInterceptorList;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return args;
    }

    @Override
    public Object proceed() throws Throwable {
        if (count>methodInterceptorList.size()){
            method.invoke(target,args);
        }
        MethodInterceptor interceptor = methodInterceptorList.get(count++ - 1);
        return interceptor.invoke(this);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }


    public static class Target {
        public void foo() {
            System.out.println("foo");
        }
    }

    public static class Advice1 implements MethodInterceptor {

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            System.out.println("advice1 before..");
            Object proceed = invocation.proceed();
            System.out.println("advice1 after..");
            return proceed;
        }
    }

    public static class Advice2 implements MethodInterceptor {

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            System.out.println("Advice2 before..");
            Object proceed = invocation.proceed();
            System.out.println("Advice2 after..");
            return proceed;
        }
    }

    public static void main(String[] args) throws Throwable {
        Target target = new Target();
        List<MethodInterceptor> list = Arrays.asList(new Advice1(), new Advice2());
        MyInvocation foo = new MyInvocation(target, Target.class.getMethod("foo"), new Object[0], list);
        foo.proceed();
    }
}
