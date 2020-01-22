import java.util.*;

import Exception.InvalidCode;

public class TaxiManagement {
    private List<Taxi> taxies;
    private int busy;
    private HashMap<Taxi, List<Date>> activity;

    public void addTaxi(Taxi toAdd) throws NullPointerException{
        if(toAdd!=null){
            taxies.add(toAdd);
        }else{
            throw new NullPointerException();
        }
    }

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
    }

    private int getMaxDay(int month, int year){
        Calendar calendar = null;
        calendar.set(year, month, 1);
        int maxDay = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
        return maxDay;
    }

    public List<Taxi> getMensility(int month, int year){
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

    public void report(){

    }
}
