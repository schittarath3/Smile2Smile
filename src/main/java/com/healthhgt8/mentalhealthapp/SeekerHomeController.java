package com.healthhgt8.mentalhealthapp;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.bson.Document;


import java.lang.annotation.Documented;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class SeekerHomeController implements Initializable {

    private HostServices services;

    @FXML
    private Button helpBtn1;
    @FXML
    private Button helpBtn2;
    @FXML
    private Button helpBtn3;
    @FXML
    private Button helpBtn4;
    @FXML
    private Button helpBtn5;
    @FXML
    private Button helpBtn6;
    @FXML
    private Button helpBtn7;
    @FXML
    private Button helpBtn8;
    @FXML
    private Button helpBtn9;


    private List<Button> buttonList;

    public void setServices(HostServices services) {
        this.services = services;
    }

    @FXML
    private void handleHelpAccept(ActionEvent event) {
        Button source = (Button) event.getSource();
        String meetingURL = source.getId();
        System.out.println(meetingURL);
        services.showDocument(meetingURL);
    }

    @FXML
    private void handleRefresh(ActionEvent actionEvent) {
        //Query table for hashedID or meetingID
        List<Document> randVolunteers =
                DBObject.getInstance().queryRandom(9, "test", "Users");
        //String[] strings = new String[9];
        for (int idx = 0; idx < 9; idx++) {
            buttonList.get(idx).setText((String) randVolunteers.get(idx).get("name"));
            buttonList.get(idx).setId((String) randVolunteers.get(idx).get("meeting"));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { 
        Button[] btnList = {helpBtn1, helpBtn2, helpBtn3, helpBtn4, helpBtn5,
                helpBtn6, helpBtn7, helpBtn8, helpBtn9};
        buttonList = Arrays.asList(btnList);
    }
}
