package src;

import java.util.Date;

public class SameCountryDelivery extends BaseDelivery {
    protected City sourceCity;
    protected City destinationCity;

    public SameCountryDelivery(double price, Date startDate, Date endDate, String destination, String customerName,
                               City sourceCity, City destinationCity) {
        super(price, startDate, endDate, destination, customerName);
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
    }

    public City getSourceCity() {
        return sourceCity;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    @Override
    public String toString() {
        return "SameCountryDelivery{" +
                "sourceCity=" + sourceCity +
                ", destinationCity=" + destinationCity +
                '}';
    }
}
