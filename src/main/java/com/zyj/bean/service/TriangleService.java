package com.zyj.bean.service;

import com.zyj.bean.AbstractShapeFunc;
import org.springframework.stereotype.Component;

@Component
public class TriangleService extends AbstractShapeFunc {
 
    @Override
    public void execute(String action) {
        System.out.println("三角形： "+action);
    }
 
    @Override
    protected String supportType() {
        return "三角形";
    }
}