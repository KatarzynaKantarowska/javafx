import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import javax.swing.*;

public class KontrolkiZadanie extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label infoLabel = new Label("Pasek postępu");
        Label finishLabel = new Label("Zakończono");
        Button startButton = new Button("Start");
        Button restartButton = new Button("Restart");
        ProgressBar progressBar = new ProgressBar();

        infoLabel.setLayoutY(10);
        progressBar.setLayoutY(30);
        finishLabel.setLayoutY(50);
        startButton.setLayoutY(70);
        restartButton.setLayoutY(70);
        restartButton.setLayoutX(500);

        finishLabel.setVisible(false);
        restartButton.setDisable(true);

        Runnable runnable= new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    double progressValue = 0.01 * i;

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressValue);

                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        finishLabel.setVisible(true);
                        restartButton.setDisable(false);
                    }
                });
            }
        };

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startButton.setDisable(true);
                new Thread(runnable).start();
            }
        });
        restartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                progressBar.setProgress(0);
                finishLabel.setVisible(false);
                startButton.setDisable(false);
                restartButton.setDisable(true);
            }
        });
        {
            progressBar.setProgress(0);

        }


        Group group = new Group();
        group.getChildren().add(infoLabel);
        group.getChildren().add(finishLabel);
        group.getChildren().add(startButton);
        group.getChildren().add(restartButton);
        group.getChildren().add(progressBar);

        Scene scene = new Scene(group, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Kontrolki zadanie");
        primaryStage.setX(2500);
        primaryStage.setY(300);

    }
}
