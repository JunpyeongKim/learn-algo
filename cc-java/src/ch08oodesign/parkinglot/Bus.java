package ch08oodesign.parkinglot;

public class Bus extends Vehicle {
    public Bus() {
        size = VehicleSize.Large;
        spotsNeeded = 5;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large;
    }

    @Override
    public void print() {
        System.out.print("B");
    }
}
