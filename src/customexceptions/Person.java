package customexceptions;

public class Person {

    private final String name;
    private int age;

    public final static int MIN_AGE = 0;
    public final static int MAX_AGE = 120;

    /**
     * Creates a new Person instance with name and age. Validates the age, throws an {@link ValueOutOfRangeException} if
     * age is less than MIN_AGE or more than MAX_AGE.
     *
     * @param name
     * @param age
     * @throws ValueOutOfRangeException if less than MIN_AGE or more than MAX_AGE
     */
    public Person(String name, int age) throws ValueOutOfRangeException {
        this.name = name;
        validateAge(age);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * Set a new age for the user. This method will throw an {@link ValueOutOfRangeException} if age is not in not in the
     * proper range, meaning: age > MIN_AGE and age < MAX_AGE.
     *
     * @param age - the age to set for this person.
     * @throws ValueOutOfRangeException thrown when age is less than MIN_AGE or greater than MAX_AGE.
     */
    public void setAge(int age) throws ValueOutOfRangeException {
        validateAge(age);
        this.age = age;
    }

    private void validateAge(int age) throws ValueOutOfRangeException {
        // This is where we want to validate the age. Not in main, because in the future we may want to receive the
        // age as a POST parameter, and if this method doesn't validate the age, we will have to rewrite the validation
        // again. We may have two POST controllers - one for HTML and one for REST, and then we may need to validate
        // twice. Instead, we validate here, and in main or in any POST controller we only manage the way to handle
        // the exception, if it is thrown.
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new ValueOutOfRangeException(age, MIN_AGE, MAX_AGE);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
