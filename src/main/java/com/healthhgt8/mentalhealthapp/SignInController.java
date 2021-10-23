package com.healthhgt8.mentalhealthapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public abstract class SignInController implements Initializable {
    @FXML
    private TextField nameInput;
    @FXML
    private Label validName;

    @FXML
    private TextField schoolInput;
    @FXML
    private Label validSchool;

    @FXML
    private TextField majorInput;
    @FXML
    private Label validMajor;

    @FXML
    private TextField yearInput;
    @FXML
    private Label validYear;

    @FXML
    private CheckBox anonCheck;

    @FXML
    public Button SignIn;

    void textFieldCheck() {
        if (nameInput.getText().split(" ").length == 0
            || nameInput.getText().length() == 0) {
            validName.setText("Enter a valid name");
        } else {
            validName.setText("");
        }

        if (schoolInput.getText().split(" ").length == 0
            || schoolInput.getText().length() == 0) {
            validSchool.setText("Enter a valid school");
        } else {
            validSchool.setText("");
        }

        if (majorInput.getText().split(" ").length == 0
            || majorInput.getText().length() == 0) {
            validMajor.setText("Enter a valid major");
        } else {
            validMajor.setText("");
        }

        if (yearInput.getText().split(" ").length == 0
            || yearInput.getText().length() == 0) {
            validYear.setText("Enter a valid year");
        } else {
            validYear.setText("");
        }
    }

    abstract void sendInfoToDatabase();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
