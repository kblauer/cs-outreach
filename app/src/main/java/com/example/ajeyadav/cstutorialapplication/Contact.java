/**
   Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the Contact class
   This class file contains the methods to add and retrieving the information from the database
*/

package com.example.ajeyadav.cstutorialapplication;

/**
 * Created by Achzeet on 10/14/2015.
 */
public class Contact {

    // Declaring input variables
    String fullname, email, password;

    // Setting username
    public void setFullname (String fullname){
        this.fullname = fullname;
    }

    // Getting username
    public String getFullname (){
        return this.fullname;
    }

    // Setting email
    public void setEmail (String email){
        this.email = email;
    }

    // Getting Email
    public String getEmail (){
        return this.email;
    }

    // Setting Password
    public void setPassword (String password){
        this.password = password;
    }

    // Getting Password
    public String getPassword (){
        return this.password;
    }

}
