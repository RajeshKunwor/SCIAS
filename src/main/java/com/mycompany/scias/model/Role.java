/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scias.model;

/**
 *
 * @author basanti
 */
//this class is used for modeling the role
public class Role {
    private int id = 0;
    private String type;

    //parameterized constructor
    public Role(int id, String type){
        this.id = id;
        this.type = type;
    }
    
    //default constructor
    public Role(){
        
    }
    
    public Role(int id){
        this.id = id;
    }
    public Role(String type){
        this.type = type;
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    public String toStirng(){
        return this.type;
    }
   
}
