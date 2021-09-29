package src;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class DeliveryManager {
    private List<BaseDelivery> deliveries;

    public DeliveryManager(List<BaseDelivery> deliveries) {
        this.deliveries = deliveries;
    }

    public List<BaseDelivery> getDeliveries() {
        return deliveries;
    }

    public static class EndDateComparator implements Comparator<BaseDelivery> {
        @Override
        public int compare(BaseDelivery o1, BaseDelivery o2) {
            return o1.endDate.compareTo(o2.endDate);
        }
    }

    private class PriceComparator implements Comparator<BaseDelivery> {
        @Override
        public int compare(BaseDelivery o1, BaseDelivery o2) {
            return (int)(o1.price - o2.price);
        }
    }

    public List<BaseDelivery> findDeliveriesWithPriceInRange(double minPrice, double maxPrice) {
        return deliveries.stream().filter(d -> d.price >= minPrice && d.price <= maxPrice).toList();
    }

    private int daysBetweenDates(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public List<BaseDelivery> sortByEndDate(boolean isDescendingOrder) {
        deliveries.sort(new EndDateComparator());
        if (isDescendingOrder) {
            Collections.reverse(deliveries);
        }
        return deliveries;
    }

    public List<BaseDelivery> sortByPrice(boolean isDescendingOrder) {
        deliveries.sort(new PriceComparator());
        if (isDescendingOrder) {
            Collections.reverse(deliveries);
        }
        return deliveries;
    }

    public List<BaseDelivery> sortByDuration(boolean isDescendingOrder) {
        deliveries.sort(new Comparator<BaseDelivery>() {
            @Override
            public int compare(BaseDelivery o1, BaseDelivery o2) {
                return daysBetweenDates(o1.endDate, o1.startDate) - daysBetweenDates(o2.endDate, o2.startDate);
            }
        });
        if (isDescendingOrder) {
            Collections.reverse(deliveries);
        }
        return deliveries;
    }

    public List<BaseDelivery> sortByCustomerName(boolean isDescendingOrder) {
        deliveries.sort((o1, o2) -> o1.customerName.compareTo(o2.customerName));
        if (isDescendingOrder) {
            Collections.reverse(deliveries);
        }
        return deliveries;
    }
}
