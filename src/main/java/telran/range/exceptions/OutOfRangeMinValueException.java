package telran.range.exceptions;

public class OutOfRangeMinValueException extends Exception{
    public OutOfRangeMinValueException(int min, int value){
        super(String.format("Out of Range min: %d, number: %d"));
    }
}
