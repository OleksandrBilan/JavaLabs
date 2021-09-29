package src;

import java.util.Date;

public class PlaneDelivery extends InternationalDelivery {
    private boolean hasPassengers;

    public PlaneDelivery(double price, Date startDate, Date endDate, String destination, String customerName,
                         Country sourceCountry, Country destinationCountry, boolean hasPassengers) {
        super(price, startDate, endDate, destination, customerName, sourceCountry, destinationCountry);
        this.hasPassengers = hasPassengers;
    }

    public boolean hasPassengers() {
        return hasPassengers;
    }

    @Override
    public String toString() {
        return "AirDelivery{" +
                "hasPassengers=" + hasPassengers +
                '}';
    }
}
