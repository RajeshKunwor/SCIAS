/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.scias.view;

import com.mycompany.scias.model.SCI;
import com.mycompany.scias.model.SoftwareComponent;
import com.mycompany.scias.presenter.SCIPresenter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class 
 *
 * @author rajes
 */
public class ViewSCIController implements Initializable {

    @FXML
    private TableView<SCI> sciList;
    @FXML
    private TableColumn<SCI, Float> e;
    @FXML
    private TableColumn<SCI, Float> i;
    @FXML
    private TableColumn<SCI, Float> m;
    @FXML
    private TableColumn<SCI, Float> score;
    @FXML
    private TableColumn<SCI, SoftwareComponent> softwareComponent;

    private SCIPresenter sciPtr;
    private ObservableList sciData;
    @FXML
    private Label totalSCIScore;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.sciPtr = new SCIPresenter();//create instance of SCIPresenter
        sciData = this.sciPtr.getAllSCIData();
        e.setCellValueFactory(new PropertyValueFactory<>("e"));
        i.setCellValueFactory(new PropertyValueFactory<>("i"));
        m.setCellValueFactory(new PropertyValueFactory<>("m"));
        score.setCellValueFactory(new PropertyValueFactory<>("result"));
        softwareComponent.setCellValueFactory(new PropertyValueFactory<>("component"));
        sciList.setItems(sciData);//set SCI data
        float score = this.sciPtr.getTotalSCIScore();//get sci total score
        totalSCIScore.setText(Float.toString(score));//set total sci score
    }

}
