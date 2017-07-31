package ch08oodesign; /**
 * 8.4 객체 지향 원칙에 따라 Parking lot을 설계하라.
 * --> 제공 기능: 사용자 가입/확장, 서적 검색, 읽기, 한명만/한권만 활성만
 * 
 * (6E)
 * 7.4 Parking Lot: Design a parking lot using object-oriented principles.
 */

/**
 * 주차장 기본 컨셉
 *  - ParkingLot은 총 5개의 층(Level)로 구성되어 있고,
 *  - 각 Level은 30개의 ParkingSpot(1/4개의 Large, 1/4개의 Bike, 나머지 Compact)이 Row당 10개씩의 ParkingSpot으로 이루어진 3개의 Row가 있다.
 *  - 각 Vehicle 용도로 할당된 스팟이 연속적으로 존재할 경우만 주차 가능으로 표시한다.
 *  - OODesing 원리에 따라 각각의 세부 기능(주차, 정보 프린트, 출차 등등)은 각 컴포넌트에게 Delegation 한다.
 * 
 * Custom 요소
 *  - Level 수, VehicleSize별/Row별 ParkingSpot 갯수 --> Row당 Spot 갯수에 따라 각 층당 Row 갯수가 정해진다.
 * 
 * 주차는 각 레벨에게 주차를 요청하고 레벨은 주차 가능한 스팟을 찾아 주차를 한다.
 *  - 가능 스팟 검색 : vehicle 의 사이즈와 필요한 스팟 갯수가 연속인 곳을 각 level 에서 검색
 *  - 주차 : 기본적으로 연속된 여러개의 스팟에 걸쳐서 주차되므로 각 스팟에 어떤 vehicle 가 주차되어 있는지 표시 + vehicle 은 어떤 스팟에 주차되어 있는지 정보를 가지고 있는다
 *  - 출차: vehicle 에서 스팟에게 출차를 요청하면 각 스팟은 레벨에게 가능한 스팟갯수를 늘려주고, 스팟에 등록된 vehicle 정보를 제거한다.
 */

// 3 types of vehicles
public enum VehicleSize {
    Motocycle,
    Compact,
    Large
}

public abstract class Vehicle {
    protected VehicleSize size;
    protected int spotsNeeded;
    protected ArrayList<ParkingSpots> parkingSpots = new ArrayList<ParkingSpot>();

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

public class Bus extends Vehicle {
    public Bus() {
        size = VehicleSize.Large;
        spotsNeeded = 5;
    }

    @Override
    public boolean canFitInSpoe(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large;
    }

    @Override
    public void print() {
        System.out.print("B");
    }
}

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

    public int getSize() {
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
            if (spotSize = VehicleSize.Compact) {
                System.out.print("c");
            } else if (spotSize = VehicleSize.Large) {
                System.out.print("l");
            } else if (spotSize = VehicleSize.Motocycle) {
                System.out.print("m");
            }
        } else {
            vehicle.print();
        }
    }
}

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
        int largeSpots = nubmerSpots / 4;
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
    private int findAvailableSpos(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded;
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
        availableSpot++;
    }
}

//--------------------------------------------------------------------------------
public class ParkingLot {
    private Level[] levels;
    private int numOfLevel;

    public ParkingLot(int numOfLevel) {
        this.numOfLevel = numOfLevel;
        levels = new Level[numOfLevel];

        for (int i = 0; i < numOfLevel; i++) {
            levels[i] = new Level(i, 30);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].parkVehicle(vehicle)) {
                return true;
            }
        }

        return false;
    }

    public void print() {
        for (int i = 0; i < levels.length; i++) {
            Sytem.out.print("Level" + i + ": ");
            level[i].print();
            System.out.println("");
        }
        System.out.println("");
    }
}