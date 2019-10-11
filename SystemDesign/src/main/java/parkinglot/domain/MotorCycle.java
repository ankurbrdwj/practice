package parkinglot.domain;

public class MotorCycle extends Vehicle {
    public MotorCycle(String license, String color, VehicleType vehicleType, int spots,Driver driver) {
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
