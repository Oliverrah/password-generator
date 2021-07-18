package com.passwordgenerator.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.passwordgenerator.entities.Password;
import com.passwordgenerator.utils.PasswordUtils;

@Controller
public class PasswordController {

	@RequestMapping("/")
	public String showForm(Model model) {
			
		Password password = new Password();
				
		model.addAttribute("password", password);	
		
		return "index";
	}
	
	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("password") Password password, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "index";
		}
		
		password.setResult(PasswordUtils.generateRandomPassword(password.getPasswordLenght(), password.getLowercaseLetters(), password.getUppercaseLetters(), password.getNumbers(), password.getSpecialCharacters())); 
		
		return "index";
	}
}
