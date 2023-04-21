package com.zyj.bean.service;

import org.springframework.stereotype.Service;

@Service
public class DestoryTest extends AbstractShapeFuncDes {
    @Override
    public void destroy() throws Exception {
        System.out.println("测试1结束");
    }
    
    public void run(){
        System.out.println("执行流程");
    }
}
