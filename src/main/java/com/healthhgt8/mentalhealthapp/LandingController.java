package com.healthhgt8.mentalhealthapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LandingController {
    @FXML
    private Button seekerSignInBtn;
    @FXML
    private Button volunteerSignInBtn;
    @FXML
    private Label welcomeText;

    @FXML
    public void startSeekerScreen(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) seekerSignInBtn.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(
                getClass().getResource("seeker-signin-view.fxml")
                    )
                );

        Scene scene = new Scene(root, 375, 700);
        stage.setScene(scene);
        stage.show();
    }

    public void startVolunteerScreen(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) seekerSignInBtn.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(
                        getClass().getResource("volunteer-signin-view.fxml")
                )
        );

        Scene scene = new Scene(root, 375, 700);
        stage.setScene(scene);
        stage.show();
    }
}