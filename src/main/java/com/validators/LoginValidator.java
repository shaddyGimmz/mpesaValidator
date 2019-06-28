package com.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.data.User;

public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User)obj;
		if(user.getPassword() != user.getUsername()) {
			errors.rejectValue("password","user.password","you are not an admin");
		}
	}

}
