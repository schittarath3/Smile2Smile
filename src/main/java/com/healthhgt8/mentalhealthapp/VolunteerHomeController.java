package com.healthhgt8.mentalhealthapp;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VolunteerHomeController implements Initializable {

    private HostServices services;

    @FXML
    private VBox volunteerHomePane;

    @FXML
    private TextField enterMeetURL;

    public void setServices(HostServices services) {
        this.services = services;
    }

    @FXML
    private void launchGMeet (ActionEvent actionEvent) throws IOException {
        String googleMeetURL = "http://meet.google.com/new";
        HostServices services = this.services;
        services.showDocument(googleMeetURL);

        enterMeetURL.setVisible(true);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void handleMeetLink(ActionEvent actionEvent) {
    }
}