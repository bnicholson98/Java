import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class EnemyFollowCircle extends Application {
    private static final int KEYBOARD_MOVEMENT_DELTA = 5;
    private static final Duration TRANSLATION_DURATION = Duration.seconds(0.25);

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Create circle (player)
        final Circle circle = new Circle(200,150,50, Color.BLUEVIOLET);
        circle.setOpacity(0.7);

        //Create circle (enemy)
        Circle enemy = new Circle(600, 400, 30, Color.RED);
        enemy.setFill(Color.RED);

        //Add shapes to group and define transitions
        final Group group = new Group(createInstructions(),circle, enemy);
        final TranslateTransition circleTransition = createTranslateTransition(circle);
        final TranslateTransition enemyTransition = createTranslateTransition(enemy);

        //Movements in scene
        final Scene scene = new Scene(group, 600, 400, Color.CORNSILK);
        moveCircleOnKeyPress(scene, circle);
        moveCircleOnMousePress(scene, circle, circleTransition);
        //Enemy follows circle when circle is moved by keys
        moveEnemyOnKeyPress(scene,circle,enemy, enemyTransition);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void moveEnemyOnKeyPress(Scene scene, Circle circle, Circle enemy, TranslateTransition transition) {
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transition.setToX(circle.getCenterX() - enemy.getCenterX());
                transition.setToY(circle.getCenterY() - enemy.getCenterY());
                transition.playFromStart();
            }
        });

    }

    private void moveCircleOnMousePress(Scene scene, Circle circle, TranslateTransition transition) {
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!event.isControlDown()){
                    circle.setCenterX(event.getSceneX());
                    circle.setCenterY(event.getSceneY());
                } else {
                    transition.setToX(event.getSceneX() - circle.getCenterX());
                    transition.setToY(event.getSceneY() - circle.getCenterY());
                    transition.playFromStart();
                }
            }
        });
    }

    private void moveCircleOnKeyPress(Scene scene, Circle circle) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case UP: circle.setCenterY(circle.getCenterY() - KEYBOARD_MOVEMENT_DELTA);break;
                    case RIGHT: circle.setCenterX(circle.getCenterX() + KEYBOARD_MOVEMENT_DELTA);break;
                    case DOWN: circle.setCenterY(circle.getCenterY() + KEYBOARD_MOVEMENT_DELTA);break;
                    case LEFT: circle.setCenterX(circle.getCenterX() - KEYBOARD_MOVEMENT_DELTA);break;
                }
            }
        });
    }

    private TranslateTransition createTranslateTransition(Circle circle) {

        final TranslateTransition transition = new TranslateTransition(TRANSLATION_DURATION,circle);
        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                circle.setCenterX(circle.getTranslateX() + circle.getCenterX());
                circle.setCenterY(circle.getTranslateY() + circle.getCenterY());
                circle.setTranslateX(0);
                circle.setTranslateY(0);
            }
        });
        return transition;
    }

    private Label createInstructions() {
        Label instructions = new Label(
                "      \"Use the arrow keys to move the circle in small increments\\n\" +\n" +
                        "      \"Click the mouse to move the circle to a given location\\n\" +\n" +
                        "      \"Ctrl + Click the mouse to slowly translate the circle to a given location\" "
        );
        instructions.setTextFill(Color.FORESTGREEN);
        return instructions;
    }

    public static void main(String[] args){
        launch(args);
    }
}
