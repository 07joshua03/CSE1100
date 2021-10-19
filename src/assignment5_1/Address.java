package assignment5_1;

public class Address {

    private final String street;
    private final int number;
    private final String zipCode;
    private final String city;

    public Address(String street, int number, String zipCode, String city){
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String toString(){
        return street + "; " + number + "; " + zipCode + "; " + city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return number == address.number && zipCode.equals(address.zipCode);
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }
}
