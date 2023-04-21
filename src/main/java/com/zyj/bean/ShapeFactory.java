package com.zyj.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ShapeFactory {
 
    private static class ShapeFactoryHanlde {
        private static ShapeFactory innerClassSingle = new ShapeFactory();
    }
 
    private ShapeFactory() {
    }
 
    public static ShapeFactory getInstance() {
        return ShapeFactoryHanlde.innerClassSingle;
    }
 
    private static Map<String, ShapeFunc> shapeTypeMap = new ConcurrentHashMap<>();
 
    public void register(String name, ShapeFunc shapeFunc) {
        if (!shapeTypeMap.containsKey(name)) {
            shapeTypeMap.put(name, shapeFunc);
        } else {
            log.warn("ShapeFuncFactory中存在重复注册的[name=" + name + "]类！");
        }
    }
 
    public ShapeFunc getShape(String type) throws Exception {
        if (StringUtils.isEmpty(type)) {
            throw new Exception("没有找到"+type+"类");
        }
        return shapeTypeMap.getOrDefault(type, null);
    }
 
}