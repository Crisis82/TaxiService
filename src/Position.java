import java.math.*;

/**
 * class for geogrphical positions
 */
public class Position {
    private Double latitude;
    private Double longitude;

    /**
     * Create a new position with my coordinates
     * @param myLatitude
     * @param myLongitude
     */
    public Position(Double myLatitude, Double myLongitude) {
        this.latitude = myLatitude;
        this.longitude = myLongitude;
    }

    /**
     *
     * @return my latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     *
     * @return my longitude
     */
    public Double getLongitude() {
        return longitude;
    }


    public int getDistance(Position myPosition){
        int distance = 0;
        distance += Math.abs(latitude - myPosition.getLatitude());
        distance += Math.abs(longitude - myPosition.getLongitude());
        return distance;
    }
}
