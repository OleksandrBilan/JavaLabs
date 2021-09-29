package src;

import java.util.Date;

public class CourierDelivery extends src.SameCountryDelivery {
    private String name;

    public CourierDelivery(double price, Date startDate, Date endDate, String destination, String customerName,
                           src.City sourceCity, src.City destinationCity, String name) {
        super(price, startDate, endDate, destination, customerName, sourceCity, destinationCity);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CourierDelivery{" +
                "name='" + name + '\'' +
                '}';
    }
}
