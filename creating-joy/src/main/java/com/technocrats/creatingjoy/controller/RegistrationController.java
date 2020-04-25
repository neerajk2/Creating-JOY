package com.technocrats.creatingjoy.controller;


import com.technocrats.creatingjoy.entity.Address;
import com.technocrats.creatingjoy.entity.User;
import com.technocrats.creatingjoy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/register")
public class RegistrationController {


    @Autowired
    private UserService userService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {

        theModel.addAttribute("user", new User());
        theModel.addAttribute("address",new Address());


        return "login_signup";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("user") User user, @ModelAttribute("address") Address address,
            BindingResult theBindingResult,
            Model theModel) {

        log.info("address is {}",address);

        String userName = user.getUserName();
        log.info("Processing registration form for: " + userName);


        if (theBindingResult.hasErrors()){
            return "login_signup";
        }


        User existing = userService.findByUserName(userName);
        if (existing != null){
            theModel.addAttribute("user", new User());
            theModel.addAttribute("address",new Address());
            theModel.addAttribute("registrationError", "User name already exists.");

            log.error("User name already exists.");
            return "login_signup";
        }
        user.setAddress(address);
        address.setUser(user);
        userService.save(user);


        log.info("Successfully created user: " + userName);
        log.info("user:"+user);
        log.info("address"+user.getAddress());

        return "registration-confirmation";
    }










}
