/**
 * Created by Gilles on 22-9-2015.
 */
public class Arm {
    private Position position = new Position(0,0);
    private double length;
    private Head head;

    public Arm(double length, Head head) {
        this.length = length;
        this.head = head;
    }

    public synchronized Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Head getHead() {
        return head;
    }

    public double getLength() {
        return length;
    }
}
