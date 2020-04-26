package com.technocrats.creatingjoy.controller;


import com.technocrats.creatingjoy.dto.AddressDTO;
import com.technocrats.creatingjoy.dto.UserDTO;
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
public class AuthController {




    @Autowired
    private UserService userService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/home")
    public String showHome(){
        return "home";
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {

        theModel.addAttribute("user", new UserDTO());
        theModel.addAttribute("address",new AddressDTO());


        return "login_signup";
    }


    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("user") UserDTO user, @ModelAttribute("address") AddressDTO address,
            BindingResult theBindingResult,
            Model theModel) {

        log.info("address is {}",address);

        String userName = user.getUserName();
        log.info("Processing registration form for: " + userName);


        if (theBindingResult.hasErrors()){
            return "login_signup";
        }


        UserDTO existing = userService.findByUserName(userName);
        if (existing != null){
            theModel.addAttribute("user", new UserDTO());
            theModel.addAttribute("address",new AddressDTO());
            theModel.addAttribute("registrationError", "User name already exists.");

            log.error("User name already exists.");
            return "login_signup";
        }
        address.setUserDTO(user);
        user.setAddressDTO(address);
        userService.save(user);


        theModel.addAttribute("registrationSuccess", "Registered Successfully.Please log in");
        return "login_signup";
    }


}