package com.gfndry.Oautt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gfndry.Oautt.model.AuthenticationResponse;


@RestController
@RequestMapping(path = "/oauthdemo")
public class SalesforceAPIController {

	@Value("${security.oauth2.username}")
	private String username;
	
	@Value("${security.oauth2.password}")
	private String password;
	
	@Value("${security.oauth2.client.client-id}")
	private String clientId;
	
	@Value("${security.oauth2.client.client-secret}")
	private String clientSecret;
	
	@Value("${security.oauth2.client.access-token-uri}")
	private String salesForceAuthURL;
	
	@Value("${security.oauth2.resource.appUri}")
	private String salesForceAppURL;
	
	@Value("${security.oauth2.client.grant-type}")
	private String grantType;
	
	
	@GetMapping(path="/home", produces = "application/json")
	public String getSalesforceObject(){
		System.out.println("inside---------------");
	return "index";
	}
	
	@PostMapping(path="/auth", produces = "application/json")
	public AuthenticationResponse login(){
		System.out.println(""+username);
		System.out.println(""+salesForceAuthURL);
		System.out.println("clientId:"+clientId);
		System.out.println("clientSecret :"+clientSecret);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
		 
		params.add("username", username);
		params.add("password", password);
		params.add("client_secret", clientSecret);
		params.add("client_id", clientId);
		params.add("grant_type","password");
		 
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		 
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AuthenticationResponse> response = restTemplate.postForEntity(salesForceAuthURL, request, AuthenticationResponse.class);
		System.out.println(""+response.getBody());
		return response.getBody();
		}
}
