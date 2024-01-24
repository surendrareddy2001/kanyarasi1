package com.info.soapclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class jaxb2Config {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller  jaxb2Marshaller = new Jaxb2Marshaller();
//		jaxb2Marshaller.setPackagesToScan("com.info.soapclient.resource");
		
		jaxb2Marshaller.setContextPath("com.info.soapclient.resource");
		
		return jaxb2Marshaller;
	}

}
