import java.util.ArrayList;

public class Square {
    private int size = 2;
    private Position currentPosition;
    private ArrayList<Position> earlierPositions = new ArrayList<>();

    public Square(int size){
        this.size = size;
        currentPosition = null;
    }

    public synchronized boolean isBetweenBorders(Arm arm){
        Position armPos = arm.getPosition();    // A
        double armLength = arm.getLength();
        int headRot = arm.getHead().getRotation();  //beta
        double headSize = arm.getHead().getSize();
        int openAngle = arm.getHead().getOpenAngel();   //omega

        double xPosLeftArm = armPos.getxPos() + armLength + headSize * Math.cos(headRot+openAngle);
        if(xPosLeftArm>size || xPosLeftArm<0) return false;

        double yPosLeftArm = armPos.getYPos() + armLength + headSize * Math.sin(headRot+openAngle);
        if(yPosLeftArm>size || yPosLeftArm<0) return false;

        double xPosRightArm = armPos.getxPos() + armLength + headSize * Math.cos(headRot-openAngle);
        if(xPosRightArm>size || xPosRightArm<0) return false;

        double yPosRightArm = armPos.getYPos() + armLength + headSize * Math.sin(headRot-openAngle);
        if(yPosRightArm>size || yPosRightArm<0) return false;

        if(armPos.getxPos()>size || armPos.getxPos()<0) return false;
        if(armPos.getYPos()>size || armPos.getYPos()<0) return false;

        return true;
    }

    /*
    public synchronized void addNewPosition(Position p){
        // vorige currentPosition opslaan
        earlierPositions.add(currentPosition);
        // nieuwe currentPos toewijzen
        currentPosition = p;
    }
    */
}
