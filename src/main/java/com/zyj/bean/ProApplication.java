package com.zyj.bean;

import com.zyj.bean.service.importAnno.BService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBuffer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties
@EnableCaching
@EnableAsync
@EnableScheduling
@Slf4j
public class ProApplication {
    public static void main(String[] args) {

//        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//        defaultListableBeanFactory.getBean("a");
//        AnnotationConfigUtils.registerAnnotationConfigProcessors(defaultListableBeanFactory);
//        defaultListableBeanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(beanFactoryPostProcessor -> {
//            beanFactoryPostProcessor.postProcessBeanFactory(defaultListableBeanFactory);
//        });
//        
//        defaultListableBeanFactory.getBeansOfType(BeanPostProcessor.class).values().forEach(defaultListableBeanFactory::addBeanPostProcessor);

//
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ProApplication.class);
//        for (String name :annotationConfigApplicationContext.getBeanDefinitionNames()){
//            System.out.println(name);
//        }
//        
//        AnnotationConfigServletWebApplicationContext annotationConfigServletWebApplicationContext = new AnnotationConfigServletWebApplicationContext();
//        for (String name : annotationConfigServletWebApplicationContext.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }

        ConfigurableApplicationContext run = SpringApplication.run(ProApplication.class, args);
        BService bean = run.getBean(BService.class);
    }
}
