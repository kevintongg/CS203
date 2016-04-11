//My partner is Cetric Tong

import javafx.application.Application;
import javafx.event.ActionEvent;
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

public class HTree_Chris extends Application {

    BorderPane bp = new BorderPane();
    TextField tf = new TextField();
    Pane pane = new Pane();

    int sceneL = 600;
    int sceneH = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hb = new HBox();
        hb.getChildren().addAll(new Label(" Please enter an order: "), tf);
        hb.setAlignment(Pos.CENTER);
        tf.setPrefColumnCount(4);
        tf.setAlignment(Pos.BOTTOM_CENTER);
        bp.setBottom(hb);

        tf.setOnAction(this::paint);
        Scene scene = new Scene(bp, sceneL, sceneH);
        primaryStage.setTitle("H Tree");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void paint(ActionEvent e) {
        int order = Integer.parseInt(tf.getText());
        pane.getChildren().clear();
        draw(order, 100, new Point2D(sceneL * .25, sceneH * .25), new Point2D(sceneL * .25, sceneH * .75));
        draw(order, 100, new Point2D(sceneL * .75, sceneH * .25), new Point2D(sceneL * .75, sceneH * .75));
        draw(order, 100, new Point2D(sceneL * .25, sceneH * .5), new Point2D(sceneL * .75, sceneH * .5));
        bp.setCenter(pane);

    }

    public void draw(int order, int size, Point2D p1, Point2D p2) {
        if (order > 0) {
            Line line = new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
            pane.getChildren().add(line);
            draw(order - 1, size - 10, new Point2D(p1.getX() * .5, p1.getY() * .5), new Point2D(p2.getX() * .5, p2.getY() * .5));
            draw(order - 1, size - 10, new Point2D(p1.getX() * .5 + sceneL * .5, p1.getY() * .5), new Point2D(p2.getX() * .5 + sceneL * .5, p2.getY() * .5));
            draw(order - 1, size - 10, new Point2D(p1.getX() * .5, p1.getY() * .5 + sceneH * .5), new Point2D(p2.getX() * .5, p2.getY() * .5 + sceneH * .5));
            draw(order - 1, size - 10, new Point2D(p1.getX() * .5 + sceneL * .5, p1.getY() * .5 + sceneH * .5), new Point2D(p2.getX() * .5 + sceneL * .5, p2.getY() * .5 + sceneH * .5));

        }
    }
}