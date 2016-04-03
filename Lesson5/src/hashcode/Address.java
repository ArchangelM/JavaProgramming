package hashcode;

/**
 * Created by Osipov on 04.04.2016.
 */
public class Address {
    private String city;
    private String street;
    private int house;


    @Override
    public int hashCode() {
        final int basis = 37;
        int result = 41;

        if(city == null) {
            result = basis*result;
        } else {
            result = result*basis + city.hashCode();
        }

        if(street == null) {
            result = basis*result;
        } else {
            result = result*basis + street.hashCode();
        }

        result = result*basis + house;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && city != null && street != null) {
            if (obj instanceof Address) {
                Address adr = (Address)obj;
                if(city.equals(adr.getCity()) && street.equals(adr.getStreet()) && house == adr.getHouse()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Address(String city, String street, int house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public Address() {
        house = 7;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }
}
