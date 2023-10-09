package com.zyj.service.aspect;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotations;

import java.lang.reflect.Method;

public class PointCutMatch {
    
    
    public static void main(String[] args) throws NoSuchMethodException {
        /**
         * 以下方法的缺点：
         *  1.只能匹配方法上，不能处理类
         */
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* bar())");

        System.out.println(pointcut.matches(T1.class.getMethod("foo"), T1.class));
        System.out.println(pointcut.matches(T2.class.getMethod("bar"), T1.class));

        AspectJExpressionPointcut pointcut1 = new AspectJExpressionPointcut();
        pointcut1.setExpression("@annotation(org.springframework.beans.factory.annotation.Autowired)");
        System.out.println(pointcut1.matches(T1.class.getMethod("foo"), T1.class));
        System.out.println(pointcut1.matches(T1.class.getMethod("bar"), T1.class));

        /**
         * 由于以上，所以spring也实现了除了AspectJExpressionPointcut这个之外实现
         * 由于没有对外提供public方法，模仿spring的匹配类的实现
         */
        StaticMethodMatcherPointcut staticMethodMatcherPointcut = new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                MergedAnnotations mergedAnnotations = MergedAnnotations.from(method);
                if (mergedAnnotations.isPresent(Autowired.class)){
                    return true;
                }
                MergedAnnotations mergedAnnotations1 = MergedAnnotations.from(targetClass);
                if (mergedAnnotations1.isPresent(Autowired.class)){
                    return true;
                }

                MergedAnnotations mergedAnnotations2 = MergedAnnotations.from(targetClass, MergedAnnotations.SearchStrategy.TYPE_HIERARCHY);
                if (mergedAnnotations2.isPresent(Autowired.class)){
                    return true;
                }
                return false;
            }
        };
        
    }
    
    public static class T1{
        @Autowired
        public void foo(){
            System.out.println("T1 foo");
        }
        
        public void bar(){
            System.out.println("T1 bar");
        }
    }

    public static class T2{
        public void foo(){
            System.out.println("T2 foo");
        }

        public void bar(){
            System.out.println("T2 bar");
        }
    }
}
