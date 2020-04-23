package com.technocrats.creatingjoy.controller;

import com.technocrats.creatingjoy.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthController {

    List<UserDTO> users = new ArrayList<UserDTO>();

    @GetMapping("/")
    public String login() {
        return "login_signup";
    }


    @GetMapping("/showLogin")
    public String showLogin() {
        return "login_signup";
    }

    @GetMapping("/verifyOTP")
    public String verifyOtp(String text) {
        return "otp_page";
//        if (text.equals("1234")) {
//            return "login_signup";
//        } else {
//            return "Invalid OTP";
//        }
    }


    @PostMapping("/validate")
    public String validate(@ModelAttribute(name = "user") UserDTO user, Model model) {


        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getUserName().equals(user.getUserName())) {
                if (users.get(i).getPassword().equals(user.getPassword()))
                    return "home";
                else {
                    model.addAttribute("Message", "Wrong Password!!");
                    return "login_signup";
                }


            }
        }
        model.addAttribute("Message", "You are not registered!!");
        return "login_signup";

    }


    @PostMapping("/addUser")
    public String addUser(@ModelAttribute(name = "user") UserDTO user, Model model) {
        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getUserName().equals(user.getUserName())) {
                model.addAttribute("Message", "UserName already exists!!");
                return "login_signup";
            }

        }
        users.add(user);

        return "login_signup";
    }






}