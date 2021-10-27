import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameWindow extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 600,600, Color.ALICEBLUE);
        Rectangle enemy = new Rectangle(5,5,40,30);
        enemy.setFill(Color.RED);

        canvas.getChildren().add(enemy);

        primaryStage.setTitle("Game window");

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args){
        launch();
    }
}
