package com.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.User;
import com.data.UserRepository;
import com.validators.LoginValidator;

@Controller
@RequestMapping("/")
public class Login{
	
	@Autowired
	private UserRepository repo;
	
	@ResponseBody
	@RequestMapping(value="/confirmation")
	public Map<String, Object> confirm() {
		 Map<String, Object> jo = new HashMap();     
		 jo.put("ResponseCode",0);
        jo.put("ResponseDesc","The service request has been accepted successfully");
        
        return jo;
	} 
	
	@ResponseBody
	@RequestMapping(value="/validation")
	public Map<String, Object> validate() {
		Map<String, Object> jo = new HashMap();
        jo.put("ResponseCode",0);
        jo.put("ResponseDesc","The service request has been accepted successfully");
        
        return jo;
	} 
	
	@RequestMapping("/")
	public String doLogin(Model model) {
		model.addAttribute("user",new User());
		return "login";
	}
	
	
	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute User user, Errors errors) {
		System.out.println(user);
		if(!errors.hasErrors()) {
			repo.save(user);
		}else {
			return "login";
		}
		return "login";
	}
	
	 @InitBinder
		public void initBinder(WebDataBinder binder) {
			binder.addValidators(new LoginValidator());
		}
}