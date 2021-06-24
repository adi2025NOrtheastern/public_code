/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.Controller;

import com.aditicompany.DAO.LoginDao;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.aditicompany.Helper.Validation;
import com.aditicompany.pojo.Buyer;
import com.aditicompany.pojo.Seller;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author aditi
 */
@Controller
public class RegistrationController {

    @Autowired
    Validation validation;// = new Validation();
    
    @RequestMapping(value = "/register-new-user.htm", method = RequestMethod.GET)
    protected ModelAndView showRegisterUserPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        String option = request.getParameter("option");
        // if user clicks on create account link from login page

        System.out.println("from register-new-user.htm");
        mv = new ModelAndView("register-user");
        mv.addObject("firstname", "");
        mv.addObject("lastname", "");
        mv.addObject("date", new Date());
        mv.addObject("address", "");
        mv.addObject("email", "");
        mv.addObject("phone", "");
        mv.addObject("username", "");
        mv.addObject("password", "");
        mv.addObject("error", "");
        return mv;

    }
    
    
    
     @RequestMapping(value = "/register-user.htm", method = RequestMethod.POST)
    protected ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response, LoginDao loginDao ) throws Exception {
        ModelAndView mv = null;
         System.out.println("from register-user.htm");
        String option = request.getParameter("option");
        // if user clicks on create account link from login page
        System.out.println("option: "+ option);
       //(option.equals("register")){
           // LoginDao loginDao = new LoginDao();
            String userRole = request.getParameter("role") == null ? "" : request.getParameter("role");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String gender = request.getParameter("gender") == null ? "" : request.getParameter("gender");
            
            Date date = null;
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            try{
                date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateofbirth").substring(0, 9));
            }catch(Exception e){
                mv = new ModelAndView("register-user");
                mv.addObject("error","Please enter correct date!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new Date());
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
            if(date.compareTo(new Date()) > 0){
                mv = new ModelAndView("register-user");
                mv.addObject("error","Please enter a date less than today's date!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
            if(userRole.equals("")){
                mv = new ModelAndView("register-user");
                mv.addObject("error","Please select your role!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
            if(gender.equals("")){
                mv = new ModelAndView("register-user");
                mv.addObject("error","Please enter your Gender!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(!validation.onlyLettersValidation(firstname) || firstname.trim().length() < 0 || firstname.trim().length() > 50){
                mv = new ModelAndView("register-user");
                mv.addObject("error","Please enter valid First Name! First name cannot have more than 50 letters");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(!validation.onlyLettersValidation(lastname) || lastname.trim().length() < 0 || lastname.trim().length() > 50){
                mv = new ModelAndView("register-user");
                mv.addObject("error","Please enter valid Last Name! Last name cannot have more than 50 letters");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(address.trim().length() < 8 || address.trim().length() > 100){
                mv = new ModelAndView("register-user");
                mv.addObject("error","Please enter valid Address! Address cannot be less than 8 letters or more than 100 letters!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(!validation.phoneNumberValidation(phone) || phone.trim().length() > 20){
                mv = new ModelAndView("register-user");
                mv.addObject("error","Please enter valid Phone Number!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(username.trim().length() < 5 || username.trim().length() > 10){
                mv = new ModelAndView("register-user");
                mv.addObject("error","Username should be minimum of 5 characters and maximum of 10 characters!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(validation.usernameWithSpacesValidation(username)){
                mv = new ModelAndView("register-user");
                mv.addObject("error","Please enter valid Username!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(!validation.passwordPatternCorrect(password) || password.trim().length() < 6 || password.trim().length() > 10){
                mv = new ModelAndView("register-user");
                mv.addObject("error","Password should have 1 small-case letter, 1 Capital letter, 1 digit, 1 special character and the length should be between 6-10 characters");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
            int r = loginDao.checkUser(email, username);
            if(r == 1){
                mv = new ModelAndView("register-user");
                mv.addObject("error","User already exist!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
            
            //check if role is seller or buyer
            
            int result =0;
            
            if(userRole.equals("seller"))
            {
                System.out.println(firstname+" "+ lastname+" "+ gender+" "+ date+" "+ address+" "+ email+" "+ phone+" "+ username+" "+ password);
                result = loginDao.addSeller(firstname, lastname, gender, date, address, email, phone, username, password);
            
            }
            else if(userRole.equals("buyer"))
            {
                result = loginDao.registerBuyer(firstname, lastname, gender, date, address, email, phone, username, password);
            
            }
            
            if(result == 1){
                mv = new ModelAndView("login","success","User registered successfully!");
                return mv;
            }else {
                mv = new ModelAndView("register-user");
                mv.addObject("error","Something went wrong. Please try again");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
            //return mv;
        }
    
    
    //update-user.htm

    
     @RequestMapping(value = "/update-user.htm", method = RequestMethod.POST)
    protected ModelAndView UpdateUser(HttpServletRequest request, HttpServletResponse response, LoginDao loginDao ) throws Exception {
        ModelAndView mv = null;
         System.out.println("from update-user.htm");
        String option = request.getParameter("option");
        // if user clicks on create account link from login page
        System.out.println("option: "+ option);
       //(option.equals("register")){
           // LoginDao loginDao = new LoginDao();
           
           if( request.getSession().getAttribute("user") == null)
           {
               return new ModelAndView("login");
           }
           
          
            String userRole = (String) request.getSession().getAttribute("role");//request.getParameter("role") == null ? "" : request.getParameter("role");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String gender = request.getParameter("gender") == null ? "" : request.getParameter("gender");
            
            Date date = null;
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            try{
                date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateofbirth").substring(0, 9));
            }catch(Exception e){
                mv = new ModelAndView("update-my-profile");
                mv.addObject("error","Please enter correct date!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new Date());
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
            if(date.compareTo(new Date()) > 0){
                mv = new ModelAndView("update-my-profiler");
                mv.addObject("error","Please enter a date less than today's date!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
            if(userRole.equals("")){
                mv = new ModelAndView("update-my-profile");
                mv.addObject("error","Please select your role!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
            if(gender.equals("")){
                mv = new ModelAndView("update-my-profile");
                mv.addObject("error","Please enter your Gender!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(!validation.onlyLettersValidation(firstname) || firstname.trim().length() < 0 || firstname.trim().length() > 50){
                mv = new ModelAndView("update-my-profile");
                mv.addObject("error","Please enter valid First Name! First name cannot have more than 50 letters");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(!validation.onlyLettersValidation(lastname) || lastname.trim().length() < 0 || lastname.trim().length() > 50){
                mv = new ModelAndView("update-my-profile");
                mv.addObject("error","Please enter valid Last Name! Last name cannot have more than 50 letters");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(address.trim().length() < 8 || address.trim().length() > 100){
                mv = new ModelAndView("update-my-profiler");
                mv.addObject("error","Please enter valid Address! Address cannot be less than 8 letters or more than 100 letters!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(!validation.phoneNumberValidation(phone) || phone.trim().length() > 20){
                mv = new ModelAndView("update-my-profile");
                mv.addObject("error","Please enter valid Phone Number!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(username.trim().length() < 5 || username.trim().length() > 10){
                mv = new ModelAndView("update-my-profile");
                mv.addObject("error","Username should be minimum of 5 characters and maximum of 10 characters!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(validation.usernameWithSpacesValidation(username)){
                mv = new ModelAndView("update-my-profile");
                mv.addObject("error","Please enter valid Username!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }else if(!validation.passwordPatternCorrect(password) || password.trim().length() < 6 || password.trim().length() > 10){
                mv = new ModelAndView("update-my-profile");
                mv.addObject("error","Password should have 1 small-case letter, 1 Capital letter, 1 digit, 1 special character and the length should be between 6-10 characters");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
            int r = loginDao.checkUser(email, username);
            if(r == 1){
                mv = new ModelAndView("update-my-profile");
                mv.addObject("error","User already exist!");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
            
            //check if role is seller or buyer
            
            int result =0;
            
            if(userRole.equals("seller"))
            {
                 Seller sellerData = (Seller) request.getSession().getAttribute("user");
           
                result = loginDao.updateSeller(firstname, lastname, gender, date, address, email, phone, username, password, sellerData );
            
            }
            else if(userRole.equals("buyer"))
            {
                 Buyer sellerData = (Buyer) request.getSession().getAttribute("user");
           
                result = loginDao.UpdateBuyer(firstname, lastname, gender, date, address, email, phone, username, password, sellerData);
            
            }
            
            if(result == 1){
                request.setAttribute("msg","Update success");
                mv = new ModelAndView("success-page","success","User updated successfully!");
                return mv;
            }else {
                mv = new ModelAndView("update-my-profile");
                mv.addObject("error","Something went wrong. Please try again");
                mv.addObject("firstname",firstname);
                mv.addObject("lastname",lastname);
                mv.addObject("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
                mv.addObject("address",address);
                mv.addObject("email",email);
                mv.addObject("phone",phone);
                mv.addObject("username",username);
                mv.addObject("password",password);
                return mv;
            }
            //return mv;
        }


}