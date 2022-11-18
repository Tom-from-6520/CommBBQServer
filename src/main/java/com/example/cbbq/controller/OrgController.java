package com.example.cbbq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.cbbq.service.*;
import com.example.cbbq.validator.*;
import com.example.cbbq.model.*;

@Controller
public class OrgController {
    @Autowired
    private OrgService orgService;

    @Autowired
    private OrgSecurityService orgSecurityService;

    @Autowired
    private OrgValidator orgValidator;

    @GetMapping("/org/registration")
    public String registration (Model model) {
        model.addAttribute("orgForm", new Organizer());
        return "registration";
    }

    @PostMapping("/org/registration")
    public String registration(@ModelAttribute("orgForm") Organizer orgForm, BindingResult bindingResult) {
        orgValidator.validate(orgForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        orgService.save(orgForm);
        orgSecurityService.autoLogin(orgForm.getUsername(), orgForm.getPasswordConfirm());
        return "redirect:/success";
    }

	@GetMapping("/org/login")
	public String login(Model model, String error, String logout, String success) {
		if (error != null) {
			model.addAttribute("error", "Your username and password is invalid");
		}
		if (logout != null) {
			model.addAttribute("message", "You have been logged out");
		}
		return "login";
	}

	@GetMapping({"/", "/welcome"})
	public String welcome(Model model) {
		return "welcome";
	}

    @GetMapping({"/success"})
	public String successRedirection(Model model) {
        System.out.println("hahaha");
		return "welcome";
	}
}