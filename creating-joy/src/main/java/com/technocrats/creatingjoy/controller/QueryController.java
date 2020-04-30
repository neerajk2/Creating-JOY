package com.technocrats.creatingjoy.controller;

import com.technocrats.creatingjoy.dto.*;

import com.technocrats.creatingjoy.service.AddressService;
import com.technocrats.creatingjoy.service.CategoryService;
import com.technocrats.creatingjoy.service.QueryService;
import com.technocrats.creatingjoy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/query")
public class QueryController {


    @Autowired
    private QueryService queryService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AddressService addressService;






    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/insertQuery")
    public String showQueryForm(Model theModel) {
        theModel.addAttribute("queryDTO", new QueryDTO());
        //theModel.addAttribute("categoryDTO", new CategoryDTO());
        theModel.addAttribute("addressDTO", new AddressDTO());

        return "insert_query";
    }
    @PostMapping("/processQuery")
    public String insertQuery(@ModelAttribute("queryDTO") QueryDTO queryDTO, @ModelAttribute("addressDTO") AddressDTO addressDTO, @ModelAttribute("categoryDTO") CategoryDTO categoryDTO,Model theModel,HttpServletRequest request) {

        String category=request.getParameter("category");
        CategoryDTO categoryDTO1=categoryService.findByCategoryName(category);
        java.util.Date date=new java.util.Date();
        java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());


        queryDTO.setTimestamp(sqlTime.toString());
        queryDTO.setCategoryDTO(categoryDTO1);
        categoryDTO1.getQueries().add(queryDTO);
        queryDTO.setAddressDTO(addressDTO);
        addressDTO.setQueryDTO(queryDTO);
        queryDTO.setQueryImage("/images/"+queryDTO.getQueryImage());
        HttpSession session = request.getSession();
        UserDTO userDTO= (UserDTO)session.getAttribute("user");
        queryDTO.setRequestor(userDTO);
        queryService.save(queryDTO);
        if(category.toUpperCase().equals("FOOD")){
            return "redirect:/query/food";
        }
        else if(category.toUpperCase().equals("SHELTER")){
            return "redirect:/query/shelter";
        }
        return "redirect:/query/clothes";
    }





    @RequestMapping("/showHome")
    public String showHome(){
        return "redirect:/home";
    }


    public List<QueryAddressDTO> fillUpQuery(List<QueryDTO> queries){
        List<QueryAddressDTO> queryAddresses=new ArrayList<>();
        for(QueryDTO query:queries){

            AddressDTO address=addressService.findByQueryId(query.getId());

            QueryAddressDTO queryAddress=new QueryAddressDTO();
            queryAddress.setAddress(address);
            queryAddress.setQuery(query);
            TimeAgo timeAgo=new TimeAgo();
            queryAddress.getQuery().setTimestamp(timeAgo.convert(query.getTimestamp()));
            int id =query.getAcceptorId();
            if(id>0){
                queryAddress.setAcceptor(userService.findById(query.getAcceptorId()));
            }

            queryAddresses.add(queryAddress);
        }

        return queryAddresses;

    }

    @GetMapping("/food")
    public String listFoodQueries(Model model,HttpServletRequest request){

        HttpSession session = request.getSession();
        UserDTO userDTO= (UserDTO)session.getAttribute("user");
        model.addAttribute("user",userDTO);
        List<QueryDTO> queriesOfFood=queryService.findByCategoryId(1);
        List<QueryAddressDTO> queryAddresses=fillUpQuery(queriesOfFood);
        model.addAttribute("QueryAddress",queryAddresses);

        return "list-food-queries";

    }

    @GetMapping("/shelter")
    public String listShelterQueries(Model model,HttpServletRequest request){

        HttpSession session = request.getSession();
        UserDTO userDTO= (UserDTO)session.getAttribute("user");
        model.addAttribute("user",userDTO);
        List<QueryDTO> queriesOfShelter=queryService.findByCategoryId(2);
        List<QueryAddressDTO> queryAddresses=fillUpQuery(queriesOfShelter);
        model.addAttribute("QueryAddress",queryAddresses);
        return "list-shelter-queries";


    }

    @GetMapping("/myQueries")
    public String getMyQueries(Model model,HttpServletRequest request){

        HttpSession session=request.getSession();
        UserDTO userDTO=(UserDTO) session.getAttribute("user");
        List<QueryDTO> queriesOfUser=queryService.findByRequestorIdOrAcceptorId(userDTO.getId(),userDTO.getId());
        List<QueryAddressDTO> queryAddresses=fillUpQuery(queriesOfUser);
        model.addAttribute("QueryAddress",queryAddresses);
        return "list-my-queries";

    }

    @GetMapping("/clothes")
    public String listClothQueries(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDTO userDTO= (UserDTO)session.getAttribute("user");
        model.addAttribute("user",userDTO);
        List<QueryDTO> queriesOfClothes=queryService.findByCategoryId(3);
        List<QueryAddressDTO> queryAddresses=fillUpQuery(queriesOfClothes);
        model.addAttribute("QueryAddress",queryAddresses);
        return "list-clothes-queries";
    }



    @GetMapping("/food/likes")
    public String foodLikes(@RequestParam("queryId") int id,@ModelAttribute("categoryName") String categoryName){
        QueryDTO queryDTO=queryService.findById(id);
        queryDTO.setCategoryDTO(categoryService.findByCategoryName("FOOD"));
        queryDTO.setLikes(queryDTO.getLikes()+1);
        queryService.save(queryDTO);

        return "redirect:/query/food";
    }

    @GetMapping("/food/dislikes")
    public String foodDislikes(@RequestParam("queryId") int id,Model model,HttpServletRequest request){
        QueryDTO queryDTO=queryService.findById(id);
        queryDTO.setCategoryDTO(categoryService.findByCategoryName("FOOD"));
        queryDTO.setDislikes(queryDTO.getDislikes()+1);
        if(queryDTO.getDislikes()==5){
            queryDTO.setCategoryDTO(null);
            queryService.save(queryDTO);
        }
        else{
            queryService.save(queryDTO);
        }

        return "redirect:/query/food";

    }

    @GetMapping("/shelter/likes")
    public String shelterLikes(@RequestParam("queryId") int id){
        QueryDTO queryDTO=queryService.findById(id);
        queryDTO.setCategoryDTO(categoryService.findByCategoryName("SHELTER"));
        queryDTO.setLikes(queryDTO.getLikes()+1);
        queryService.save(queryDTO);

        return "redirect:/query/shelter";
    }

    @GetMapping("/shelter/dislikes")
    public String shelterDislikes(@RequestParam("queryId") int id,Model model,HttpServletRequest request){
        QueryDTO queryDTO=queryService.findById(id);
        queryDTO.setCategoryDTO(categoryService.findByCategoryName("SHELTER"));
        queryDTO.setDislikes(queryDTO.getDislikes()+1);
        if(queryDTO.getDislikes()==5){
            queryDTO.setCategoryDTO(null);
            queryService.save((queryDTO));
        }
        else{
            queryService.save(queryDTO);
        }
        return "redirect:/query/shelter";
    }

    @GetMapping("/clothes/likes")
    public String clothesLikes(@RequestParam("queryId") int id){
        QueryDTO queryDTO=queryService.findById(id);
        queryDTO.setCategoryDTO(categoryService.findByCategoryName("CLOTHES"));
        queryDTO.setLikes(queryDTO.getLikes()+1);
        queryService.save(queryDTO);
        return "redirect:/query/clothes";
    }

    @GetMapping("/clothes/dislikes")
    public String clothesDislikes(@RequestParam("queryId") int id){
        QueryDTO queryDTO=queryService.findById(id);
        queryDTO.setCategoryDTO(categoryService.findByCategoryName("CLOTHES"));
        queryDTO.setDislikes(queryDTO.getDislikes()+1);
        if(queryDTO.getDislikes()==5){

            queryDTO.setCategoryDTO(null);
            queryService.save((queryDTO));

        }
        else{
            queryService.save(queryDTO);
        }

        return "redirect:/query/clothes";
    }

    @GetMapping("/shelter/accept")
    public String addShelterAcceptor(@RequestParam("queryId") int id,HttpServletRequest request){

        HttpSession session=request.getSession();
        UserDTO userDTO=(UserDTO) session.getAttribute("user");
        log.info("user {}",userDTO);
       QueryDTO queryDTO=queryService.findById(id);
       queryDTO.setCategoryDTO(categoryService.findByCategoryName("SHELTER"));
       queryDTO.setAcceptorId(userDTO.getId());
        queryService.save(queryDTO);
        return "redirect:/query/shelter";

    }

    @GetMapping("/food/accept")
    public String addFoodAcceptor(@RequestParam("queryId") int id,HttpServletRequest request){

        HttpSession session=request.getSession();
        UserDTO userDTO=(UserDTO) session.getAttribute("user");
        log.info("user {}",userDTO);
        QueryDTO queryDTO=queryService.findById(id);
        queryDTO.setCategoryDTO(categoryService.findByCategoryName("FOOD"));
        queryDTO.setAcceptorId(userDTO.getId());
        queryService.save(queryDTO);
        return "redirect:/query/food";

    }

    @GetMapping("/clothes/accept")
    public String addClothesAcceptor(@RequestParam("queryId") int id,HttpServletRequest request){
        HttpSession session=request.getSession();
        UserDTO userDTO=(UserDTO) session.getAttribute("user");
        QueryDTO queryDTO=queryService.findById(id);
        queryDTO.setCategoryDTO(categoryService.findByCategoryName("CLOTHES"));
        queryDTO.setAcceptorId(userDTO.getId());
        queryService.save(queryDTO);
        return "redirect:/query/clothes";

    }

}