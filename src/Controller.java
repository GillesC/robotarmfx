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
        System.out.println("Left!");
    }

    public void openCloseButtonClicked(ActionEvent actionEvent) {
    }

    public void rotateButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void rightButtonClicked(ActionEvent actionEvent) {
        getNodeFromGrid(grid,0,0).setStyle("background-color: yellow;");
    }

    public void upButtonClicked(ActionEvent actionEvent) {
    }

    public void downButtonClicked(ActionEvent actionEvent) {

    }

    private Node getNodeFromGrid(@Nullable GridPane grid, int col, int row){
        for(Node n: grid.getChildren()){
            if(GridPane.getColumnIndex(n) == col && GridPane.getRowIndex(n)==row){
                return n;
            }
        }
        return null;
    }
}
