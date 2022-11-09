package bg.softuni.advancedqueries;


import bg.softuni.advancedqueries.entities.Ingredient;
import bg.softuni.advancedqueries.entities.Shampoo;
import bg.softuni.advancedqueries.services.IngredientService;
import bg.softuni.advancedqueries.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final ShampooService shampooService;

    private final IngredientService ingredientService;

    @Autowired
    public Main(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

//        String name = scanner.nextLine();

//        List<String> ingredients = new ArrayList<>();

//        while (!nextLine.isBlank()) {
//            ingredients.add(nextLine);
//
//            nextLine = scanner.nextLine();
//        }

//        for (Shampoo shampoo : this.shampooService.findWithIngredientCountLessThan(count)) {
//            System.out.println(shampoo);
//        }

//        for (Ingredient ingredient : this.ingredientService.selectByNames(ingredients)) {
//            System.out.println(ingredient);
//        }

//        System.out.println(this.shampooService.countWithPriceLowerThan(price));

        this.ingredientService.updatePrice();
    }
}
