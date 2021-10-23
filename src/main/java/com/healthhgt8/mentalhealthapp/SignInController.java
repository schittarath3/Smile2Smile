package com.healthhgt8.mentalhealthapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
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
    Button SignIn;
    @FXML
    private Button signInBack;

    @FXML
    void handleSignInBack() throws IOException {
        Stage stage = (Stage) validSchool.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HealthApp.class.getResource("landing-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 375, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    boolean textFieldCheck() {
        boolean validFields = true;
        if (nameInput.getText().split(" ").length == 0
            || nameInput.getText().length() == 0) {
            validFields = false;
            validName.setText("Enter a valid name");
        } else {
            validName.setText("");
        }

        if (schoolInput.getText().split(" ").length == 0
            || schoolInput.getText().length() == 0) {
            validSchool.setText("Enter a valid school");
            validFields = false;
        } else {
            validSchool.setText("");
        }

        if (majorInput.getText().split(" ").length == 0
            || majorInput.getText().length() == 0) {
            validMajor.setText("Enter a valid major");
            validFields = false;
        } else {
            validMajor.setText("");
        }

        if (yearInput.getText().split(" ").length == 0
            || yearInput.getText().length() == 0) {
            validYear.setText("Enter a valid year");
            validFields = false;
        } else {
            validYear.setText("");
        }
        return validFields;
    }

    void sendAccountCreateNotif(boolean validFields) {
        System.out.println(validFields);
        if (validFields) {
            Notifications.create()
                    .title("Account created!")
                    .text("Welcome to Mental Health App!")
                    .showConfirm();
        }
    }


    abstract boolean sendInfoToDatabase();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}