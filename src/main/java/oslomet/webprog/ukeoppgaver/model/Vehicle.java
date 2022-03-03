package oslomet.webprog.ukeoppgaver.model;

public class Vehicle {
    private String ssn;
    private String name;
    private String address;
    private String characteristics;
    private String brand;
    private String type;

    public Vehicle(String ssn, String name, String address, String characteristics, String brand, String type) {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.characteristics = characteristics;
        this.brand = brand;
        this.type = type;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
