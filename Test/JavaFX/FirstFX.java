import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FirstFX extends Application {

  Circle circle = new Circle();
  boolean on = true;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    BorderPane borderPane = new BorderPane();
    Scene scene = new Scene(borderPane, 400, 400);

    circle.setRadius(50);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.BEIGE);

    Pane pane = new Pane();
//        circle.setCenterX(200);
//        circle.setCenterY(200);
    circle.centerXProperty().bind(pane.widthProperty().divide(2));
    circle.centerYProperty().bind(pane.heightProperty().divide(2));
    pane.getChildren().addAll(circle);

    Button button = new Button("Change color");
    borderPane.setCenter(circle);
    borderPane.setBottom(button);
    // Event Handler
    // Anonymous Inner Class
//        button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                circle.setFill(Color.AQUA);
//            }
//        });

    // Lambda
//        button.setOnAction(event -> {
//            if (on) {
//                circle.setFill(Color.AQUA);
//                on = false;
//            } else {
//                circle.setFill(Color.RED);
//                on = true;
//            }
//        });

    // Method resolution
    button.setOnAction(this::changeColor);

    primaryStage.setTitle("My First Java FX");
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public void changeColor(ActionEvent event) {
    if (on) {
      circle.setFill(Color.AQUA);
      on = false;
    } else {
      circle.setFill(Color.RED);
      on = true;
    }
  }
}
