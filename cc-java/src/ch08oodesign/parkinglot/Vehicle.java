package ch08oodesign.parkinglot;


import java.util.ArrayList;

public abstract class Vehicle {
    protected VehicleSize size;
    protected int spotsNeeded;
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();

    public VehicleSize getSize() {
        return size;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    // park
    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    // unpark
    public void clearSpots() {
        for (int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.get(i).removeVehicle();
        }

        parkingSpots.clear();
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void print();
}
