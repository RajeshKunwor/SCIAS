/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.scias.view;

import com.mycompany.scias.presenter.UserPresenter;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author basanti
 */
public class LoginController implements Initializable {

    @FXML
    private Label errorMessage;
    @FXML
    private Button loginBtn;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private AnchorPane scenePane;
    Stage stage;
    
    private UserPresenter userPtr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        errorMessage.setVisible(false);//set false
        this.userPtr = new UserPresenter();//create instance of UserPresenter class
    }    

    @FXML
    //login button
    private void loginBtnClicked(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        Boolean response = this.userPtr.login(username, password);
        if (response == true) {
            try {
                errorMessage.setText("");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 600, 550);
                Stage primaryStage = new Stage();
                primaryStage.setTitle("SCIAS Dashboard");
                primaryStage.setScene(scene);
                primaryStage.show();
                stage = (Stage) scenePane.getScene().getWindow();
                stage.close();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            errorMessage.setText("Invalid username or password!");
            errorMessage.setVisible(true);
        }
    }
    
}
