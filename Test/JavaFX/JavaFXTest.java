import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXTest extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    StackPane pane = new StackPane();
    Button button = new Button("Hello World!");

    pane.getChildren().addAll(button);

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(new Scene(pane));
    primaryStage.show();

    button.setOnAction(e -> {
      button.setText("Hello!");
    });
  }
}
