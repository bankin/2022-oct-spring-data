package bg.softuni.entitites;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Plane extends Vehicle {
    private static final String PLANE_TYPE = "PLANE";
    @Basic
    private int passengerCapacity;

    public Plane() {
        super(PLANE_TYPE);
    }

    public Plane(String model, String fuelType, int passengerCapacity) {
        this();

        this.model = model;
        this.fuelType = fuelType;
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
