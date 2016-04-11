package htree;

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


public class HTree extends Application {

    HTreePane treePane = new HTreePane();
    TextField tfOrder = new TextField();

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        tfOrder.setOnAction(event -> {
            treePane.setOrder(Integer.parseInt(tfOrder.getText()));
            tfOrder.setText("");
        });

        tfOrder.setPrefColumnCount(4);
        tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

        // Pane to hold label, text field, and a button
        HBox hBox = new HBox(10);
        Label label = new Label("Enter an order number: ");
        hBox.getChildren().addAll(label, tfOrder);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(treePane);
        borderPane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 500, 500);
        primaryStage.setTitle("H-Tree Fractal"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        scene.widthProperty().addListener(ov -> treePane.paint());
        scene.heightProperty().addListener(ov -> treePane.paint());
    }

    /**
     * Pane for displaying fractal
     */
    static class HTreePane extends Pane {

        double x = 500;
        double y = 500;
        private int orderNum = 0;

        HTreePane() {

        }

        /**
         * Set a new order
         */
        public void setOrder(int orderNum) {
            this.orderNum = orderNum;
            paint();
        }

        protected void paint() {
            this.getChildren().clear();
            // Top left point, bottom left point // Left side
            makeHTreeLines(orderNum, new Point2D(x / 4, y / 4), new Point2D(x / 4, y * .75));
            // Top right point, bottom right point // Right Side
            makeHTreeLines(orderNum, new Point2D(x * .75, y / 4), new Point2D(x * .75, y * .75));
            // Middle left, middle right // Middle
            makeHTreeLines(orderNum, new Point2D(x / 4, y / 2), new Point2D(x * .75, y / 2));
        }

        private void makeHTreeLines(int order, Point2D p1, Point2D p2) {
            if (order >= 0) {
                Line line = new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
                this.getChildren().add(line);
                // top left square	(200x200)
                makeHTreeLines(order - 1, new Point2D(p1.getX() / 2, p1.getY() / 2), new Point2D(p2.getX() / 2, p2.getY() / 2));
                // top right square (400x200)
                makeHTreeLines(order - 1, new Point2D(x / 2 + p1.getX() / 2, y * 0 + p1.getY() / 2), new Point2D(p2.getX() / 2 + x / 2, p2.getY() / 2));
                // bottom left square (200x400)
                makeHTreeLines(order - 1, new Point2D(p1.getX() / 2, y / 2 + p1.getY() / 2), new Point2D(p2.getX() / 2, y / 2 + p2.getY() / 2));
                // bottom right square (400x200)
                makeHTreeLines(order - 1, new Point2D(x / 2 + p1.getX() / 2, y / 2 + p1.getY() / 2), new Point2D(x / 2 + p2.getX() / 2, y / 2 + p2.getY() / 2));
            }
        }
    }
}