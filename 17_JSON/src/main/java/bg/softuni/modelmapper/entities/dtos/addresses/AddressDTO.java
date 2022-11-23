package bg.softuni.modelmapper.entities.dtos.addresses;

import com.google.gson.annotations.Expose;

public class AddressDTO extends CreateAddressDTO {
    @Expose
    private long id;


    public AddressDTO() {
        super();
    }

    public AddressDTO(String country, String city) {
        super(country, city);
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
