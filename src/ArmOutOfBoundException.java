/**
 * Created by Gilles on 23-9-2015.
 */
public class ArmOutOfBoundException extends Exception{
    public ArmOutOfBoundException(String message) {
        super(message);
        Thread.currentThread().interrupt();

    }
}
