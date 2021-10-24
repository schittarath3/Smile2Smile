package com.healthhgt8.mentalhealthapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bson.Document;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.HashMap;

public class VolunteerSignInController extends SignInController{

    @Override
    boolean sendInfoToDatabase() {
        boolean validFields = super.textFieldCheck();
        super.sendAccountCreateNotif(validFields);

        HashMap<String, String> map = new HashMap<>();

        User.getInstance().setName(super.nameInput.getText());
        map.put("name", super.nameInput.getText());

        User.getInstance().setHelper(true);
        User.getInstance().setNameDisclosed(true);

        map.put("school", super.schoolInput.getText());

        map.put("year", super.yearInput.getText());

        User.getInstance().setMajor(super.majorInput.getText());
        map.put("major", super.majorInput.getText());

        User.getInstance().setEmail(super.emailInput.getText());
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

        Document seeker = DBObject.getInstance().queryRandom(1, "test", "Client").get(0);

        controller.fillFields(
                (String) seeker.get("name"),
                (String) seeker.get("major"),
                (String) seeker.get("year"),
                (String) seeker.get("school"),
                ""
        );

        Scene scene = new Scene(root, 375, 600);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        scene.getStylesheets().add(this.getClass().getResource("scene.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
