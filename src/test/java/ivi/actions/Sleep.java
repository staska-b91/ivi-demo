package ivi.actions;

/**
 * Метод реализует задержку на указанное количество мс
 */
public class Sleep {

    private final int millis;

    public Sleep(int millis) {
        this.millis = millis;
    }

    public void sleep() {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
