package com.target.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.target.response.ResponseObject;
import com.target.service.ValidationService;


@CrossOrigin
@Controller
@RequestMapping("/Validate")
public class MainController {

	@Autowired
	private ValidationService validationService;
	
	@GetMapping("/feedback")
	public ResponseObject ValidateFeedback(@RequestParam("comment") String inputComment)
	{
		
		ResponseObject responseObj = new ResponseObject(); 
		
		boolean isAllowed = validationService.validateContent(inputComment); 
		
		responseObj.setIsAllowed(isAllowed);
		if(isAllowed)
		responseObj.setResponse("Acceptable comment");
		else
			responseObj.setResponse("Unacceptable comment. Please review");
		
		return responseObj;
	}
}
