package bg.softuni.entitites;

import jakarta.persistence.Basic;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PassengerVehicle extends Vehicle {
    @Basic
    protected int seats;

    public PassengerVehicle(String type) {
        super(type);
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
