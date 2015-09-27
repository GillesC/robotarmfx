/**
 * Created by Gilles on 22-9-2015.
 */
public class UserInterface {
    private ArmController xArmController;
    private ArmController yArmController;
    private HeadController headController;

    public UserInterface(ArmController xArmController, ArmController yArmController, HeadController headController) {
        this.xArmController = xArmController;
        this.yArmController = yArmController;
        this.headController = headController;
    }

    public synchronized void notifyMove(Position position) {
        //TODO zet da in schoon figuurken
        System.out.println("Moved to "+position);
    }

    public synchronized void notifyHeadChange(RobotHeadStatus change) {
        //TODO zet da in schoon figuurken
        System.out.println(change.name());
    }
}
