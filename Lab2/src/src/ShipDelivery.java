package src;

import java.util.Date;

public class ShipDelivery extends InternationalDelivery {
    private ShipType shipType;

    public ShipDelivery(double price, Date startDate, Date endDate, String destination, String customerName,
                        Country sourceCountry, Country destinationCountry, ShipType shipType) {
        super(price, startDate, endDate, destination, customerName, sourceCountry, destinationCountry);
        this.shipType = shipType;
    }

    public ShipType getShipType() {
        return shipType;
    }

    @Override
    public String toString() {
        return "ShipDelivery{" +
                "shipType=" + shipType +
                '}';
    }
}
