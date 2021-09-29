package src;

import java.util.Date;

public class BaseDelivery {
    protected double price;
    protected Date startDate;
    protected Date endDate;
    protected String destination;
    protected String customerName;

    public BaseDelivery(double price, Date startDate, Date endDate, String destination, String customerName) {
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destination = destination;
        this.customerName = customerName;
    }

    public double getPrice() {
        return price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDestination() {
        return destination;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "BaseDelivery{" +
                "price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", destination='" + destination + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
