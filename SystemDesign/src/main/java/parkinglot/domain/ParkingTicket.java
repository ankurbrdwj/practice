package parkinglot.domain;

import java.time.LocalDateTime;

public class ParkingTicket {
    String licensePlate;
    String color;
    LocalDateTime parkedSince;

    public ParkingTicket(String licensePlate, String color, LocalDateTime parkedSince) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.parkedSince = parkedSince;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getParkedSince() {
        return parkedSince;
    }

    public void setParkedSince(LocalDateTime parkedSince) {
        this.parkedSince = parkedSince;
    }
}
