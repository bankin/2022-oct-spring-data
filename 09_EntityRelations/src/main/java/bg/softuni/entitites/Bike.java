package bg.softuni.entitites;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Bike extends Vehicle {
    private static final String BIKE_TYPE = "BIKE";

    public Bike() {
        super(BIKE_TYPE);
    }


}
