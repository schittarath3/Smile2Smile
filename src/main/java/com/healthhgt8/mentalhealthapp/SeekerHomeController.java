package com.healthhgt8.mentalhealthapp;

import javafx.application.HostServices;
import javafx.fxml.Initializable;


import java.net.URL;
import java.util.ResourceBundle;

public class SeekerHomeController implements Initializable {

    private HostServices services;

    public void setServices(HostServices services) {
        this.services = services;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
