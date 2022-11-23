package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.dtos.addresses.AddressDTO;
import bg.softuni.modelmapper.entities.dtos.addresses.CreateAddressDTO;

public interface AddressService {
    AddressDTO create(CreateAddressDTO data);
}
