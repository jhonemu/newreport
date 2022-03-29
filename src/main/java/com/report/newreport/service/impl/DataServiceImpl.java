package com.report.newreport.service.impl;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.report.newreport.service.DataService;


@Service
public class DataServiceImpl implements DataService{
	
	@Autowired
	public RestTemplate restemplate;

	@Override
	public JSONArray generateJSONData() {
		return new JSONArray(restemplate.getForObject("https://api2.binance.com/api/v3/ticker/24hr", String.class));
	}
	
	
	

}
