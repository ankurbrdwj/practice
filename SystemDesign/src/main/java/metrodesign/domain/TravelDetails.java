package metrodesign.domain;

import metrodesign.service.FareStrategy;

import java.time.LocalDateTime;

public class TravelDetails {
    private long id;
    private TravelCard travelCard;
    private Station source;
    private Station destination;
    private double fare;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private FareStrategy fareStrategy;

    public TravelDetails() {
    }

    public TravelCard getTravelCard() {
        return travelCard;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTravelCard(TravelCard travelCard) {
        this.travelCard = travelCard;
    }

    public Station getSource() {
        return source;
    }

    public void setSource(Station source) {
        this.source = source;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public FareStrategy getFareStrategy() {
        return fareStrategy;
    }

    public void setFareStrategy(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }
}
