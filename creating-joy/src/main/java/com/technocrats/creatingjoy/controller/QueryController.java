package com.technocrats.creatingjoy.controller;

import com.technocrats.creatingjoy.dto.AddressDTO;
import com.technocrats.creatingjoy.dto.CategoryDTO;
import com.technocrats.creatingjoy.dto.QueryDTO;
import com.technocrats.creatingjoy.dto.UserDTO;
import com.technocrats.creatingjoy.entity.User;
import com.technocrats.creatingjoy.service.AuthService;
import com.technocrats.creatingjoy.service.QueryService;
import com.technocrats.creatingjoy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/query")
public class QueryController {


   /* @Autowired
    private QueryService queryService;
    @Autowired
    private UserService userService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/insertQuery")
    public String showQueryForm(Model theModel) {
        theModel.addAttribute("queryDTO", new QueryDTO());
        theModel.addAttribute("categoryDTO", new CategoryDTO());
        theModel.addAttribute("addressDTO", new AddressDTO());

        return "insert_query";
    }
    @PostMapping("/processQuery")
    public String insertQery(@ModelAttribute("queryDTO") QueryDTO queryDTO,@ModelAttribute("addressDTO") AddressDTO addressDTO, Model theModel) {
        String queryText= queryDTO.getQueryText();

         //byte[] queryImage=queryDTO.getQueryImage();
         //String Category=queryDTO.getCategory();
        java.util.Date date=new java.util.Date();


        java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
        queryDTO.setTimestamp(sqlTime);
        //queryDTO.setCategory(categoryDTO);
        queryDTO.setAddress(addressDTO);
        UserDTO userDTO=userService.findById(1);
        log.info(userDTO.getUserName());
        queryDTO.setRequestor(userDTO);
        List<QueryDTO>  queryDTOS=new ArrayList<QueryDTO>();
        queryDTOS.add(queryDTO);
        userDTO.setQueries(queryDTOS);
        log.info("{}",queryDTO.getRequestor());
        //log.info("category :",categoryDTO.getCategoryName());
        log.info("address :",addressDTO.getStreet());

       // categoryDTO.setQueryDTO(queryDTO);
        log.info(" query text{}",queryDTO.getQueryText());
        log.info(" query time{}",queryDTO.getTimestamp());
        log.info(" query image{}",queryDTO.getQueryImage());
         queryService.save(queryDTO);

        return "home";
    }*/
}