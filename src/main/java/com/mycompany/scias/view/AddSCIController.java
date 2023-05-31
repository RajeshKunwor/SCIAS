/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.scias.view;

import com.mycompany.scias.presenter.SCIPresenter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rija
 */
public class AddSCIController implements Initializable {

    @FXML
    private Label errorMessage;
    @FXML
    private TextField e;

    @FXML
    private TextField i;
    @FXML
    private TextField m;
    @FXML
    private ComboBox<String> functionalUnit;
    @FXML
    private Button addBtn;
    @FXML
    private Label successMessage;
    @FXML
    private ChoiceBox<String> softwareComponent;

    private SCIPresenter sciPtr;//create instance of SCIPresenter
    @FXML
    private Label sciScore;
    @FXML
    private Button calculateSCIBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        this.sciPtr = new SCIPresenter();//create instance of SCIPresenter
        errorMessage.setText("");//set text null initially
        successMessage.setText("");//set text null initially

        //add functinal Unit 
        functionalUnit.getItems().add("Per Person");
        functionalUnit.getItems().add("Per Device");

        //add software components
        softwareComponent.getItems().addAll(this.sciPtr.getSoftwareComponents());

    }

    @FXML
    private void addBtnClicked(ActionEvent event) {//add data
        //check fields against empty
        if (softwareComponent.getValue() == null || e.getText().equals("") || m.getText().equals("")
                || i.getText().equals("") || functionalUnit.getValue() == null) {
            errorMessage.setText("Please fill all the fields!");
            successMessage.setText("");
        } else { 
            if (this.sciPtr.checkSoftwareComponentID(softwareComponent.getValue())) {//check whether or not SCI data for software component is already added 
                successMessage.setText("");
                errorMessage.setText("SCI data for this software component is already added!");
            } else {
                boolean result = this.sciPtr.addSCI(softwareComponent.getValue(), Float.parseFloat(e.getText()),
                        Float.parseFloat(i.getText()), Float.parseFloat(m.getText()), functionalUnit.getValue());
                if (result) {//check if data is successfully added or not
                    errorMessage.setText("");
                    successMessage.setText("Successfully added SCI data.");
                    e.setText("");
                    i.setText("");
                    m.setText("");

                } else {
                    successMessage.setText("");
                    errorMessage.setText("Fail to add sci data!");
                }
            }

        }
    }

    @FXML
    private void calculateSCIBtnClicked(ActionEvent event) {//calculate sci score
        float score = 0;
        String result;
        score = (Float.parseFloat(e.getText())*Float.parseFloat(i.getText()))+Float.parseFloat(m.getText());//calculate sci score
        result = Float.toString(score) + " "+functionalUnit.getValue() ;
        sciScore.setText(result);//set sci score result
    }

}
