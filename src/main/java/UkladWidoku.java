import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static java.awt.Color.WHITE;

public class UkladWidoku extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Layout

        //HBox Horyzontalny widok - po kolei od lewej do prawej
        Button menuButton = new Button("Menu");
        Button kontaktButton = new Button("Kontakt");
        Button zamowienieButton = new Button("Zamówienie");

        HBox hbox = new HBox();
//        hbox.getChildren().add(menuButton);
//        hbox.getChildren().add(kontaktButton);
//        hbox.getChildren().add(zamowienieButton);
        hbox.getChildren().addAll(menuButton, kontaktButton, zamowienieButton);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(5, 10, 5, 10));
        hbox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        //VBox - pionowo jeden pod drugim
        ImageView pizzaImageView = new ImageView(new Image("obrazki/ikony/pizza.png"));
        Label pizzaLabel = new Label("Pizza", pizzaImageView);
        ImageView hamburgerImageView = new ImageView(new Image("obrazki/ikony/hamburger.png"));
        Label hamburgerLabel = new Label("Hamburger", hamburgerImageView);
        ImageView napojeImageView = new ImageView(new Image("obrazki/ikony/napoje.png"));
        Label napojeLabel = new Label ("Napoje", napojeImageView);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(pizzaLabel, hamburgerLabel, napojeLabel);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));
        vbox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));




        // BorderPane
        BorderPane borderPane = new BorderPane();
//        TextField textFieldGora = new TextField("góra");
//        borderPane.setTop(textFieldGora);
//        TextField textFieldDol = new TextField("dół");
//        borderPane.setBottom(textFieldDol);
//        TextField textFieldSrodek = new TextField("środek");
//        borderPane.setCenter(textFieldSrodek);
//        TextField textFieldLewy = new TextField("lewy");
//        borderPane.setLeft(textFieldLewy);
//        TextField textFieldPrawy = new TextField("prawy");
//        borderPane.setRight(textFieldPrawy);
        borderPane.setTop(hbox);
        borderPane.setLeft(vbox);



        Scene scene = new Scene(borderPane, 800, 600);

        primaryStage.setX(2500);
        primaryStage.setY(300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Układ Elementów widoku");
        primaryStage.show();

    }
}
