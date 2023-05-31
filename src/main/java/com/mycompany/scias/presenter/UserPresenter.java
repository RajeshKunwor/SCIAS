/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scias.presenter;

import com.mycompany.scias.model.Role;
import com.mycompany.scias.model.User;
import javafx.collections.ObservableList;

/**
 *
 * @author basanti
 */
//this is a presenter class for User
public class UserPresenter {

   private User user;//create instance of User
   private DBPersister  db;//create instance of DBPersister
   
   //create a constructor
   public  UserPresenter(){
      this.db = new DBPersister();
   }
    
    //login method
    public Boolean login(String username, String password){
       user = new User();
       user.setUserName(username);
       user.setPassword(password);
       boolean result = this.db.login(new User(username, password));
        return result;
    }
    
    //addUser method
    public Boolean addUser(String fullname, String username, String password, String email, long phonenumber){
        Role staff = new Role(2, "Staff");
        boolean result = this.db.addUser(new User(fullname,username, email,phonenumber,password, staff ));
        return result;
    }
    
    
    //check user is already registered or not
    public Boolean checkUser(String username){
        return this.db.checkUser(new User(username));
    }
    
    //getAllUser method
    public ObservableList getAllUsers(){
        return this.db.getAllUsers();
        
    }
    
}
