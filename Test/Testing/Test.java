package guessing_game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Test extends Application {

    final int WIDTH = 500;
    final int HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GamePane gp = new GamePane();
        Scene scene = new Scene(gp, WIDTH, HEIGHT);
        primaryStage.setTitle("Word Puzzle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        gp.requestFocus();
    }

    class GamePane extends Pane {

        String[] strings = {"pineapple", "pepperoni", "sausage", "bacon", "school", "university", "los angeles", "rosemead", "pasadena", "dumplings"};
        ArrayList<Character> usedLetters = new ArrayList<>();
        ArrayList<Character> wrongLetters = new ArrayList<>();

        int count = 0;
        boolean playing;

        GamePane() {
            this.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    // restart a game
                    init();
                } else if (event.getCode().isLetterKey()) {
                    // user entered a letter, please process the input
                    processInput(event.getText().charAt(0));
                    paint();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Invalid character!");
                    alert.setContentText("You have already entered this character. Please try another character.");
                    alert.showAndWait();
                }
            });
        }

        public boolean repeatGuess(char c) {
            c = Character.toUpperCase(c);
            for (char letter : usedLetters) {
                if (letter == c) {
                    return true;
                }
            }
            return false;
        }


        public void processInput(char ch) {
            System.out.println(ch);
        }

        public void init() {
            count = 0;
            this.getChildren().clear();
        }

        public void paint() {

            int x = 150;
            int y = 100 + count * 100;
            int radius = 50;

            this.getChildren().clear();

            Circle circle = new Circle();
            circle.setCenterX(x);
            circle.setCenterY(y);
            circle.setRadius(radius);
            circle.setStroke(Color.rgb(100, 250, 100));
            circle.setFill(Color.rgb(200, 10, 130));
            circle.centerXProperty().bind(this.widthProperty().divide(2));
            this.getChildren().addAll(circle);
            count++;
        }
    }
}
