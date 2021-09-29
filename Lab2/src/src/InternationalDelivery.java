package src;

import java.util.Date;

public class InternationalDelivery extends BaseDelivery {
    protected Country sourceCountry;
    protected Country destinationCountry;

    public InternationalDelivery(double price, Date startDate, Date endDate, String destination, String customerName,
                                 Country sourceCountry, Country destinationCountry) {
        super(price, startDate, endDate, destination, customerName);
        this.sourceCountry = sourceCountry;
        this.destinationCountry = destinationCountry;
    }

    public Country getSourceCountry() {
        return sourceCountry;
    }

    public Country getDestinationCountry() {
        return destinationCountry;
    }

    @Override
    public String toString() {
        return "SameCountryDelivery{" +
                "sourceCountry=" + sourceCountry +
                ", destinationCountry=" + destinationCountry +
                '}';
    }
}
