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
        Label label = new Label("Enter an order: ");
        hBox.getChildren().addAll(label, tfOrder);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(treePane);
        borderPane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 400, 410);
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
            //using unit 1 as 1/3 of width
            displayHTree(order, this.getWidth(), new Point2D(0, 0));
        }

        private void displayHTree(int order, double side, Point2D p) {

            double x = p.getX();
            double y = p.getY();
            double side2 = side / 2;

            if (order > 0) {
                // Recursively display shoreline
                displayHTree(order - 1, side2, new Point2D(x + side2, y));
                displayHTree(order - 1, side2, new Point2D(x, y + side2));
            } else {
                //draw shoreline
                this.getChildren().add(new Line(x, y + side, x + side / 2, y + side));
                this.getChildren().add(new Line(x + side / 2, y + side, x + side / 2, y + side / 2));
                this.getChildren().add(new Line(x + side / 2, y + side / 2, x + side, y + side / 2));
                this.getChildren().add(new Line(x + side, y + side / 2, x + side, y));
            }

        }

    }
}