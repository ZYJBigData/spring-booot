package com.zyj.bean.service;

import com.zyj.bean.AbstractShapeFunc;
import org.springframework.stereotype.Component;

@Component
public class RectangleService extends AbstractShapeFunc {
 
    @Override
    public void execute(String action) {
        System.out.println("正方形： "+action);
    }
 
    @Override
    protected String supportType() {
        return "正方形";
    }
}