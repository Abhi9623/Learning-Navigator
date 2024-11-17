package com.LearningNavigator.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class EasternEgg {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${external.api.url}")
    private String url;


    public String EasterEgg(String num){
        url=url+"/"+num;
        return restTemplate.getForObject(url,String.class);
    }

}
