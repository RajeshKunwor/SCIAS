/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scias.presenter;

import com.mycompany.scias.model.SCI;
import com.mycompany.scias.model.SoftwareComponent;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author rija
 */
//this is presenter class for SCI 
public class SCIPresenter {

    private DBPersister db;//create instance of DBPersister
    private SCI sci;//create instance of SCI

    //create constructor 
    public SCIPresenter() {
        this.db = new DBPersister();
    }
    
    //add sci data
    public boolean addSCI(String component, float e, float i, float m, String r ){
        int softwareComponentId = this.db.getSoftwareComponentIdByComponent(component);
        sci = new SCI(e,i,m,r, new SoftwareComponent(softwareComponentId));
        return this.db.addSCI(sci);
    }
    
    
    //get total SCI SCORE
    public float getTotalSCIScore(){
        return this.db.getTotalSCIScore();
    }
    
    //get software component
    public ArrayList<String> getSoftwareComponents(){
        return this.db.getSoftwareComponents();
    }
    
    //get all sci data
    public ObservableList getAllSCIData(){
        return this.db.getAllSCI();
    } 
    
    //check software component 
    public boolean checkSoftwareComponentID(String component){
        return this.db.checkSoftwaresComponentID(new SoftwareComponent(component));
    }
}
