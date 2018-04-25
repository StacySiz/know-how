package com.base.knowhow.controllers;

import com.base.knowhow.forms.UserRegistrationForm;
import com.base.knowhow.services.RegistrationService;
import com.base.knowhow.validators.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private RegistrationValidator registrationValidator;

    @InitBinder("regForm")
    public void addValidator(WebDataBinder dataBinder){
        dataBinder.addValidators(registrationValidator);
    }

//    @GetMapping("/hey")
//    public String hey(){
//        return "registration";
//    }

    @GetMapping(value = "/registration")
    public String showRegPage(){
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String reg(@Valid @ModelAttribute("regForm") UserRegistrationForm registrationForm,
                      BindingResult result, RedirectAttributes attributes){
//        if(result.hasErrors()){
//            attributes.addFlashAttribute("error",result.getAllErrors().get(0).getDefaultMessage());
//            return "redirect:/registration";
//        }
        System.out.println("hello there #1!");
        registrationService.register(registrationForm);
        System.out.println("TEST IS HERE 3");

        return "redirect:/signIn";
    }
}
