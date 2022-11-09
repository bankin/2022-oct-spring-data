package bg.softuni.modelmapper.entities.dtos;

public class AddressDTO {
    private String country;

    private String city;

    public AddressDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
