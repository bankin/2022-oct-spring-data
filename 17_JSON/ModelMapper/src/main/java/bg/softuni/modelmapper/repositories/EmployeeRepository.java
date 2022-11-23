package bg.softuni.modelmapper.repositories;

import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.EmployeeNameAndSalaryDTO;
import bg.softuni.modelmapper.entities.dtos.EmployeeNamesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT new bg.softuni.modelmapper.entities.dtos.EmployeeNamesDTO(e.firstName, e.lastName)" +
            " FROM Employee AS e WHERE e.id = :id")
    EmployeeNamesDTO findNamesById(long id);

    EmployeeNameAndSalaryDTO findFirstNameAndSalaryById(long id);
}
