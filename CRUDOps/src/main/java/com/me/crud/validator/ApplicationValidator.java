package com.me.crud.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.crud.pojo.Applications;
import com.me.crud.pojo.CoopFaculty;

public class ApplicationValidator implements Validator {

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Applications.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Applications ap = (Applications) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "technicalSkills", "error.invalid.technicalSkills", "Technical Skills Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "workExperience", "error.invalid.workExperience", "Work Experience Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentUniversity", "error.invalid.currentUniversity", "Current University Required");


	}

}
