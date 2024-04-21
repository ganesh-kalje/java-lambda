package com.example.edo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class AccountController {
	
	private String getLocalDateTime() {
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		  LocalDateTime now = LocalDateTime.now();
		  return dtf.format(now);
	}
	
	@RequestMapping(path = "/getPolicies", method = RequestMethod.GET)
	public Map<String, String> getPolicies() {
		 HashMap<String, String> map = new HashMap<>();
		    map.put("Test_app", "Policie One");
		    map.put("name_2", "Policie two");
		    map.put("name_3", "Policie three");
		    return map;
	}
	
	
	
	@RequestMapping(path = "/submitrequest", method = RequestMethod.POST)
    public String postBody(@RequestBody String request) {
        return "We received your request at "+getLocalDateTime()+": " + request;
    }
}
