package com.gfndry.Oautt.model;

public class AuthenticationResponse {

	private String access_token;
	private String instance_url;
	private String token_type;
	private String issued_at;
	private String id;
	private String signature;
	 
	public String getAccess_token() {
	return access_token;
	}
	public void setAccess_token(String access_token) {
	this.access_token = access_token;
	}
	public String getInstance_url() {
	return instance_url;
	}
	public void setInstance_url(String instance_url) {
	this.instance_url = instance_url;
	}
	public String getToken_type() {
	return token_type;
	}
	public void setToken_type(String token_type) {
	this.token_type = token_type;
	}
	public String getIssued_at() {
	return issued_at;
	}
	public void setIssued_at(String issued_at) {
	this.issued_at = issued_at;
	}
	 
	@Override
	public String toString() {
	return "AuthenticationResponse [access_token=" + access_token + ", instance_url=" + instance_url
	+ ", token_type=" + token_type + ", issued_at=" + issued_at + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
