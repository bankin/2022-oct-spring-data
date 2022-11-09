package bg.softuni.advancedqueries.services;

import bg.softuni.advancedqueries.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> selectByName(String name);

    List<Ingredient> selectByNames(List<String> names);

    void deleteByName(String name);

    void updatePrice();
}
