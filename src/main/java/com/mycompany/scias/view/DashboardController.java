/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.scias.view;

import com.mycompany.scias.App;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author anil
 */
public class DashboardController implements Initializable {

    Stage stage;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private BorderPane mainPage;
    @FXML
    private MenuButton userBtn;
    @FXML
    private Label user;
    private MenuButton softwareBtn;
    @FXML
    private MenuButton softwareComponentBtn;
    @FXML
    private MenuButton sciBtn;
    @FXML
    private Button generateReportBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private MenuItem addUser;
    @FXML
    private MenuItem viewUser;
    @FXML
    private MenuItem addSoftwareComponent;
    @FXML
    private MenuItem viewSoftwareComponent;
    @FXML
    private MenuItem addSCI;
    @FXML
    private MenuItem calculateSCI;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        user.setText("Hi," + App.getUser().getUserName());//set user
        userBtn.setVisible(false);//set false
        userBtn.setManaged(false);
        if (App.getUser().getRole().getId() == 1) {//check if user is admin or not depending upone roel ID
            userBtn.setVisible(true);
            userBtn.setManaged(true);
            
            softwareComponentBtn.setVisible(false);//set false
            softwareComponentBtn.setManaged(false);
            
            sciBtn.setVisible(false);//set false
            sciBtn.setManaged(false);
            
            generateReportBtn.setVisible(false);//set flase
            generateReportBtn.setManaged(false);

        }
    }

    @FXML
    //generate report button
    private void generateBtnClicked(ActionEvent event) {
          try {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPage("report");
            mainPage.setCenter(view);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    //logut button
    private void logoutBtnClicked(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 600, 550);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("SCIAS Login");
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UTILITY);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }

    @FXML
    //add user button
    private void addUserItemClicked(ActionEvent event) {
        try {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPage("addUser");
            mainPage.setCenter(view);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    //view user button
    private void viewUserItemClicked(ActionEvent event) {
        try {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPage("viewUser");
            mainPage.setCenter(view);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    //add software component button
    private void addSoftwareComponentClicked(ActionEvent event) {
        try {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPage("addSoftwareComponent");
            mainPage.setCenter(view);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    //view software component button
    private void viewSoftwareComponentClicked(ActionEvent event) {
        try {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPage("viewSoftwareComponent");
            mainPage.setCenter(view);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    //add sci button
    private void addSCIClicked(ActionEvent event) {
        try {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPage("addSCI");
            mainPage.setCenter(view);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    //calcualte sci button
    private void calculateSCIClicked(ActionEvent event) {
        try {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPage("viewSCI");
            mainPage.setCenter(view);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
