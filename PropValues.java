package com.gfndry.Oautt.model;

@PropertySource("classpath:/application.properties}")
public class PropValues {

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
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getSalesForceAuthURL() {
		return salesForceAuthURL;
	}
	public void setSalesForceAuthURL(String salesForceAuthURL) {
		this.salesForceAuthURL = salesForceAuthURL;
	}
	public String getSalesForceAppURL() {
		return salesForceAppURL;
	}
	public void setSalesForceAppURL(String salesForceAppURL) {
		this.salesForceAppURL = salesForceAppURL;
	}
	public String getGrantType() {
		return grantType;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	@Override
	public String toString() {
		return "PropValues [username=" + username + ", password=" + password + ", clientId=" + clientId
				+ ", clientSecret=" + clientSecret + ", salesForceAuthURL=" + salesForceAuthURL + ", salesForceAppURL="
				+ salesForceAppURL + ", grantType=" + grantType + "]";
	}
	
	
	
	
}
