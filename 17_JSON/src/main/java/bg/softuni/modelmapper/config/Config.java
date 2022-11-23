package bg.softuni.modelmapper.config;

import bg.softuni.modelmapper.repositories.AddressRepository;
import bg.softuni.modelmapper.services.AddressService;
import bg.softuni.modelmapper.services.AddressServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

import java.util.Scanner;

@Configuration
public class Config {

    @Bean
    public ModelMapper createModelMapper() {
        ModelMapper modelMapper = new ModelMapper();



        return modelMapper;
    }

    @Bean
    public Scanner createScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public AddressService createAddressService(AddressRepository repo, ModelMapper mapper) {
        return new AddressServiceImpl(repo, mapper);
    }

    @Bean
    public Gson createGson() {
        return new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    }
}
