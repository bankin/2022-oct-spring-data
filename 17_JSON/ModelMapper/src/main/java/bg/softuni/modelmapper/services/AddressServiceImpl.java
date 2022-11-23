package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.Address;
import bg.softuni.modelmapper.entities.dtos.addresses.AddressDTO;
import bg.softuni.modelmapper.entities.dtos.addresses.CreateAddressDTO;
import bg.softuni.modelmapper.repositories.AddressRepository;
import org.modelmapper.ModelMapper;

public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final ModelMapper mapper;

    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper mapper) {
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    @Override
    public AddressDTO create(CreateAddressDTO data) {
        Address address = mapper.map(data, Address.class);

        Address saved = this.addressRepository.save(address);

        return this.mapper.map(saved, AddressDTO.class);
    }
}
