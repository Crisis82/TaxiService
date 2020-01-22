import java.util.*;

import Exception.InvalidCode;

/**
 * class for the management of taxies and the bookings
 */
public class TaxiManagement {
    private List<Taxi> taxies;
    private int busy;
    private HashMap<Taxi, List<Date>> activity;

    /**
     * add a taxi to the free ones
     * @param toAdd taxi to add
     * @throws NullPointerException if toAdd null
     */
    public void addTaxi(Taxi toAdd) throws NullPointerException{
        if(toAdd!=null){
            taxies.add(toAdd);
        }else{
            throw new NullPointerException();
        }
    }

    /**
     * remove a taxi from the list of free taxies
     * @param toRemove taxi to remove
     * @throws InvalidCode if the identification code of the taxi is not assigned to a taxi
     */
    public void removeTaxi(Code toRemove) throws InvalidCode{
        Code last = new Code();
        if(toRemove.isValid(last)) {
            for (Taxi taxi : taxies) {
                if (taxi.getCode().equals(toRemove)) {
                    taxies.remove(taxi);
                    break;
                }
            }
        }else{
            throw new InvalidCode();
        }
    }

    /**
     * check if there is at least a free taxi
     * @param myBooking booking requested
     * @return list of free taxi while requesting a cecrtain booking
     */
    public List<Taxi> avaliability(Booking myBooking){
        List<Taxi> avaliable = null;
        for (Taxi taxi:taxies) {
            if(taxi.getPosition().getDistance(myBooking.getStart())<=5 && busy<=70 && !taxi.isInService()){
                avaliable.add(taxi);
                break;
            }
        }
        return avaliable;
    }

    /**
     * set a taxi in service in a certain date
     * @param taxi taxi to set
     * @param date date given
     */
    public void setActivity(Taxi taxi, Date date) {
        List<Date> dates = null;
        if(activity.containsKey(taxi)){
            dates = activity.get(taxi);
            dates.add(date);
            activity.replace(taxi, dates);
        }else{
            dates.add(date);
            activity.put(taxi,dates);
        }

        taxi.setInService();
    }

    /**
     * get max number of days in a certain month
     * @param month month
     * @param year year
     * @return number of days
     */
    private int getMaxDay(int month, int year){
        Calendar calendar = null;
        calendar.set(year, month, 1);
        int maxDay = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
        return maxDay;
    }

    /**
     * create a monthly list of the prenotation of the taxies
     * @param month
     * @param year
     * @return list of taxies active during the specific month given
     */
    public List<Taxi> getMonthly(int month, int year){
        List<Taxi> actives = null;
        for(int i = 0; i<getMaxDay(month, year); i++){
            Date date = new Date(year, month, i);

            for (Map.Entry<Taxi, List<Date>> entries: activity.entrySet()) {
                if(entries.getValue().contains(date)){
                    actives.add(entries.getKey());
                }
            }
        }
        return actives;
    }

    /**
     * daily report
     * @param today date of today
     * @return report
     */
    public List<Taxi> dailyReport(Date today){
        List<Taxi> actives = null;

        for (Map.Entry<Taxi, List<Date>> entries: activity.entrySet()) {
            if(entries.getValue().contains(today)){
                actives.add(entries.getKey());
            }
        }

        return actives;
    }
}
