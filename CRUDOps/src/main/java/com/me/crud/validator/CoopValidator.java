package com.me.crud.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.crud.pojo.CoopFaculty;




public class CoopValidator implements Validator {
	
	public boolean supports(Class aClass) {
		return aClass.equals(CoopFaculty.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		CoopFaculty user = (CoopFaculty) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fName", "error.invalid.fName", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lName", "error.invalid.lName", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.userName", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
		
	}

}
