package com.zyj.bean.service.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * 此注解表明 此类为切面类
 */
@Aspect
/**
 * 两类切面：
 * Aspect：
 *  Aspect=
 *      通知1(advice) + 切点1（pointcut）
 *      通知2(advice) + 切点2（pointcut）
 *      通知3(advice) + 切点3（pointcut）
 * advisor= 更为细粒度的切面，包含一个通知和切点
 */
public class MyAspect {
    /**
     * before 表名了通知的类型为前置通知
     * before中的值：切点，表明目标的哪些方法需要执行这些通知
     * execution中匹配机制：
     * 1.(* com.bizseer.dataplat.backend..*.web..*(..)   *-->匹配方法的任何返回值   com.bizseer.dataplat.backend..*.web.. ->匹配指定包下的代码  *(..)-> 匹配任何有参数方法
     * 2.(* foo())  *-->匹配方法的任何返回值  ->匹配任何包下的代码  -> foo() 匹配方法名为foo并且没有参数的方法
     * execution 表明是用aspectj 正则表达式进行匹配的
     * annotation 表明是用注解进行匹配的
     */
    @Before("execution(* foo())" +
            " @annotation(com.zyj.bean.service.aspect.MyAspect)")
    /**
     * 通知方法
     */
    public void before() {
        System.out.println("前置通知");
    }

    /**
     * 通知方法
     */
    @After("execution(* foo())")
    public void after() {
        System.out.println("后置通知");
    }

    interface I1 {
        void foo();

        void bar();
    }

    static class Target1 implements I1 {

        @Override
        public void foo() {
            System.out.println("Target1 foo");
        }

        @Override
        public void bar() {
            System.out.println("Target1 bar");
        }
    }

    static class Target2{
        public void foo() {
            System.out.println("Target2 foo");
        }

        public void bar() {
            System.out.println("Target2 bar");
        }
    }

    /**
     * 函数的例子模仿的是按照  execution 表明是用aspectj 正则表达式进行匹配的 这种方式进行的
     *
     * @param args
     */
    public static void main(String[] args) {
        //1 备好切点：
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* foo())");

        //2 备好通知：
        MethodInterceptor advice = invocation -> {
            System.out.println("before.....");
            Object proceed = invocation.proceed();
            System.out.println("before.....");
            return proceed;
        };

        //3 准备切面：
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(pointcut, advice);

        //4.创建代理
        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(defaultPointcutAdvisor);
        factory.setTarget(new Target1());
        I1 proxy = (I1) factory.getProxy();
        proxy.foo();
        proxy.bar();
    }
}
