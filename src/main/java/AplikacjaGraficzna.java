import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class AplikacjaGraficzna extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primeryStage) {
        // Stage  ->  Scene ->  StackPane  -> Text

        // Controls
        Text text = new Text("Tekst z pierwszej aplikacji graficznej");
        Button button = new Button("Mój pierwszy przycisk");
        Text textDrugi = new Text("Tekst drugi");

        //root
        // StackPane root = new StackPane(); // root wyrysowane na stosie
        //HBox root = new HBox(); // wyrysowane poziomo

        VBox root = new VBox(); // wyrysowane pionowo
        root.getChildren().add(text);
        root.getChildren().add(button);
        root.getChildren().add(textDrugi);


        //scene
        Scene scene = new Scene(root);

        //stage
        primeryStage.setScene(scene);

        primeryStage.setTitle("Moja aplikacja");

        primeryStage.setX(2100);
        primeryStage.setY(700);

        primeryStage.setWidth(800);
        primeryStage.setHeight(600);

       // primeryStage.initStyle(StageStyle.DECORATED);
       // primeryStage.initStyle(StageStyle.UNDECORATED);
       // primeryStage.initStyle(StageStyle.TRANSPARENT);
       // primeryStage.initStyle(StageStyle.UNIFIED);
       primeryStage.initStyle(StageStyle.UTILITY);

       primeryStage.setFullScreen(false);

        primeryStage.show();

    }
}
