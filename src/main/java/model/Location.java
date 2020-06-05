package model;

public class Location {
    private final String city;
    private final String country;
    private final Position position;

    Location(String city, String country, Position position) {
        this.city = city;
        this.country = country;
        this.position = position;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", position=" + position +
                '}';
    }
}

