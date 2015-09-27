import java.util.ArrayList;

public class Square {
    private int size = 2;
    private Position currentPosition;
    private ArrayList<Position> earlierPositions = new ArrayList<>();

    public Square(int size){
        this.size = size;
        currentPosition = null;
    }

    public synchronized boolean isBetweenBorders(Position p){
        return (p.getxPos() <= size && p.getYPos() <= size);
    }

    public synchronized void addNewPosition(Position p){
        // vorige currentPosition opslaan
        earlierPositions.add(currentPosition);
        // nieuwe currentPos toewijzen
        currentPosition = p;
    }
}
