package metrodesign.service;

import metrodesign.domain.Station;
import metrodesign.domain.TravelDetails;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class SwipeOutCommand implements SwipeCommand {
    private TravelDetails travelDetails;
    private Station station;

    public SwipeOutCommand(TravelDetails travelDetails, Station station) {
        this.travelDetails = travelDetails;
        this.station = station;
    }

    /*
/ update Balance
set end station
set end date time
set fare
 basically process travel Details
 */
    @Override
    public void execute() throws Exception {
            System.out.println("#########  Travel card Swiped Out ######");
            Thread.sleep(2000);
            travelDetails.setDestination(station);
            travelDetails.setEndTime(LocalDateTime.now());
            if (travelDetails.getEndTime().getDayOfWeek() == DayOfWeek.SATURDAY ||
                    travelDetails.getEndTime().getDayOfWeek() == DayOfWeek.SUNDAY) {
                travelDetails.setFareStrategy(new WeekendStrategy());
            } else {
                travelDetails.setFareStrategy(new WeekdayStrategy());
            }
            int start = Integer.parseInt(travelDetails.getSource().toString().split("")[1]);
            int end = Integer.parseInt(travelDetails.getDestination().toString().split("")[1]);
            int noOfStations = end - start;
            double fare =travelDetails.getFareStrategy().getFarePerStation() * noOfStations;
            travelDetails.setFare(fare);
            BigDecimal balance = BigDecimal.valueOf(travelDetails.getTravelCard().getBalance().doubleValue()-fare);
            travelDetails.getTravelCard().setBalance(balance);
            System.out.println("Card Balance = Rs. " + travelDetails.getTravelCard().getBalance() + ", End Station = " + travelDetails.getDestination() + ", DayOfYear = " + travelDetails.getEndTime());
            if (travelDetails.getTravelCard().getBalance().doubleValue() < fare) {
                throw new Exception( "Amount below fare calculated .Please recharge!");
            }
        Thread.sleep(2000);
    }
}
