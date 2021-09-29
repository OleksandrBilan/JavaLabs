package src;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    private static ArrayList<BaseDelivery> deliveries;

    public static void main(String[] args) {
        deliveries = new ArrayList<>();
        deliveries.add(new BaseDelivery(300, new Date(2021, 7, 7), new Date(2021, 7, 15), "Lviv", "Base"));
        deliveries.add(new InternationalDelivery(200, new Date(2021, 3, 7), new Date(2021, 4, 18), "USA", "International", Ukraine(), USA()));
        deliveries.add(new PlaneDelivery(150, new Date(2021, 5, 7), new Date(2021, 5, 9), "USA", "Plane", Ukraine(), USA(), true));
        deliveries.add(new ShipDelivery(600, new Date(2021, 7, 7), new Date(2021, 7, 19), "USA", "Ship", Ukraine(), USA(), ShipType.Big));
        deliveries.add(new SameCountryDelivery(777, new Date(2021, 3, 13), new Date(2021, 4, 20), "Kyiv", "SameCountry", new City("Lviv", "some time zone"), new City("Kyiv", "some time zone")));
        deliveries.add(new TruckDelivery(888, new Date(2021, 3, 13), new Date(2021, 4, 27), "Kyiv", "Truck", new City("Lviv", "some time zone"), new City("Kyiv", "some time zone"), 2));
        deliveries.add(new CarDelivery(333, new Date(2021, 3, 1), new Date(2021, 4, 3), "Kyiv", "Car", new City("Lviv", "some time zone"), new City("Lviv", "some time zone"), new City("Lviv", "some time zone")));
        deliveries.add(new CourierDelivery(700, new Date(2021, 3, 2), new Date(2021, 4, 5), "Kyiv", "Courier", new City("Lviv", "some time zone"), new City("Kyiv", "some time zone"), "some courier"));

        var deliveryManager = new DeliveryManager(deliveries);

        System.out.println("Deliveries with price 100-400:");
        deliveryManager.findDeliveriesWithPriceInRange(100, 400).forEach(d -> System.out.println(d.customerName + " - " + d.price));
        System.out.println();

        System.out.println("Deliveries sorted by end date:");
        deliveryManager.sortByEndDate(false).forEach(d -> System.out.println(d.customerName + " - " + d.endDate));
        System.out.println();

        System.out.println("Deliveries sorted by price:");
        deliveryManager.sortByPrice(true).forEach(d -> System.out.println(d.customerName + " - " + d.price));
        System.out.println();

        System.out.println("Deliveries sorted by duration:");
        deliveryManager.sortByDuration(false).forEach(d -> System.out.println(d.customerName + " - " + d.endDate + ", " + d.startDate));
        System.out.println();

        System.out.println("Deliveries sorted by customer's name:");
        deliveryManager.sortByCustomerName(true).forEach(d -> System.out.println(d.customerName));
        System.out.println();
    }

    private static Country USA() {
        var cities = new ArrayList<City>();
        cities.add(new City("Dallas", "some time zone"));
        cities.add(new City("Brooklyn", "some time zone"));
        cities.add(new City("New York", "some time zone"));

        return new Country("USA", cities);
    }

    private static Country Ukraine() {
        var cities = new ArrayList<City>();
        cities.add(new City("Lviv", "some time zone"));
        cities.add(new City("Kyiv", "some time zone"));
        cities.add(new City("Chmelnytskyi", "some time zone"));

        return new Country("Ukraine", cities);
    }
}
