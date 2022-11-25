import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Kontrolki extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Font font = Font.font("Times New Roman", FontWeight.BOLD, 16);
        System.out.println(Font.getFamilies());

        Color color = Color.web("FF55FF");
        // hex color

        // Label
        Label label = new Label("Moja pierwsza labelka");
        label.setLayoutX(15);
        label.setLayoutY(35);
        //label.setFont(new Font(20));
        label.setFont(font);
       // label.setTextFill(Color.AQUAMARINE);
        label.setTextFill(color);
        label.setMaxWidth(80);
        label.setWrapText(true);
        label.setRotate(15);

        //ImageView
        Image image = new Image("serduszko-696x612.jpg");
        ImageView imageView = new ImageView(image);
        //label.setGraphic(imageView);
        //Label labelWithImage = new Label("Labelka z obrazkiem", imageView);
        imageView.setX(80);
        imageView.setY(40);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true); // równomiernie skaluje

        //Button

        Button button = new Button("Pierwszy klikalny przycisk");
        button.setText("Klikalny przycisk ze zmiononym tekstem");
        button.setLayoutX(20);
        button.setLayoutY(100);
        button.setTextFill(Color.AQUAMARINE);
        //button.setGraphic(imageView);
        button.setDisable(false); // wyłączanie przycisku
        button.setMaxWidth(500);
        button.setWrapText(true);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Kliknęłam!");
                String tekst = button.getText() + "kliknęłam";
                button.setText(tekst);
            }
        });



        ///////////////////////////////////////////
        Group group = new Group();
        group.getChildren().add(label);
        group.getChildren().add(imageView);
        group.getChildren().add(button);


        Scene scene = new Scene(group, 800, 600, Color.WHITE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplikacja kontrolki");
        primaryStage.show();


    }
}
