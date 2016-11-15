package hw3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MyWordGame extends Application {

  final int WIDTH = 500;
  final int HEIGHT = 650;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    BorderPane borderPane = new BorderPane();
    GamePane gp = new GamePane();
    HBox hBox = new HBox();
    Text text = new Text("Press ENTER to restart");
    TextField textField = new TextField();
    hBox.getChildren().addAll(text, textField);
    borderPane.setCenter(gp);
    borderPane.setBottom(hBox);
    Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
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
        usedLetters.add(event.getText().charAt(0));
        if (event.getCode() == KeyCode.ENTER) {
          // restart a game
          init();
        } else if (event.getCode().isLetterKey()) {
          // user entered a letter, please process the input
          processInput(event.getText().charAt(0));
          if (playedAlready(event.getText().charAt(0))) {
            for (int i = 0; i < usedLetters.size(); i++) {
              if (usedLetters.contains(event.getText().charAt(0))) {
                System.out.println("Sorry, you have used this character.");
                break;
              }
              break;
            }
          }
          paint();
        }
      });
    }

    public boolean playedAlready(char c) {

      for (int i = 0; i < usedLetters.size(); i++) {
        if (usedLetters.contains(c)) {
          System.out.println("Sorry, you have used this character.");
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
      TextField textField = new TextField();
      this.getChildren().add(textField);

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
