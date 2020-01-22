import java.util.Date;

/**
 * class to book a taxi
 */
public class Booking {
    private Date time;
    private Position start;
    private Position arrive;
    private int seats;

    /**
     * create a new booking
     * @param time
     * @param start
     * @param arrive
     * @param seats
     */
    public Booking(Date time, Position start, Position arrive, int seats) {
        this.time = time;
        this.start = start;
        this.arrive = arrive;
        this.seats = seats;
    }

    public Date getTime() {
        return time;
    }

    public Position getArrive() {
        return arrive;
    }

    public Position getStart() {
        return start;
    }
}
