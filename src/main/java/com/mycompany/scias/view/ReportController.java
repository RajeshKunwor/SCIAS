/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.scias.view;

import com.mycompany.scias.App;
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
import java.time.LocalDate;

/**
 * FXML Controller class
 *
 * @author rija
 */
public class ReportController implements Initializable {

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
    @FXML
    private Label reportDate;
    @FXML
    private Label generatedBy;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         this.sciPtr = new SCIPresenter();//create an instance of SCIPresenter
        sciData = this.sciPtr.getAllSCIData();//call getALLSCIData 
        //set cell value factory for the table view
        e.setCellValueFactory(new PropertyValueFactory<>("e"));
        i.setCellValueFactory(new PropertyValueFactory<>("i"));
        m.setCellValueFactory(new PropertyValueFactory<>("m"));
        score.setCellValueFactory(new PropertyValueFactory<>("result"));
        softwareComponent.setCellValueFactory(new PropertyValueFactory<>("component"));
        sciList.setItems(sciData);
        totalSCIScore.setText(Float.toString(this.sciPtr.getTotalSCIScore()));//get total sci score 
        reportDate.setText(LocalDate.now().toString());
        generatedBy.setText(App.getUser().getUserName());
        
    }    
    
}
