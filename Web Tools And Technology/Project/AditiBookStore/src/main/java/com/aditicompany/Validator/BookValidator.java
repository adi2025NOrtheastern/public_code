/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.Validator;

import com.aditicompany.DAO.BookDao;
import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.pojo.Book;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

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
public class BookValidator implements Validator {

    private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

    
    
    
    public boolean supports(Class aClass) {
        return aClass.equals(Book.class);
    }

    public void validate(Object obj, Errors errors) {

        //Pattern pattern = Pattern.compile(IMAGE_PATTERN);
        //Matcher matcher = null;
       // MultipartFile photo;

       BookDao bookDao = new BookDao();
        Book book = (Book) obj;

        System.out.println("book: "+ book.getBookId()+book.getAuthor()+book.getDescription()+book.getGenre_name()+book.getIsbn()+book.getSold()+book.getTitle());
        //BookDao bookDao = new BookDao();
        List<Book> bk;
        try {
            bk = bookDao.listBook();
            for (Book b : bk) {
                if (b.getIsbn().equals(book.getIsbn())) {

                    errors.rejectValue("isbn", "isbn.alreadyExist",
                            "This isbn already exists!");
                }
            }

        } catch (EbookstoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "error.invalid.isbn", "ISBN Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.title", "Title Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "error.invalid.author", "Author Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.price", "Price Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.description", "Description Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre_name", "error.invalid.genre_name", "Genre Name Required. Create at least one Genre.");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "error.invalid.quantity", "Quantity Required");
     //   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "photo", "error.invalid.photo", "Photo Name Required");

       // photo = book.getPhoto();

       // if(photo != null){
       // matcher = pattern.matcher(photo.getOriginalFilename());
      //  }
        //matching with the original file again

      //  if (photo!=null && 0 == photo.getSize()) {
     //       errors.rejectValue("photo", "Test", "File is empty");
     //   }
    //    if (matcher!=null && !matcher.matches()) {
    //        errors.rejectValue("photo", "Test", "Invalid Image Format");
    //    }

   //     if (photo!=null && 5000000 < photo.getSize()) {
   //         errors.rejectValue("photo", "Test", "File size is over 5mb!");
   //     }

    }
}
