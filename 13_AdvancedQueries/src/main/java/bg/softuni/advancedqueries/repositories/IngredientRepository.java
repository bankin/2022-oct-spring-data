package bg.softuni.advancedqueries.repositories;

import bg.softuni.advancedqueries.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByNameStartsWith(String name);

    List<Ingredient> findByNameInOrderByPrice(List<String> names);

    void deleteByName(String name);

    @Query("UPDATE Ingredient AS i " +
            "SET i.price = i.price * 1.10 ")
    @Modifying
    void updateAllPrice();

    @Query("DELETE FROM Ingredient AS i WHERE i.name = :name")
    @Modifying
    void deleteByName2(String name);
}
