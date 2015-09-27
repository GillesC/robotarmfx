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
public class Main extends Application{
    Stage window;

    public static void main(String[] args) {
        //int boardSize = Integer.parseInt(args[0]);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window= primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
        window.setTitle("Robotarm");

        /*HBox top = new HBox();
        Button openCloseButton = new Button("Open/Close");
        Button rotateButton = new Button("Rotate");

        top.getChildren().addAll(openCloseButton, rotateButton);

        HBox bottom = new HBox();
        Button leftButton = new Button("Left");
        Button rightButton = new Button("Right");
        Button upButton = new Button("Up");
        Button downButton = new Button("Down");

        bottom.getChildren().addAll(leftButton,rightButton, upButton, downButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(top);
        borderPane.setBottom(bottom);

        Scene scene = new Scene(borderPane);
        window.setScene(scene);*/
        window.setScene(new Scene(root));
        window.show();
    }
}
