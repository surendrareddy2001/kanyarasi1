package com.info.soapclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

// hello
@Configuration
public class WebServiceConfig {
	
	@Bean
	public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
		WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
		
		return template;
		
	}

}
