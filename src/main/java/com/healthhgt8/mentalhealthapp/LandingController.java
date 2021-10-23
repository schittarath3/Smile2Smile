package com.healthhgt8.mentalhealthapp;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LandingController implements Initializable {

    private HostServices services;

    public void setServices(HostServices services) {
        this.services = services;
    }

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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("seeker-signin-view.fxml"));
        root = fxmlLoader.load();
        SeekerSignInController controller = fxmlLoader.getController();
        controller.setServices(this.services);

        Scene scene = new Scene(root, 375, 700);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setScene(scene);
        stage.show();
    }

    public void startVolunteerScreen(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) volunteerSignInBtn.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("volunteer-signin-view.fxml"));
        root = fxmlLoader.load();
        VolunteerSignInController controller = fxmlLoader.getController();
        controller.setServices(this.services);

        Scene scene = new Scene(root, 375, 600);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}