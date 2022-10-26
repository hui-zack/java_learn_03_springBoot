package com.hui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * 本service对RestTemplate进行了简单封装, 用于简化http请求的发送
 * 仅支持发送json格式请求, 如需发送其他类型的http请求请使用原生RestTemplate
 */
@Service
public class RestTemplateService {
    @Autowired
    private RestTemplate restTemplate;

    private final HttpEntity<String> requestEntity;

    public RestTemplateService(){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json");
        requestEntity = new HttpEntity<>(requestHeaders);
    }

    /**
     * 发送get请求
     * @param url 请求地址
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> get(String url){
        return restTemplate.getForEntity(url, String.class);
    }

    /**
     * 发送post请求
     * @param url 请求地址
     * @param hashMapBody 请求体以hashMap类型组装
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> post(String url, HashMap<String, Object> hashMapBody){
        return restTemplate.postForEntity(url, hashMapBody, String.class);
    }

    /**
     * 发送post请求
     * @param url 请求地址
     * @param beanBody  请求体以java bean类型组装
     * @return ResponseEntity<String>
     */
    public <T> ResponseEntity<String> post(String url, T beanBody){
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class, beanBody);
    }

    /**
     * 发送put请求
     * @param url 请求地址
     * @param hashMapBody 请求体以hashMap类型组装
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> put(String url, HashMap<String, Object> hashMapBody){
        return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class, hashMapBody);
    }

    /**
     * 发送put请求
     * @param url 请求地址
     * @param beanBody 请求体以java bean类型组装
     * @return ResponseEntity<String>
     */
    public <T> ResponseEntity<String> put(String url, T beanBody){
        return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class, beanBody);
    }

    public ResponseEntity<String> delete(String url, HashMap<String, Object> hashMapBody){
        return restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class, hashMapBody);
    }

    public <T> ResponseEntity<String> delete(String url, T beanBody){
        return restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class, beanBody);
    }

}
