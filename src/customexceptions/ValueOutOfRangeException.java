package customexceptions;

public class ValueOutOfRangeException extends Exception {
    // the exception is expected to happen on runtime: when the user
    // enters the person's age. The compiler does not demand declaration of RuntimeException or it's descendants,
    // but we do not want the user to see our exceptions because it is very unpleasant. We will declare and catch
    // the exception wherever we will use it.


    public ValueOutOfRangeException(int value, int min, int max) {
        // The exception must provide useful debug information. In our case, we want to provide the bad value
        // and the min and max of the range it should have been in, so that a developer who has to debug this
        // exception will know exactly what went wrong. This information is not intended to be displayed to
        // users, it is intended only for developers!
        super(String.format("Value must be in range [%d,%d], received %d", min, max, value));
    }
}
