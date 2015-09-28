/**
 * Created by Gilles on 22-9-2015.
 */
public class UserInterface {

    public UserInterface() {
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
