/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.scias.view;

import com.mycompany.scias.presenter.UserPresenter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author basanti
 */
public class AddUserController implements Initializable {

    @FXML
    private TextField fullnameTextField;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private Button addUser;
    @FXML
    private Label errorMessage;
    @FXML
    private Label successMessage;

    private UserPresenter userPtr;
    @FXML
    private PasswordField passwordField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // initially set both text null
        errorMessage.setText("");
        successMessage.setText("");
        this.userPtr = new UserPresenter();//create instance of user presenter
    }

    @FXML
    private void addUserBtnClicked(ActionEvent event) {//add user
        String fullname = fullnameTextField.getText();
        String username = userNameTextField.getText();
        String password = passwordField.getText();
        String email = emailTextField.getText();
        long phoneNumber = 0;
        if (!phoneNumberTextField.getText().equals("")) {//check if phone number is empty or not
            phoneNumber = Long.parseLong(phoneNumberTextField.getText());
        }
        //check all fields against empty
        if (fullname.equals("") || username.equals("") || password.equals("") || email.equals("") || phoneNumberTextField.getText().equals("")) {
            errorMessage.setText("Please enter all the required data!");
        } else {
            errorMessage.setText("");
            if (this.userPtr.checkUser(username)) {//heck if the entered user is already registered or not
                errorMessage.setText("This user is already registered!");
            } else {
                boolean result = this.userPtr.addUser(fullname, username, password, email, phoneNumber);
                if (result) {//check if data is successfully added or not
                    errorMessage.setText("");
                    successMessage.setText("Successfully added.");
                    fullnameTextField.setText("");
                    userNameTextField.setText("");
                    passwordField.setText("");
                    emailTextField.setText("");
                    phoneNumberTextField.setText("");
                } else {
                    errorMessage.setText("Fail to register!");
                }
            }

        }

    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    @FXML
    private void checkEmail(KeyEvent event) {
        String email = emailTextField.getText();
        if (isValidEmail(email)) {
            errorMessage.setText("");
            addUser.setDisable(false);

        } else {
            errorMessage.setText("Please enter valid email address!");
            addUser.setDisable(true);
        }
    }

    @FXML
    private void checkPassword(KeyEvent event) {
        String password = passwordField.getText();
        int total = password.length();
        char ch;
        int upChars = 0, lowChars = 0, digits = 0, special = 0;
        if (total < 8) {
            errorMessage.setText("Password must be 8 charecters!");
            return;
        } else {
            for (int i = 0; i < total; i++) {
                ch = password.charAt(i);
                if (Character.isUpperCase(ch)) {
                    upChars = 1;
                } else if (Character.isLowerCase(ch)) {
                    lowChars = 1;
                } else if (Character.isDigit(ch)) {
                    digits = 1;
                } else {
                    special = 1;
                }
            }
        }
        if (upChars == 1 && lowChars == 1 && digits == 1 && special == 1) {
            errorMessage.setText("");
            addUser.setDisable(false);
        } else {
            addUser.setDisable(true);
            errorMessage.setText("Password must be combination of one upperletter, one lowerletter one digits and one special character !");
        }
    }
}
