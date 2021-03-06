package com.healthhgt8.mentalhealthapp;

import com.mongodb.ClientSessionOptions;
import com.mongodb.client.*;
import com.mongodb.connection.ClusterDescription;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class HealthApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HealthApp.class.getResource("landing-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 375, 600);

        LandingController controller = (LandingController) fxmlLoader.getController();
        controller.setServices(this.getHostServices());

        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        scene.getStylesheets().add(this.getClass().getResource("landing.css").toExternalForm());

        stage.setTitle("MentalHealth@GT");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}