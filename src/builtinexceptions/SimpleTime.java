
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
        if (getHour() < 0 || getHour() > 23 || getMinute() < 0 || getMinute() > 59
                || getSecond() < 0 || getSecond() > 59) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        } else
            this.setTime(h,m,s);
    }

    /**
     * Sets the time of the clock.
     *
     * @param hour, minute, second The new time.
     * @exception IllegalArgumentException in case the hour minutes or second are not in the correct range
     */
    public void setTime(int hour, int minute, int second) throws IllegalArgumentException {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59
                || second < 0 || second > 59) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
