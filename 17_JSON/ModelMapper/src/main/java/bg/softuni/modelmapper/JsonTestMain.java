package bg.softuni.modelmapper;

import bg.softuni.modelmapper.entities.dtos.addresses.CreateAddressDTO;
import bg.softuni.modelmapper.entities.dtos.CompanyDTO;
import bg.softuni.modelmapper.entities.dtos.CreateEmployeeDTO;
import com.google.gson.*;
import org.springframework.boot.CommandLineRunner;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//@Component
public class JsonTestMain implements CommandLineRunner {

    private final Scanner scanner;
    private final Gson gson;

    public JsonTestMain(Scanner scanner) {
        this.scanner = scanner;

        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("YYYY-MM-DD")
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
//                .setPrettyPrinting()
                .create();
    }

    static class LocalDateAdapter implements JsonSerializer<LocalDate> {

        public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
        }
    }

    @Override
    public void run(String... args) throws Exception {
        CreateAddressDTO address1 = new CreateAddressDTO("Bulgaria", "Burgas");
        CreateEmployeeDTO employee1 = new CreateEmployeeDTO(
                "First", "Last", BigDecimal.ONE, LocalDate.now(), address1
        );

        CreateAddressDTO address2 = new CreateAddressDTO("Bulgaria", "Varna");
        CreateEmployeeDTO employee2 = new CreateEmployeeDTO(
                "Second", "Last", BigDecimal.TEN, LocalDate.now(), address2
        );

        CreateAddressDTO address3 = new CreateAddressDTO("Bulgaria", "Ruse");
        CreateEmployeeDTO employee3 = new CreateEmployeeDTO(
                "Third", "Last", BigDecimal.ZERO, LocalDate.now(), address3
        );

        CompanyDTO mega = new CompanyDTO("Mega", Set.of(employee1, employee2, employee3));

        System.out.println(this.gson.toJson(mega));

        String input = this.scanner.nextLine();

        CompanyDTO parsed = this.gson.fromJson(input, CompanyDTO.class);

        Set<CreateEmployeeDTO> employees = parsed.getEmployees();

        for (CreateEmployeeDTO employee : employees) {
            System.out.println(employee.getAddress().getCity());
        }
    }

    private void test1() {
        CreateAddressDTO address1 = new CreateAddressDTO("Bulgaria", "Burgas");
        CreateAddressDTO address2 = new CreateAddressDTO("Bulgaria", "Varna");
        CreateAddressDTO address3 = new CreateAddressDTO("Bulgaria", "Ruse");

        CreateEmployeeDTO createEmployeeDTO = new CreateEmployeeDTO(
                "First", "Last", BigDecimal.ONE, LocalDate.now(), address1
        );

        String json = gson.toJson(createEmployeeDTO);
        System.out.println(json);

        List<CreateAddressDTO> addressList = List.of(address1, address2, address3);
        System.out.println(gson.toJson(addressList));


        String input = this.scanner.nextLine();

        CreateEmployeeDTO parsedDTO = gson.fromJson(input, CreateEmployeeDTO.class);
//        CreateEmployeeDTO[] list = gson.fromJson(input, CreateEmployeeDTO[].class);

        System.out.println();
    }
}
