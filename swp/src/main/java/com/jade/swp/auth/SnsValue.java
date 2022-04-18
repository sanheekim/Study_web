package com.jade.swp.auth;

import org.apache.commons.lang3.StringUtils;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.api.DefaultApi20;

import lombok.Data;

@Data
public class SnsValue implements SnsUrls {
	private String service;
	private String clientId;
	private String clientSecret;
	private String redirectUrl;
	private DefaultApi20 api20Instance;
	private String profileUrl;
	
	private boolean isNaver;
	private boolean isGoogle;
	
	public SnsValue(String service, String cid, String cs, String rurl) {
		this.service = service;
		this.clientId = cid;
		this.clientSecret = cs;
		this.redirectUrl = rurl;
		
		this.isNaver = StringUtils.equalsIgnoreCase("naver", this.service);
		this.isGoogle = StringUtils.equalsIgnoreCase("google", this.service);
		
		if (isNaver) {
			this.api20Instance = NaverAPI20.instance();
			this.profileUrl = NAVER_PROFILE_URL;
			
		} else if (isGoogle) {
			this.api20Instance = GoogleApi20.instance();
			this.profileUrl = GOOGLE_PROFILE_URL;
		}
	}
}
