package com.loginportal.register.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.loginportal.register.model.SecurityQuestion;
import com.loginportal.register.repository.SecurityQuestionRepository;



@Service(value = "securityQuestionService")
public class SecurityQuestionServiceImpl implements SecurityQuestionService {

	@Autowired
    @Qualifier(value = "securityQuestionRepository")
	SecurityQuestionRepository securityQuestionRepository;
	
	@Autowired
	RestTemplate restTemplate;
	@Override
	public List<SecurityQuestion> findAll() {
		
		String url = "http://localhost:8017/api/data/security-question/find";
		List<SecurityQuestion> temp = new ArrayList<SecurityQuestion>();
		
		try {
			
			SecurityQuestion[] list = restTemplate.getForObject(url,
								SecurityQuestion[].class);
			List<SecurityQuestion> questionList = new ArrayList<SecurityQuestion>();
			
            for(SecurityQuestion question : list) {
            	
            	questionList.add(question);
            }
           
            return questionList;
		}
		catch (Exception e) {
			
			return temp;
		}
		
	}

}
