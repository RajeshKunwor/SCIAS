/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scias.model;

/**
 *
 * @author sagar
 */
//SoftwareComponent class 
public class SoftwareComponent {
    
    private int id;
    private String component;
    
    //default constructor
    public SoftwareComponent(){
        
    }
    
    //parameterized constructor
    public SoftwareComponent(int id){
        this.id = id;
    }
    
    public SoftwareComponent(String component){
        this.component = component;
    }

    public SoftwareComponent(int id, String component){
        this.id = id;
        this.component = component;
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

   

    /**
     * @return the component
     */
    public String getComponent() {
        return component;
    }

    /**
     * @param component the component to set
     */
    public void setComponent(String component) {
        this.component = component;
    }
    
    
    public String toString(){
        return this.getComponent();
    }
    
    
}
