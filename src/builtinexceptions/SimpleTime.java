
package builtinexceptions;

/**
 * a class to demonstrate throwing (built in) exception
 */
public class SimpleTime {

    private int hour;
    private int minute;
    private int second;

    private final static String ERROR_MESSAGE = "expected values: hours (0-23), minutes (0-59), seconds (0-59)";

    /**
     * creates a Time instance
     * @param h hours
     * @param m minutes
     * @param s seconds
     * @exception IllegalArgumentException in case the hour minutes or second are not in the correct range
     */
    public SimpleTime(int h, int m , int s) {
        validate(h,m,s);
        this.setTime(h,m,s);
    }

    /**
     * Sets the time of the clock.
     *
     * @param hour, minute, second The new time.
     * @exception IllegalArgumentException in case the hour minutes or second are not in the correct range
     */
    public void setTime(int hour, int minute, int second)  {
        validate(hour, minute, second);
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    }

    public int getHour() {
        return hour;
    }

    /**
     * Sets the hour of the clock.
     *
     * @param hour The new hour.
     * @exception IllegalArgumentException in case the hour is not in the correct range
     */
    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    /**
     * Sets the minute of the clock.
     *
     * @param minute The new minute.
     * @exception IllegalArgumentException in case the minute is not in the correct range
     */
    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    /**
     * Sets the second of the clock.
     *
     * @param second The new second.
     * @exception IllegalArgumentException in case the second is not in the correct range
     */
    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        this.second = second;
    }

    /**
     * Validates the hour, minute and second.
     *
     * @param h, m, s The hour, minute and second to validate.
     * @exception IllegalArgumentException in case the hour minutes or second are not in the correct range
     */
    private void validate(int h, int m, int s) {
        if (h < 0 || h > 23 || m < 0 || m > 59
                || s < 0 || s > 59) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
