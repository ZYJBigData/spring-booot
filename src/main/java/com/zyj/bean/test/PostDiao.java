package com.zyj.bean.test;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class PostDiao {
    private void doUpload() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(10000);
        requestFactory.setReadTimeout(10000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url ="http://10.0.100.247:38085/api/dataplat-backendservice/v1/model";
        HttpEntity<MetricModelCreateBean> entity;
        MetricModelCreateBean metricModelCreateBean = new MetricModelCreateBean();
        //TODO dimension
        MetricDimensionBean metricDimensionBean = new MetricDimensionBean();
        metricDimensionBean.
        if (metricModelCreateBean != null) {
            entity = new HttpEntity<>(metricModelCreateBean, headers);
        } else {
            entity = new HttpEntity<>(headers);
        }
        log.debug("发送的url = 「{}」", url);
        ResponseEntity<JsonNode> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, JsonNode.class);
    }

}
