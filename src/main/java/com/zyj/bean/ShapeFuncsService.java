package com.zyj.bean;

import org.springframework.stereotype.Service;

@Service
public class ShapeFuncsService {
 
    public void execute(String shapeType, String action) throws Exception {
        ShapeFactory.getInstance().getShape(shapeType).execute(action);
    }
}