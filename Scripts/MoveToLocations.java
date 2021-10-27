import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MoveToLocations extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        TextField xInput = new TextField();
        xInput.setLayoutX(5);
        xInput.setLayoutY(5);

        TextField yInput = new TextField();
        yInput.setLayoutX(200);
        yInput.setLayoutY(5);

        Button button = new Button("Enter");
        button.setLayoutX(5);
        button.setLayoutY(50);


        Rectangle rectangle = new Rectangle(250, 100, 30, 20);
        rectangle.setFill(Color.RED);

        Group group = new Group(rectangle, xInput, yInput, button);


        TranslateTransition transition = createTranslateTransition(rectangle);

        Scene scene = new Scene(group, 600, 500, Color.WHITE);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                transition.setToX(Integer.parseInt(xInput.getText()) - rectangle.getX());
                transition.setToY(Integer.parseInt(yInput.getText()) - rectangle.getY());
                transition.playFromStart();
            }
        });

        moveRectangleOnMousePress(scene, rectangle, transition);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TranslateTransition createTranslateTransition(Rectangle rectangle) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.25), rectangle);
        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rectangle.setX(rectangle.getTranslateX() + rectangle.getX());
                rectangle.setY(rectangle.getTranslateY() + rectangle.getY());
                rectangle.setTranslateX(0);
                rectangle.setTranslateY(0);
            }
        });
        return transition;
    }

    private void moveRectangleOnMousePress(Scene scene, Rectangle rectangle, TranslateTransition transition) {
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transition.setToX(event.getSceneX() - rectangle.getX());
                transition.setToY(event.getSceneY() - rectangle.getY());
                transition.playFromStart();
            }
        });
    }

    public static void main(String[] args){
        launch(args);
    }
}
