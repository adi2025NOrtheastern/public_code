/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.Validator;

import com.aditicompany.pojo.Admin;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author aditi
 */
/*

 @Component is an annotation that allows Spring to automatically detect our custom beans. 
In other words, without having to write any explicit code, 
Spring will: Scan our application for classes annotated with @Component. 
Instantiate them and inject any specified dependencies into them.

*/
@Component
public class AdminValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Admin.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	//User user = (User) obj;
    	Admin admin = (Admin) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.firstName", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.lastName", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.username", "Username Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleName", "error.invalid.roleName", "RoleName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailID", "error.invalid.emailID", "EmailID Required");
        
   
        }

}
