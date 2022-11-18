package com.example.cbbq.validator;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

import com.example.cbbq.model.Organizer;
import com.example.cbbq.service.OrgService;

@Component
public class OrgValidator implements Validator {
    @Autowired
    private OrgService orgService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Organizer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Organizer organizer = (Organizer) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
          
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (!pattern.matcher(organizer.getUsername()).matches()) {
            errors.rejectValue("username", "InvalidEmail.orgForm.username");
        }
        if (orgService.findByUsername(organizer.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.orgForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (organizer.getPassword().length() < 8 || organizer.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.orgForm.password");
        }
        if (!organizer.getPasswordConfirm().equals(organizer.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.orgForm.passwordConfirm");
        }
        
    }
    
}
