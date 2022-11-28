import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        Font font = Font.font("Arial", FontWeight.BOLD, 16);
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
        imageView.setX(90);
        imageView.setY(10);
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

        // TextField

        TextField textField = new TextField();
        //textField.setText("tekst");
        textField.setPromptText("Wpisz email");
        textField.setPrefColumnCount(20);
        textField.setLayoutX(20);
        textField.setLayoutY(140);


        // PasswordField

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Wpisz hasło");
        passwordField.setPrefColumnCount(20);
        passwordField.setLayoutX(20);
        passwordField.setLayoutY(188);

        // TextArea
        TextArea textArea = new TextArea();
        textArea.setLayoutX(20);
        textArea.setLayoutY(220);
        textArea.setPromptText("Wpisz tekst na wiele linii");
        textArea.setMaxWidth(200);
        textArea.setMaxHeight(200);

        // CheckBox

        CheckBox checkBox = new CheckBox("Naciśnij mojego checkboxa");
        //checkBox.setText("Naciśnij mojego checkboxa");
        checkBox.setLayoutX(300);
        checkBox.setLayoutY(20);
        checkBox.setSelected(true);
        checkBox.isSelected();

        // RadioButton

        RadioButton radioButtonPierwszy = new RadioButton("Wybór pierwszy");
        radioButtonPierwszy.setLayoutX(300);
        radioButtonPierwszy.setLayoutY(50);
        //radioButtonPierwszy.setSelected(true);
        //radioButtonPierwszy.isSelected();

        RadioButton radioButtonDrugi = new RadioButton("Wybór drugi");
        radioButtonDrugi.setLayoutX(300);
        radioButtonDrugi.setLayoutY(70);

        ToggleGroup toggleGroup = new ToggleGroup();

        radioButtonPierwszy.setToggleGroup(toggleGroup);
        radioButtonDrugi.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton wybrany = (RadioButton) newValue;
                System.out.println("Wybrany: " + wybrany.getText());

            }
        });

        // ChoiceBox
        String[] listaWyborow = {"Pierwszy", "Drugi", "Trzeci", "Czwarty"};
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.setLayoutX(300);
        choiceBox.setLayoutY(100);
        choiceBox.getItems().addAll(listaWyborow);

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String wybor = listaWyborow[newValue.intValue()];
                System.out.println("Wybrany z choiceboxa: " + wybor);

            }
        });


        // ListView

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(listaWyborow);
        listView.setLayoutX(1000);
        listView.setLayoutX(600);
        listView.setMaxHeight(100);
        listView.setMaxWidth(200);

        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String wybranyElement = listaWyborow[newValue.intValue()];
                System.out.println("Wybrany z listView: " + wybranyElement);
            }
        });


        //ProgressBar

        ProgressBar progressBar = new ProgressBar();
        progressBar.setLayoutX(300);
        progressBar.setLayoutY(180);
        //progressBar.setProgress(0.5); = 50 % progresu


        //ProgressIndicator

        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setLayoutX(300);
        progressIndicator.setLayoutY(230);
        //progressIndicator.setProgress(0.5);

        //Slider

        Slider slider = new Slider(0, 100, 0);
        slider.setLayoutX(300);
        slider.setLayoutY(300);
        slider.setPrefWidth(300);

//        slider.setMin(0);
//        slider.setMax(100);
//        slider.setValue(0);

        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(25);
        slider.setMinorTickCount(4);
        slider.setSnapToTicks(true);

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("slider: " + newValue.intValue());

                if (newValue.intValue() == 100) {
                    progressBar.setVisible(false);
                    progressIndicator.setVisible(false);
                } else {
                    progressBar.setVisible(true);
                    progressIndicator.setVisible(true);
                    double valuePercent = newValue.doubleValue() / 100.0;
                    progressBar.setProgress(valuePercent);
                    progressIndicator.setProgress(valuePercent);
                }
            }
        });


        ///////////////////////////////////////////
        Group group = new Group();
        group.getChildren().add(label);
        group.getChildren().add(imageView);
        group.getChildren().add(button);
        group.getChildren().add(textField);
        group.getChildren().add(passwordField);
        group.getChildren().add(textArea);
        group.getChildren().add(checkBox);
        group.getChildren().add(radioButtonPierwszy);
        group.getChildren().add(radioButtonDrugi);
        group.getChildren().add(choiceBox);
        group.getChildren().add(listView);
        group.getChildren().add(progressBar);
        group.getChildren().add(progressIndicator);
        group.getChildren().add(slider);


        Scene scene = new Scene(group, 800, 600, Color.WHITE);

        primaryStage.setX(2500);
        primaryStage.setY(300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplikacja kontrolki");
        primaryStage.show();


    }
}
