/**
 * Created by Gilles on 22-9-2015.
 */
public class Head {
    private int rotationPos = 0; // rotation in degrees
    private RobotHeadStatus headStatus;

    public synchronized void rotate(int rotation){
        rotationPos+= rotation;
        rotationPos%=360;
    }

    public synchronized void changeStatus(RobotHeadStatus status){
        headStatus = status;
    }
}
