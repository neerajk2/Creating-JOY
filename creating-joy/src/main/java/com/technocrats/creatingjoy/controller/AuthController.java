package com.technocrats.creatingjoy.controller;


import com.technocrats.creatingjoy.dto.AddressDTO;
import com.technocrats.creatingjoy.dto.UserDTO;
import com.technocrats.creatingjoy.service.AuthService;
import com.technocrats.creatingjoy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Slf4j
public class AuthController {


    @Autowired
    private AuthService authService;



    @Autowired
    private UserService userService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/home")
    public String showHome(Model model,HttpServletRequest request){

        HttpSession session=request.getSession();
        UserDTO userDTO=(UserDTO)session.getAttribute("user");
        model.addAttribute("currentUser",userDTO);


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

            @Valid @ModelAttribute("user") UserDTO userDTO, @ModelAttribute("address") AddressDTO addressDTO,
            BindingResult theBindingResult,
            Model theModel,HttpServletRequest request) {
        HttpSession session = request.getSession();

        log.info("address is {}", addressDTO);

        String userName = userDTO.getUserName();
        log.info("Processing registration form for: " + userName);


        if (theBindingResult.hasErrors()) {
            return "login_signup";
        }

        if(!(request.getParameter("password").equals(request.getParameter("confirm-password")))){
            theModel.addAttribute("user", new UserDTO());
            theModel.addAttribute("address", new AddressDTO());
            theModel.addAttribute("registrationError", "Passwords doesn't match.");

            return "login_signup";
        }

        UserDTO existing = userService.findByUserName(userName);
        if (existing != null) {
            theModel.addAttribute("user", new UserDTO());
            theModel.addAttribute("address", new AddressDTO());
            theModel.addAttribute("registrationError", "User name already exists.");

            return "login_signup";
        }

        session.setAttribute("registerUser", userDTO);
        session.setAttribute("registerAddress",addressDTO);
        authService.sendToken(userDTO.getPhoneNumber(), "sms");

        return "otp_page";
    }

    @PostMapping("/verifyOTP")
    public String verifyOtp( Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        UserDTO userDTO=(UserDTO)session.getAttribute("registerUser");
        AddressDTO addressDTO=(AddressDTO)session.getAttribute("registerAddress");
        String otp = request.getParameter("OTP");
        String phoneNumber = userDTO.getPhoneNumber();

        if (authService.verifyToken(otp, phoneNumber)) {
            userDTO.setAddressDTO(addressDTO);
            addressDTO.setUserDTO(userDTO);

            userService.save(userDTO);
            model.addAttribute("user", new UserDTO());
            model.addAttribute("address", new AddressDTO());
            return "login_signup";


        }
        else {
            model.addAttribute("Message", "Invalid OTP!");
            return "otp_page";
        }

    }
    @GetMapping("/resendOTP")
    public String resendOTP( HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDTO userDTO=(UserDTO)session.getAttribute("registerUser");
        authService.sendToken(userDTO.getPhoneNumber(), "sms");

        return "otp_page";
    }


}
