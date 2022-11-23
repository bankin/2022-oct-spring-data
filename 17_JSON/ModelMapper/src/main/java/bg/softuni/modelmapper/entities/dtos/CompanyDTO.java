package bg.softuni.modelmapper.entities.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Set;

public class CompanyDTO {

    @Expose
    private String name;

    @Expose
    private Set<CreateEmployeeDTO> employees;

    public CompanyDTO(String name, Set<CreateEmployeeDTO> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CreateEmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<CreateEmployeeDTO> employees) {
        this.employees = employees;
    }
}
