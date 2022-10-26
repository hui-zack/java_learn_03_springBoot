package com.hui.controllor;

import com.hui.domain.Camera;
import com.hui.service.RestTemplateService;
import com.hui.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping("/get")
    public String testGet(){
        ResponseEntity<String> responseEntity = restTemplateService.get("https://www.baidu.com");

        return responseEntity.getBody();
    }

    @GetMapping("post")
    public String testPost(){
        HashMap<String, Object> requestMap = JsonUtil.getMap();
        //     "cameraMac": "24:28:fd:de:cb:a4"
        requestMap.put("cameraMac", "24:28:fd:de:cb:a4");

        Camera camera = new Camera();
        camera.setCameraMac("24:28:fd:de:cb:a4");
        ResponseEntity<String> responseEntity = restTemplateService.post("http://localhost:8085/api/alarm/ip", camera);
        return responseEntity.getBody();
    }
}
