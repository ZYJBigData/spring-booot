package com.zyj.configration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "master.properties")
public class MasterConfig {
    @Value("${master.rate.control.taskType:JAVA}")
    public String rateControlTaskType;
}
