package com.healthhgt8.mentalhealthapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class VolunteerSignInController extends SignInController{

    @Override
    boolean sendInfoToDatabase() {
        boolean validFields = super.textFieldCheck();
        super.sendAccountCreateNotif(validFields);

        HashMap<String, String> map = new HashMap<>();
        map.put("name", super.nameInput.getText());
        map.put("school", super.schoolInput.getText());
        map.put("year", super.yearInput.getText());
        map.put("major", super.majorInput.getText());
        map.put("email", super.emailInput.getText());

        DBObject dbObject = DBObject.getInstance();
        dbObject.sendToDB(map, "test", "Users");

        return validFields;
    }

    @FXML
    private void startVolunteerScreen(ActionEvent actionEvent) throws IOException {
        boolean success = sendInfoToDatabase();

        if (!success) return;

        Stage stage;
        Parent root;
        stage = (Stage) super.SignIn.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HealthApp.class.getResource("volunteer-home-view.fxml"));
        root = fxmlLoader.load();
        VolunteerHomeController controller = fxmlLoader.getController();
        controller.setServices(super.getServices());

        Scene scene = new Scene(root, 375, 600);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        scene.getStylesheets().add(this.getClass().getResource("scene.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
