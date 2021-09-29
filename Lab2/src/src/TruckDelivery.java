package src;

import java.util.Date;

public class TruckDelivery extends src.SameCountryDelivery {
    private int driversCount;

    public TruckDelivery(double price, Date startDate, Date endDate, String destination, String customerName,
                         src.City sourceCity, src.City destinationCity, int driversCount) {
        super(price, startDate, endDate, destination, customerName, sourceCity, destinationCity);
        this.driversCount = driversCount;
    }

    public int getDriversCount() {
        return driversCount;
    }

    @Override
    public String toString() {
        return "TruckDelivery{" +
                "driversCount=" + driversCount +
                '}';
    }
}
