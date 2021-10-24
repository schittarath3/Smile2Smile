package com.healthhgt8.mentalhealthapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.HashMap;

public class SeekerSignInController extends SignInController {

    @FXML
    private CheckBox anonCheck;

    @Override
    public boolean sendInfoToDatabase() {
        boolean validFields = super.textFieldCheck();
        super.sendAccountCreateNotif(validFields);

        HashMap<String, String> map = new HashMap<>();

        if (anonCheck.isSelected()) {
            String fakeName = "Joe Doe";
            User.getInstance().setName(fakeName);
            User.getInstance().setNameDisclosed(false);
            map.put("name", fakeName);
        } else {
            User.getInstance().setName(super.nameInput.getText());
            User.getInstance().setNameDisclosed(true);
            map.put("name", super.nameInput.getText());
        }

        User.getInstance().setHelper(false);

        map.put("school", super.schoolInput.getText());
        map.put("year", super.yearInput.getText());
        User.getInstance().setMajor(super.majorInput.getText());
        map.put("major", super.majorInput.getText());
        User.getInstance().setEmail(super.emailInput.getText());
        map.put("email", super.emailInput.getText());

        DBObject dbObject = DBObject.getInstance();
        dbObject.sendToDB(map, "test", "Client");

        return validFields;
    }

    @FXML
    public void startSeekerScreen(ActionEvent actionEvent) throws IOException {
        boolean success = sendInfoToDatabase();

        if (!success) return;

        Stage stage;
        Parent root;
        stage = (Stage) super.SignIn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HealthApp.class.getResource("seeker-home-view.fxml"));
        root = fxmlLoader.load();
        SeekerHomeController controller = fxmlLoader.getController();
        controller.setServices(super.getServices());

        Scene scene = new Scene(root, 375, 600);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        scene.getStylesheets().add(this.getClass().getResource("seekerscene.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
