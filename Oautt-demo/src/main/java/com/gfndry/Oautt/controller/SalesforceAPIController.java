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
import com.gfndry.Oautt.util.ScriptExecutor;


@RestController
@RequestMapping(path = "/api")
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
	
	@Autowired
	ScriptExecutor scriptExecutor;
	
	
	@GetMapping(path="/home", produces = "application/json")
	public String getSalesforceObject(){
		System.out.println("inside---------------");
	return "index";
	}
	
	@GetMapping(path="/auth")
	public AuthenticationResponse login(){
		//System.setProperty("http.proxyHost", "proxy.cognizant.com");
		//System.setProperty("http.proxyPort", "6050");

		System.out.println(""+username);
		System.out.println(""+salesForceAuthURL);
		System.out.println("clientId:"+clientId);
		System.out.println("clientSecret :"+clientSecret);
		//HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
		 
/*		params.add("username", username);
		params.add("password", password+"4DLIzo9rs953mXrKaCcX4h9Sq");
		params.add("client_id", clientId);
		params.add("client_secret", clientSecret);
*/		
		//params.add("grant_type","password");
		 
		//HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		params.add("username", "amogh@gdoundries.com");
		params.add("password", "Aholi0218$$4DLIzo9rs953mXrKaCcX4h9Sq");
		params.add("client_id", "3MVG9G9pzCUSkzZsFH9DvHGvJEpqtuO1ACnRTqQRYk7Y0uSNZAfquYSyz07Q5Y8uY_PVAxfPNrpELOas_o5SA");
		params.add("client_secret", "E856CFA7875286E84E74264F6D1109F1886C96EAB15EA88EF12C27D854E40605");
		 
		RestTemplate restTemplate = new RestTemplate();
		AuthenticationResponse response = restTemplate.postForObject(salesForceAuthURL, params, AuthenticationResponse.class);
		System.out.println(""+response.toString());
		return response;
		}
		
		@PostMapping(path="/auth1")
		public AuthenticationResponse newlogin(){
			
			//System.setProperty("http.proxyHost", "proxy.cognizant.com");
			//System.setProperty("http.proxyPort", "6050");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
		 
/*		params.add("username", username);
		params.add("password", password+"4DLIzo9rs953mXrKaCcX4h9Sq");
		params.add("client_id", clientId);
		params.add("client_secret", clientSecret);
		params.add("grant_type","password");
*/
		params.add("username", "amogh@gdoundries.com");
		params.add("password", "Aholi0218$$4DLIzo9rs953mXrKaCcX4h9Sq");
		params.add("client_id", "3MVG9G9pzCUSkzZsFH9DvHGvJEpqtuO1ACnRTqQRYk7Y0uSNZAfquYSyz07Q5Y8uY_PVAxfPNrpELOas_o5SA");
		params.add("client_secret", "E856CFA7875286E84E74264F6D1109F1886C96EAB15EA88EF12C27D854E40605");
		params.add("grant_type","password");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		 
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AuthenticationResponse> response = restTemplate.postForEntity("https://login.salesforce.com/services/oauth2/token", request, AuthenticationResponse.class);
		return response.getBody();
		}
		
		
		@GetMapping(path="/script")
		public String executeScript(){
			System.out.println("executeing script---------------");
			scriptExecutor.runScript();
			System.out.println("done---------------");
		return "index";
		}

}
