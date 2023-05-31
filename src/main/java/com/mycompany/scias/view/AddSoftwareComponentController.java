/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.scias.view;

import com.mycompany.scias.presenter.SoftwareComponentPresenter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author sagar
 */
public class AddSoftwareComponentController implements Initializable {

    @FXML
    private Label errorMessage;
    @FXML
    private Label successMessage;
    @FXML
    private TextField softwareComponetTextField;
    @FXML
    private Button addBtn;

    private SoftwareComponentPresenter softPtr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //set both text null initially
        errorMessage.setText("");
        successMessage.setText("");
        this.softPtr = new SoftwareComponentPresenter();//create instance of software component presenter

    }

    @FXML
    private void addBtnClicked(ActionEvent event) {//add data
        if (softwareComponetTextField.getText().equals("")) {//check field against empty
            errorMessage.setText("Please enter software component!");
        } else {
            //check if the entered software component is already added or not
            if (this.softPtr.checkSoftwareComponent(softwareComponetTextField.getText())) {
                successMessage.setText("");
                errorMessage.setText("This software component is already registerd!");
            } else {
                boolean result = this.softPtr.addSoftwareComponent(softwareComponetTextField.getText());
                if (result == true) {//check if data is successfully added or not
                    errorMessage.setText("");
                    successMessage.setText("Successfullay added.");
                    softwareComponetTextField.setText("");

                } else {
                    successMessage.setText("");
                    errorMessage.setText("Fail to add software component!");
                }

            }
        }
    }

}
