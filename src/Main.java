import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Gilles on 27-9-2015.
 */
public class Main extends Application {
    Stage window;
    private static ArmController xThread, yThread;
    private static HeadController openCloseThread, rotateThread;
    private static Square square = new Square(2000000000);
    private static UserInterface UI = new UserInterface();
    private static Head head = new Head(2);
    private static Arm arm = new Arm(10, head);



    public static void main(String[] args) throws InterruptedException {
        //int boardSize = Integer.parseInt(args[0]);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
        window.setTitle("Robotarm");
        window.setScene(new Scene(root));
        window.show();
    }

    public static void moveLeft() {
        if (xThread != null && xThread.getDirection() != ArmDirection.X_DIRECTION_LEFT) {
            xThread.interrupt();
        }
        xThread = new ArmController(square, UI, ArmDirection.X_DIRECTION_LEFT, arm);
        xThread.start();
    }

    public static void openClose() {
        if(openCloseThread!=null) {
            openCloseThread.interrupt();
            // kijken welke head status, en dan togglen
            RobotHeadStatus prevStatus = head.getHeadStatus();

            switch (prevStatus){
                case OPEN: openCloseThread = new HeadController(square, UI, HeadController.HeadControllerOperation.OPEN, arm);
                    break;
                case CLOSED: openCloseThread = new HeadController(square, UI, HeadController.HeadControllerOperation.CLOSE, arm);
            }
        }else{
            openCloseThread = new HeadController(square, UI, HeadController.HeadControllerOperation.CLOSE, arm);
        }
        openCloseThread.start();
    }

    public static void rotateRight() {
        if (rotateThread != null && rotateThread.getRotationDir() != HeadController.HeadControllerOperation.ROTATE_RIGHT) {
            rotateThread.interrupt();
        }
        rotateThread = new HeadController(square,UI,HeadController.HeadControllerOperation.ROTATE_RIGHT,arm);
        rotateThread.start();
    }

    public static void rotateLeft() {
        if (rotateThread != null && rotateThread.getRotationDir() != HeadController.HeadControllerOperation.ROTATE_LEFT) {
            rotateThread.interrupt();
        }
        rotateThread = new HeadController(square,UI,HeadController.HeadControllerOperation.ROTATE_LEFT,arm);
        rotateThread.start();
    }

    public static void moveRight() {
        if (xThread != null && xThread.getDirection() != ArmDirection.X_DIRECTION_RIGHT) {
            xThread.interrupt();
        }
        xThread = new ArmController(square, UI, ArmDirection.X_DIRECTION_RIGHT, arm);
        xThread.start();

    }

    public static void moveUp() {
        if (yThread != null && yThread.getDirection() != ArmDirection.Y_DIRECTION_UP) {
            yThread.interrupt();
        }
        yThread = new ArmController(square, UI, ArmDirection.Y_DIRECTION_UP, arm);
        yThread.start();
    }

    public static void moveDown() {
        if (yThread != null && yThread.getDirection() != ArmDirection.Y_DIRECTION_DOWN) {
            yThread.interrupt();
        }
        yThread = new ArmController(square, UI, ArmDirection.Y_DIRECTION_DOWN, arm);
        yThread.start();
    }
}
