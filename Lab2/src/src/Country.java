package src;

import java.util.List;

public class Country {
    private String name;
    private List<src.City> cities;

    public Country(String name, List<src.City> cities) {
        this.name = name;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public List<src.City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }
}
