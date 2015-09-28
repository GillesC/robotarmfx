/**
 * Created by Gilles on 22-9-2015.
 */
public class HeadController extends Thread{
    private Head head;
    private Arm arm;
    private Square square;
    private UserInterface UI;
    private HeadControllerOperation operation;



    public enum HeadControllerOperation{
        OPEN, CLOSE,  ROTATE_LEFT, ROTATE_RIGHT
    }

    public HeadController(Square square, UserInterface UI, HeadControllerOperation operation, Arm arm) {
        this.square = square;
        this.UI = UI;
        this.operation = operation;
        this.head = arm.getHead();
        this.arm = arm;
    }

    @Override
    public void run() {

            while (true) {
                while(!Thread.currentThread().isInterrupted()) {
                switch (operation) {
                    case OPEN:
                        open();
                        break;
                    case CLOSE:
                        close();
                        break;
                    case ROTATE_LEFT:
                    case ROTATE_RIGHT:
                        try {
                            rotate();
                        } catch (ArmOutOfBoundException e) {
                            e.printStackTrace();
                        }
                        break;
                }

            }
        }
    }

    private void rotate() throws ArmOutOfBoundException {
        int rot = 0;
        switch (operation){
            case ROTATE_RIGHT: rot = +5; break;
            case ROTATE_LEFT: rot =-5; break;
        }
        head.rotate(rot);
        if(head.getRotation()>Head.MAX_ANGLE_ROTATION){
            // Stoppen max bereikt
            head.rotate(-rot);
            System.out.println("Max angle reached");
            Thread.currentThread().interrupt();
        }
        if(head.getRotation()<Head.MIN_ANGLE_ROTATION){
            head.rotate(-rot);
            System.out.println("Min angle reached");
            Thread.currentThread().interrupt();
        }
        if(!square.isBetweenBorders(arm)){
            head.rotate(-rot);
            throw new ArmOutOfBoundException("Rotation: " + head.getRotation() + " not reachable");
        }
        System.out.println(head.getRotation());
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

    public HeadControllerOperation getRotationDir() {
        return operation;
    }
}


