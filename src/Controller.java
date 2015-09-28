import com.sun.istack.internal.Nullable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * Created by Gilles on 27-9-2015.
 */
public class Controller {
    @FXML
    private GridPane grid;

    public Controller() {
    }

    public void leftButtonClicked(){
        System.out.println("Left clicked");
        Main.moveLeft();
    }

    public void openCloseButtonClicked(ActionEvent actionEvent) {
        System.out.println("Open/Close clicked");
        Main.openClose();
    }


    @FXML
    public void rightButtonClicked(ActionEvent actionEvent) {
        System.out.println("Right clicked");
        Main.moveRight();
    }

    public void leftRotate(ActionEvent actionEvent){
        System.out.println("Left Rotate");
        Main.rotateLeft();
    }

    public void rightRotate(ActionEvent actionEvent){
        System.out.println("Right Rotate");
        Main.rotateRight();
    }

    public void upButtonClicked(ActionEvent actionEvent) {
        System.out.println("Up clicked");
        Main.moveUp();
    }

    public void downButtonClicked(ActionEvent actionEvent) {
        System.out.println("Down clicked");
        Main.moveDown();
    }

    /*
    private Node getNodeFromGrid(@Nullable GridPane grid, int col, int row){

        for(Node n: grid.getChildren()){
            if(GridPane.getColumnIndex(n) == col && GridPane.getRowIndex(n)==row){
                return n;
            }
        }
        return null;
    }
    */
}
