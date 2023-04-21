package com.zyj.bean.service;

import com.zyj.bean.AbstractShapeFunc;
import org.springframework.stereotype.Component;

@Component
public class CircleService extends AbstractShapeFunc {
 
    @Override
    public void execute(String action) {
        System.out.println("圆形： "+action);
    }
 
    @Override
    protected String supportType() {
        return "圆形";
    }
}