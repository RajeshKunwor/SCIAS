/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.scias.view;

import com.mycompany.scias.model.User;
import com.mycompany.scias.presenter.UserPresenter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author anil
 */
public class ViewUserController implements Initializable {

    @FXML
    private TableView<User> userList;
    @FXML
    private TableColumn<User, String> fullname;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private TableColumn<User, Long> phonenumber;
    @FXML
    private TableColumn<User, String> username;
    @FXML
    private TableColumn<User, String> password;
    @FXML
    private TextField searchUserTextField;
    @FXML
    private Button searchBtn;

    private UserPresenter userPtr;
    ObservableList<User> users;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.userPtr = new UserPresenter();//create instance of UserPresenter
        users = userPtr.getAllUsers();
        fullname.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        phonenumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        username.setCellValueFactory(new PropertyValueFactory<>("userName"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        userList.setItems(users);//set user

    }

    

}
