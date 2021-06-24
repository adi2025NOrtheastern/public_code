/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aditi
 */
public class Q14Ccode {
    
}


#include <iostream>

using namespace std;
 struct movies_t {
       string title;
       int year;
   };


  struct friends_t {
     string name;
     string email;
     movies_t favorite_movie;
  } charlie, maria;

int main()
{
    friends_t * pfriends = &charlie;
pfriends->name="aditi";
pfriends->email="aa@gmail.com";
pfriends->favorite_movie.title="movieTitle";
pfriends->favorite_movie.year=1990;
cout << pfriends->name <<endl;
cout << pfriends->email <<endl;
cout<< pfriends->favorite_movie.title<<endl;
cout<< pfriends->favorite_movie.year<<endl;
return 1;
}