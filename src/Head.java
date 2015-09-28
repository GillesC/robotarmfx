/**
 * Created by Gilles on 22-9-2015.
 */
public class Head {
    private int rotationPos = 0; // rotation in degrees
    private RobotHeadStatus headStatus = RobotHeadStatus.OPEN;
    private double size;
    private int openAngle = 90;
    public static final int MAX_ANGLE_OPEN = 90;   //omega
    public static final int MAX_ANGLE_ROTATION = 90, MIN_ANGLE_ROTATION = -90; //beta
    private int openAngel;



    public Head(double size) {
        this.size = size; // lengte van een been van een gelijkbenige driehoek
    }

    public synchronized void rotate(int rotation) throws ArmOutOfBoundException {
        rotationPos += rotation;
    }

    public synchronized RobotHeadStatus getHeadStatus() {
        return headStatus;
    }

    public synchronized void changeStatus(RobotHeadStatus status){
        headStatus = status;
    }

    public int getRotation() {
        return rotationPos;
    }

    public double getSize() {
        return size;
    }

    public int getOpenAngel() {
        return openAngel;
    }

    public void setRotation(int rotation) {
        this.rotationPos = rotationPos;
    }
}
