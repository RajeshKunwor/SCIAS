/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.scias.view;

import com.mycompany.scias.model.SoftwareComponent;
import com.mycompany.scias.presenter.SoftwareComponentPresenter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author rajes
 */
public class ViewSofwareComponentController implements Initializable {

    @FXML
    private TableView<SoftwareComponent> softwareComponentList;
    @FXML
    private TableColumn<SoftwareComponent, Integer> id;
    @FXML
    private TableColumn<SoftwareComponent, String> component;
    
    SoftwareComponentPresenter softPtr;
    
     ObservableList<SoftwareComponent> components;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        this.softPtr = new SoftwareComponentPresenter();//create intance of software component
        components = this.softPtr.getAllSoftwareComponents();
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        component.setCellValueFactory(new PropertyValueFactory<>("component"));
        
        softwareComponentList.setItems(components);//set data
    }    
    
}
