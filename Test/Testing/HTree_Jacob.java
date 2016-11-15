import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HTree_Jacob extends Application {

  /**
   * The main method is only needed for the IDE with limited JavaFX support.
   * Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    HTreePane treePane = new HTreePane();
    TextField tfOrder = new TextField();
    tfOrder.setOnAction(e -> treePane.setOrder(Integer.parseInt(tfOrder.getText())));
    tfOrder.setPrefColumnCount(4);
    tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

    // Pane to hold label, text field, and a button
    HBox hBox = new HBox(10);
    hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
    hBox.setAlignment(Pos.CENTER);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(treePane);
    borderPane.setBottom(hBox);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 400, 410);
    primaryStage.setTitle("HTree"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    scene.widthProperty().addListener(ov -> treePane.paint());
    scene.heightProperty().addListener(ov -> treePane.paint());
  }

  /**
   * Pane for displaying fractal
   */
  static class HTreePane extends Pane {
    private int order = 0;

    HTreePane() {
    }

    /**
     * Set a new order
     */
    public void setOrder(int order) {
      this.order = order;
      paint();
    }

    protected void paint() {
      this.getChildren().clear();
      // using unit 1 as 1/3 of width
      displayHTree(order, this.getWidth() / 3, new Point2D(this.getWidth() / 2, this.getHeight() / 2));
    }

    private void displayHTree(int order, double side, Point2D p) {

      double x = p.getX();
      double y = p.getY();

      // middle
      Point2D pm1 = new Point2D(x - side / 2, y);
      Point2D pm2 = new Point2D(x + side / 2, y);

      // left line
      Point2D pl1 = new Point2D(x - side / 2, y - side / 2);
      Point2D pl2 = new Point2D(x - side / 2, y + side / 2);

      // right line
      Point2D pr1 = new Point2D(x + side / 2, y - side / 2);
      Point2D pr2 = new Point2D(x + side / 2, y + side / 2);

      // Homework 2: Please implement the rest of method
      if (order == 0) {
        Line line = new Line(x - side / 2, y, x + side / 2, y);
        Line line2 = new Line(x - side / 2, y - side / 2, x - side / 2,
            y + side / 2);
        Line line3 = new Line(x + side / 2, y - side / 2, x + side / 2,
            y + side / 2);
        this.getChildren().add(line);
        this.getChildren().add(line2);
        this.getChildren().add(line3);

      } else {
        Line line = new Line(x - side / 2, y,
            x + side / 2, y);
        Line line2 = new Line(x - side / 2, y - side / 2, x - side / 2,
            y + side / 2);
        Line line3 = new Line(x + side / 2, y - side / 2, x + side / 2,
            y + side / 2);
        this.getChildren().add(line);
        this.getChildren().add(line2);
        this.getChildren().add(line3);
        displayHTree(order - 1, side / 2, pr1);
        displayHTree(order - 1, side / 2, pr2);
        displayHTree(order - 1, side / 2, pl1);
        displayHTree(order - 1, side / 2, pl2);

      }

    }

  }
}
