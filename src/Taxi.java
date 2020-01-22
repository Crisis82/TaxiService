import Exception.InvalidSeats;

public class Taxi {
    private Code identification;
    private GuideType type;
    private int seats;
    private Position position;
    private boolean inService;

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

    private boolean validSeats(int toCheck){
        if(toCheck==4 || toCheck==7 || toCheck==14){
            return true;
        }else{
            return false;
        }
    }

    public Code getCode() {
        return identification;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setInService() {
        inService = true;
    }

    public boolean isInService() {
        return inService;
    }
}
