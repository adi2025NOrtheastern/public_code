/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.Validator;

import com.aditicompany.DAO.GenreDao;
import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.pojo.Genre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author aditi
 */
@Component
public class GenreValidator implements Validator {

    @Autowired
    GenreDao genreDao;
    
    public boolean supports(Class aClass) {
        return aClass.equals(Genre.class);
    }

    public GenreDao getGenreDao() {
        return genreDao;
    }

    public void setGenreDao(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    public void validate(Object obj, Errors errors) {
        Genre genre = (Genre) obj;

        //GenreDao genreDao = new GenreDao();
        List<Genre> gen;
        try {
            if(genreDao == null)
            {
             genreDao = new GenreDao()   ;
            }
            gen = genreDao.listGenre();
            for (Genre g : gen) {
                if (g.getGenreName().equalsIgnoreCase(genre.getGenreName())) {

                    errors.rejectValue("genreName", "genreName.alreadyExist",
                            "This Genre already exists!");
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genreName", "error.invalid.genreName", "Genre Required");
    }
}
