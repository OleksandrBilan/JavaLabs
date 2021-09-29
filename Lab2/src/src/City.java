package src;

public class City {
    private String name;
    private String timeZone;

    public City(String name, String timeZone) {
        this.name = name;
        this.timeZone = timeZone;
    }

    public String getName() {
        return name;
    }

    public String getTimeZone() {
        return timeZone;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}
