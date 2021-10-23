package com.healthhgt8.mentalhealthapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.Objects;

public class VolunteerSignInController extends SignInController{

    @Override
    boolean sendInfoToDatabase() {
        boolean validFields = super.textFieldCheck();
        super.sendAccountCreateNotif(validFields);
        return validFields;
    }

    @FXML
    private void startVolunteerScreen(ActionEvent actionEvent) throws IOException {
        boolean success = sendInfoToDatabase();

        if (!success) return;

        Stage stage;
        Parent root;
        stage = (Stage) super.SignIn.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(
                        getClass().getResource("volunteer-home-view.fxml")
                )
        );

        Scene scene = new Scene(root, 375, 600);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setScene(scene);
        stage.show();
    }
}
