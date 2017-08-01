package ch08oodesign.parkinglot;

// which floor
public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private static final int SPOTS_IN_ROW = 10;
    private int availableSpots = 0;

    public Level(int floor, int numberSpots) {
        this.floor = floor;
        this.spots = new ParkingSpot[numberSpots];

        // custom
        int largeSpots = numberSpots / 4;
        int bikeSpots = numberSpots / 4;
        int compactSpots = numberSpots - largeSpots - bikeSpots;

        // spots allocated
        for (int i = 0; i < numberSpots; i++) {
            VehicleSize sz = VehicleSize.Motocycle;

            if (i < largeSpots) {
                sz = VehicleSize.Large;
            } else if (i < largeSpots + compactSpots) {
                sz = VehicleSize.Compact;
            }

            int row = i / SPOTS_IN_ROW;
            spots[i] = new ParkingSpot(this, row, i, sz);
        }

        availableSpots = numberSpots;
    }

    public int availableSpots() {
        return availableSpots;
    }

    //
    private int findAvailableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;

        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];

            if (lastRow != spot.getRow()) {
                spotsFound = 0;
                lastRow = spot.getRow();
            }

            if (spot.canFitVehicle(vehicle)) {
                spotsFound++;
            } else {
                spotsFound = 0;
            }

            if (spotsFound == spotsNeeded) {
                return i - (spotsNeeded - 1);
            }
        }

        return -1;
    }

    private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
        vehicle.clearSpots();
        boolean success = true;

        for (int i = spotNumber; i < spotNumber + vehicle.spotsNeeded; i++) {
            success &= spots[i].park(vehicle);
        }

        availableSpots -= vehicle.spotsNeeded;

        return success;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots() < vehicle.getSpotsNeeded()) {
            return false;
        }

        int spotNumber = findAvailableSpots(vehicle);
        if (spotNumber < 0) {
            return false;
        }

        return parkStartingAtSpot(spotNumber, vehicle);
    }

    public void print() {
        int lastRow = -1;

        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (spot.getRow() != lastRow) {
                System.out.print("   ");
                lastRow = spot.getRow();
            }
            spot.print();
        }
    }

    public void spotFree() {
        availableSpots++;
    }
}
