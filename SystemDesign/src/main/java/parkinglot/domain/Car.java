package parkinglot.domain;

public class Car extends Vehicle {
    public Car(String license, String color, VehicleType vehicleType, int spots,Driver driver) {
        this.color = color;
        this.licensePlate = license;
        this.vehicleType = vehicleType;
        this.spotsNeeded = spots;
        this.driver=driver;
    }

    @Override
    public boolean canFitinSpot(ParkingSpot spot) {
        return spot.getSize()==this.getSpotsNeeded();
    }
}
