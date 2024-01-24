package com.info.soapclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;

import com.info.soapclient.resource.Add;
import com.info.soapclient.resource.AddResponse;


@Service
public class SoapService {


	private  WebServiceTemplate webServiceTemplate;
	
	   @Autowired
	    public SoapService(WebServiceTemplate webServiceTemplate) {
	        this.webServiceTemplate = webServiceTemplate;
	    }
	   
	    public AddResponse callSoapService(Add request) {
	        // Replace YourRequestClass and YourResponseClass with your generated JAXB classes
	        return (AddResponse) webServiceTemplate.marshalSendAndReceive(
	                "http://www.dneonline.com/calculator.asmx",
	                request,
	                webServiceMessage -> ((SoapMessage)webServiceMessage).setSoapAction("http://tempuri.org/Add")
	            );
	    }
}
