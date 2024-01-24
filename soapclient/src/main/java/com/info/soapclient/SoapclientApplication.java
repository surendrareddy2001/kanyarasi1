package com.info.soapclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info.soapclient.resource.Add;
import com.info.soapclient.resource.AddResponse;
import com.info.soapclient.service.SoapService;

@SpringBootApplication
@RestController
public class SoapclientApplication {
	
	@Autowired
	private SoapService soapService;
    @GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b) {
        // Create the request object
        Add request = new Add();
        request.setIntA(a);
        request.setIntB(b);

        try {
            // Call the SOAP service
            AddResponse response = soapService.callSoapService(request);

            // Return the result
            return "Result of adding " + a + " and " + b + " is: " + response.getAddResult();
        } catch (Exception e) {
            // Handle any exceptions, e.g., log or return an error message
            return "Error while calling the SOAP service: " + e.getMessage();
        }
    }
	public static void main(String[] args) {
		SpringApplication.run(SoapclientApplication.class, args);
	}

}
