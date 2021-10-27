import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.animation.PathTransition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.Random;

public class RandomMovingRectangle extends Application {

    public static final int PANEL_WIDTH = 600;
    public static final int PANEL_HEIGHT = 600;

    Random ran = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception {

        int loc = ran.nextInt(600 - 300 + 1) + 300;

        Rectangle rect = new Rectangle(20, 20);

        Pane root = new Pane();

        root.getChildren().add(rect);

        Scene scene = new Scene(root, PANEL_WIDTH, PANEL_HEIGHT);


        PathTransition pathTransition = new PathTransition();
        Path path = new Path();

        path.getElements().add(new MoveTo(20, 20));
        path.getElements().add(new LineTo(loc, 600));

        pathTransition.setDuration(javafx.util.Duration.millis(4000));
        pathTransition.setPath(path);
        pathTransition.setNode(rect);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        //r1.requestFocus();
    }

    public static void main(String[] args){
        launch(args);
    }
}
