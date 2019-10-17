package FlightRecorder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.Objects;

public class Flight {

    private String flightNum;
    private String depLoc;
    private String arrLoc;
    private LocalDate validTill;
    private LocalTime flightTime;
    private double flightDuration;
    private BigDecimal fare;

    public Flight() {
    }

    public Flight(String flightNum, String depLoc, String arrLoc, LocalDate validTill, LocalTime flightTime, double flightDuration, BigDecimal fare) {
        this.flightNum = flightNum;
        this.depLoc = depLoc;
        this.arrLoc = arrLoc;
        this.validTill = validTill;
        this.flightTime = flightTime;
        this.flightDuration = flightDuration;
        this.fare = fare;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getDepLoc() {
        return depLoc;
    }

    public void setDepLoc(String depLoc) {
        this.depLoc = depLoc;
    }

    public String getArrLoc() {
        return arrLoc;
    }

    public void setArrLoc(String arrLoc) {
        this.arrLoc = arrLoc;
    }

    public LocalDate getValidTill() {
        return validTill;
    }

    public void setValidTill(LocalDate validTill) {
        this.validTill = validTill;
    }

    public LocalTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalTime flightTime) {
        this.flightTime = flightTime;
    }

    public double getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(double flightDuration) {
        this.flightDuration = flightDuration;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Double.compare(flight.getFlightDuration(), getFlightDuration()) == 0 &&
                Objects.equals(getFlightNum(), flight.getFlightNum()) &&
                Objects.equals(getDepLoc(), flight.getDepLoc()) &&
                Objects.equals(getArrLoc(), flight.getArrLoc()) &&
                Objects.equals(getValidTill(), flight.getValidTill()) &&
                Objects.equals(getFlightTime(), flight.getFlightTime()) &&
                Objects.equals(getFare(), flight.getFare());
    }

    @Override
    public int hashCode() {
        return Objects.hash(31, getFlightNum(), getDepLoc(), getArrLoc(), getValidTill(), getFlightTime(), getFlightDuration(), getFare());
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNum='" + flightNum + '\'' +
                ", depLoc='" + depLoc + '\'' +
                ", arrLoc='" + arrLoc + '\'' +
                ", validTill=" + validTill +
                ", flightTime=" + flightTime +
                ", flightDuration=" + flightDuration +
                ", fare=" + fare +
                '}';
    }

    public Comparator<Flight> getComparator() {
        return Comparator.comparing(Flight::getFlightNum)
                .thenComparing(Flight::getDepLoc)
                .thenComparing(Flight::getArrLoc)
                .thenComparing(Flight::getFare);
    }

}
