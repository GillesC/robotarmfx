/**
 * Created by Gilles on 22-9-2015.
 */
public class Position {
    private int xPos=0;
    private int yPos=0;

    public Position(Position position) {
        xPos = position.getxPos();
        yPos = position.getYPos();
    }


    public enum PositionDirection{
        X_POS, Y_POS
    }

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int YPos) {
        this.yPos = YPos;
    }

    public synchronized void incrPos(PositionDirection dir) {
        switch(dir){
            case X_POS: xPos++; break;
            case Y_POS: yPos++; break;
            default: throw new IllegalArgumentException("Unkown direction argument");
        }
    }

    public synchronized void decrPos(PositionDirection dir) {
        switch(dir){
            case X_POS: xPos--; break;
            case Y_POS: yPos--; break;
            default: throw new IllegalArgumentException("Unkown direction argument");
        }
    }

    @Override
    public String toString() {
        return "("+xPos+","+yPos+")";
    }
}
