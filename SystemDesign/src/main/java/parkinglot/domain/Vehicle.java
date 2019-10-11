package parkinglot.domain;

import java.util.Objects;

public abstract class Vehicle {
    protected String licensePlate;
    protected String color;
    protected VehicleType vehicleType;
    protected int spotsNeeded;
    protected Driver driver;

    public abstract boolean canFitinSpot(ParkingSpot spot);

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public void setSpotsNeeded(int spotsNeeded) {
        this.spotsNeeded = spotsNeeded;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return getSpotsNeeded() == vehicle.getSpotsNeeded() &&
                getLicensePlate().equals(vehicle.getLicensePlate()) &&
                getVehicleType() == vehicle.getVehicleType() &&
                getColor().equals(vehicle.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(31, getLicensePlate(), getVehicleType(), getSpotsNeeded(),getColor());
    }
}
