package customexceptions;

public class ValueOutOfRangeException extends Exception {
    // the exception is expected to happen on runtime: when the user
    // enters the person's age. The compiler does not demand declaration of RuntimeException or it's descendants,
    // but it DOES demand declaration for descendants of Exception
    // You can modify this class to extends RuntimeException to test also unchecked exceptions.

    // default ctor to pass the error message
    public ValueOutOfRangeException(String msg) {
        super(msg);
    }

    public ValueOutOfRangeException(int value, int min, int max) {
        // The exception must provide useful debug information. In our case, we want to provide the bad value
        // and the min and max of the range it should have been in, so that a developer who has to debug this
        // exception will know exactly what went wrong. This information is not intended to be displayed to
        // users, it is intended only for developers!
        super(String.format("Value must be in range [%d,%d], received %d", min, max, value));
    }
}
