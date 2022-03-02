package customexceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("This main method will demonstrate the creation of a single Person object,");
        System.out.println("while handling possible exceptions.");

        String name = null;
        int age;
        Person person = null;
        Scanner scanner = new Scanner(System.in);

        while (person == null) {    // Will loop as long as person was not initialized (to something other than null)
            try {
                if (name == null) {
                    System.out.println("Enter person's name: ");
                    name = scanner.nextLine();
                }

                System.out.println("Enter person's age: ");
                age = scanner.nextInt();

                String s = scanner.nextLine();
                int i = Integer.parseInt(s);

                person = new Person(name, age); // If an exception is thrown, will not be initialized
            } catch (ValueOutOfRangeException e) {
                    System.out.printf("The age you have entered is illegal, please enter an age between %d to %d.%n",
                            Person.MIN_AGE, Person.MAX_AGE);
            } catch (InputMismatchException e) {
                System.out.println("Age must be an integer, please enter an integer. Digits only, please.");
            } catch (Exception e) { // other exceptions will be handled here
                System.out.println("Some unexpected input problem occured");
            } finally {
                // This 'finally' is not really necessary here, the call to nextLine() could happen after the try.
                // When is it necessary? if, for example, we had a return statement in the try block or in any of
                // the catch blocks but there was something we wanted to do on all cases (successful try, exception
                // caught) then we would need 'finally'.
                scanner.nextLine(); // We need to consume whatever caused the error to clear the input buffer.
            }
        }
        System.out.println(person);
    }
}
