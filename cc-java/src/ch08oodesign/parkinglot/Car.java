package ch08oodesign.parkinglot;

public class Car extends Vehicle {
    public Car() {
        size = VehicleSize.Compact;
        spotsNeeded = 1;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Compact || spot.getSize() == VehicleSize.Large;
    }

    @Override
    public void print() {
        System.out.println("C");
    }
}
