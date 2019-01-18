package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {

//	private final static String PRE_URL = "http://localhost:8001";
	
	private final static String PRE_URL = "http://MICROSERVICECLOUD-DEPT";
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(PRE_URL+"/dept/add", dept,Boolean.class);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(PRE_URL+"/dept/get/"+id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
        return restTemplate.getForObject(PRE_URL+"/dept/list", List.class);
    }
}
