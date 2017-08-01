package ch08oodesign.parkinglot;

// specific sopt for types
public class ParkingSpot {
    private Level level;
    private int row;
    private int spotNumber;
    private VehicleSize spotSize;

    private Vehicle vehicle;

    public ParkingSpot(Level lvl, int r, int n, VehicleSize sz) {
        level = lvl;
        row = r;
        spotNumber = n;
        spotSize = sz;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleSize getSize() {
        return spotSize;
    }

    public boolean park(Vehicle v) {
        if (!canFitVehicle(v)) {
            return false;
        }

        vehicle = v;
        vehicle.parkInSpot(this);
        return true;
    }

    public void removeVehicle() {
        level.spotFree();
        vehicle = null;
    }

    public void print() {
        if (vehicle == null) {
            if (spotSize == VehicleSize.Compact) {
                System.out.print("c");
            } else if (spotSize == VehicleSize.Large) {
                System.out.print("l");
            } else if (spotSize == VehicleSize.Motocycle) {
                System.out.print("m");
            }
        } else {
            vehicle.print();
        }
    }
}
