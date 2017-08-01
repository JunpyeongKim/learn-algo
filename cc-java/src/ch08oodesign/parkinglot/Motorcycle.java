package ch08oodesign.parkinglot;

public class Motorcycle extends Vehicle {
    public Motorcycle() {
        size = VehicleSize.Motocycle;
        spotsNeeded = 1;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }

    @Override
    public void print() {
        System.out.print("M");
    }
}