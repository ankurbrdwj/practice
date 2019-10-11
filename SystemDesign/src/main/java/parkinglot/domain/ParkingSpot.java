package parkinglot.domain;

import java.util.Objects;

public class ParkingSpot {
    private int levelId;
    private boolean available;
    private Vehicle vehicle;
    private int size;
    public boolean canParkVehicle(Vehicle vehicle){
        return false;
    }
    public boolean isAvailable(){
        return this.available;
    }
    public void setAvailable(boolean available){
        this.available=available;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return   isAvailable() == that.isAvailable() &&
                getSize() == that.getSize() &&
                getVehicle().equals(that.getVehicle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(31, isAvailable(), getVehicle(), getSize());
    }
}
