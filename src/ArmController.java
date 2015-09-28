public class ArmController extends Thread{
    private Arm arm;
    private Square square;
    private UserInterface UI;
    private ArmDirection direction;

    public ArmController(Square square, UserInterface UI, ArmDirection dir, Arm arm) {
        this.square = square;
        this.UI = UI;
        this.direction = dir;
        this.arm = arm;
    }

    @Override
    public void run() {
        try {
            while(true){
                    while(!Thread.currentThread().isInterrupted()){
                    move();
                        /*
                    try {Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    */
                }
           }
        } catch (ArmOutOfBoundException e) {
            e.printStackTrace();
            System.out.println("Out of bound, old position");
        }
    }

    public void move() throws ArmOutOfBoundException{
            Position position = arm.getPosition();
            Position oldPosition = new Position(arm.getPosition());

            switch (direction) {
                case X_DIRECTION_RIGHT:
                    position.incrPos(Position.PositionDirection.X_POS);
                    break;
                case X_DIRECTION_LEFT:
                    position.decrPos(Position.PositionDirection.X_POS);
                    break;
                case Y_DIRECTION_DOWN:
                    position.incrPos(Position.PositionDirection.Y_POS);
                    break;
                case Y_DIRECTION_UP:
                    position.decrPos(Position.PositionDirection.Y_POS);
                    break;
                default:
                    throw new IllegalArgumentException("Unkown direction argument");
            }

            // check if new position possible
            if (!square.isBetweenBorders(arm)) {
                arm.setPosition(oldPosition);
                throw new ArmOutOfBoundException("Position: " + position + " not reachable");
            }

            // notify UI of move
            UI.notifyMove(arm.getPosition());
    }

    public void setDirection(ArmDirection direction) {
        this.direction = direction;
    }

    public ArmDirection getDirection() {
        return direction;
    }
}
