package com.gfndry.Oautt.controller;

@RestController
public class SalesforceAPIController {

	@RequestMapping("/home")
	public String getSalesforceObject(){
	return "index";
	}
}
