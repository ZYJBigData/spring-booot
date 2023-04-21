package com.zyj.bean;

import com.zyj.bean.service.DestoryTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBeanInitAdd {
    @Autowired
    private ShapeFuncsService shapeFuncsService;
    @Autowired
    private DestoryTest destoryTest;

    @Test
    public void testInit() throws Exception {
//        destoryTest.run();
        shapeFuncsService.execute("圆形", "画一个圆形");
        shapeFuncsService.execute("正方形", "画一个正方形");
        shapeFuncsService.execute("三角形", "画一个三角形");
        shapeFuncsService.execute("梯形", "画一个梯形");
    }
    
    
}