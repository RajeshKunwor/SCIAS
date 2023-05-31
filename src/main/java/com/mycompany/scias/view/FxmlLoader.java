/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scias.view;

import com.mycompany.scias.App;
import java.io.FileNotFoundException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author rajes
 */
//this class is used to load fmxl file 
public class FxmlLoader {
    private Pane view;
    
    //this method returns the fxml page 
    public Pane getPage(String fileName) throws FileNotFoundException{
        try{
            URL fileUrl = App.class.getResource("/fxml/"+fileName+".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("File not found!");
            }
            view = new FXMLLoader().load(fileUrl);
        }
        catch(Exception e){
            System.out.println("No Fxml Page found.");
        }
        return view;
    }
    
//     FxmlLoader object = new FxmlLoader();
//        Pane view = object.getPage("addCFData");
//        mainPage.setCenter(view);
}
