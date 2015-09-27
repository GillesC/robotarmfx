/**
 * Created by Gilles on 22-9-2015.
 */
public class HeadController extends Thread{
    private Head head = new Head();
    private Square square;
    private UserInterface UI;
    private HeadControllerOperation operation;

    public enum HeadControllerOperation{
        OPEN, CLOSE, ROTATE
    }

    public HeadController(Square square, UserInterface UI, HeadControllerOperation operation) {
        this.square = square;
        this.UI = UI;
        this.operation = operation;
    }

    @Override
    public void run() {
        switch (operation){
            case OPEN: open();
                break;
            case CLOSE: close();
                break;
            case ROTATE: rotate();
                break;
        }
    }

    private void rotate() {
        head.rotate(30);
        UI.notifyHeadChange(RobotHeadStatus.ROTATED);
    }

    public void open(){
        head.changeStatus(RobotHeadStatus.OPEN);
        UI.notifyHeadChange(RobotHeadStatus.OPEN);
    }

    public void close(){
        head.changeStatus(RobotHeadStatus.CLOSED);
        UI.notifyHeadChange(RobotHeadStatus.CLOSED);
    }
}


