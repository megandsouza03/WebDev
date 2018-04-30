package com.me.crud.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.crud.pojo.Job;


public class JobValidator implements Validator {


	public boolean supports(Class aClass) {
		return aClass.equals(Job.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Job user = (Job) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "error.invalid.companyName", "Company Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.title", "Title Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "openings", "error.invalid.openings", "Openings Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "length", "error.invalid.length", "Length Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.city", "City Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "error.invalid.companyName", "Country Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.description", "Description Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "wageType", "error.invalid.wageType", "wageType Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "minWage", "error.invalid.minWage", "minWage Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxWage", "error.invalid.maxWage", "maxWage Required");
	}	
	
	
}
