/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scias.presenter;

import com.mycompany.scias.model.SoftwareComponent;
import javafx.collections.ObservableList;

/**
 *
 * @author sagar
 */
//this is presenter class for SoftwareComponent c
public class SoftwareComponentPresenter {

    private SoftwareComponent sc;//create instance of SoftwareComponent
    private DBPersister db;//create instance of DBPersister
    
    
    //create a constuctor
    public SoftwareComponentPresenter(){
        this.db = new DBPersister();
    }
    
    
    //add softwarecomponent
    public boolean addSoftwareComponent(String component){
        
       return this.db.addSoftwareComponent(new SoftwareComponent(component));
    }
    
    //get all software components
    public ObservableList getAllSoftwareComponents(){
        return this.db.getAllSoftwareComponents();
    }
    
    //check sofware component
    public boolean  checkSoftwareComponent(String component){
        return this.db.checkSoftwaresComponent(new SoftwareComponent(component));
    }
}
