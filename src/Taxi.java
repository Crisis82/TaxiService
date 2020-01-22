import Exception.InvalidSeats;

public class Taxi {
    private Code identification;
    private GuideType type;
    private int seats;
    private Position position;
    private boolean inService;

    /**
     * Constructor of a taxi
     * @param type guide type
     * @param seats number of seats
     * @throws InvalidSeats if the number of seats is not 4, 7, or 14
     */
    public Taxi(GuideType type, int seats) throws InvalidSeats{
        if(validSeats(seats)){
            identification = new Code();
            this.type = type;
            this.seats = seats;
            position = null;
            inService = false;
        }else{
            throw new InvalidSeats();
        }
    }

    /**
     * check if a number of seats is valid
     * @param toCheck number of seats to check
     * @return true if valid, false otherwhise
     */
    private boolean validSeats(int toCheck){
        if(toCheck==4 || toCheck==7 || toCheck==14){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @return identification code of the taxi
     */
    public Code getCode() {
        return identification;
    }

    /**
     * set the position of a taxi
     * @param position gps position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     *
     * @return actual position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * set the taxi booked and in service
     */
    public void setInService() {
        inService = true;
    }

    /**
     * check if is in service
     * @return true if in service, false otherwhise
     */
    public boolean isInService() {
        return inService;
    }
}
