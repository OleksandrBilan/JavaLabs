package src;

import java.util.Date;

public class CarDelivery extends src.SameCountryDelivery {
    private src.City workingCity;

    public CarDelivery(double price, Date startDate, Date endDate, String destination, String customerName,
                       src.City sourceCity, src.City destinationCity, src.City workingCity) {
        super(price, startDate, endDate, destination, customerName, sourceCity, destinationCity);
        this.workingCity = workingCity;
    }
}
