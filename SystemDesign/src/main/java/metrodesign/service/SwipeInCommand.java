package metrodesign.service;


import metrodesign.domain.Station;
import metrodesign.domain.TravelDetails;

import java.time.LocalDateTime;

public class SwipeInCommand implements SwipeCommand {
    private TravelDetails travelDetails;
    private Station station;

    public SwipeInCommand(TravelDetails travelDetails, Station station) {
        this.travelDetails = travelDetails;
        this.station = station;
    }

/*
/ check Balance
set start station
set local date time
set FareStrategy
 basically initalize travel Details
 */
    @Override
    public void execute() throws Exception {
            System.out.println("#########  Travel card Swiped In  ######");
            if (travelDetails.getTravelCard().getBalance().intValue() < 50) {
                throw new Exception( "Amount below permissive limit .Please recharge!");
            }
            LocalDateTime startTime = LocalDateTime.now();
            travelDetails.setSource(station);
            travelDetails.setStartTime(startTime);
            Thread.sleep(2000);
            System.out.println("Card Balance = Rs. " + travelDetails.getTravelCard().getBalance() + ", Start Station = " + travelDetails.getSource() + ", DayOfYear = " + travelDetails.getStartTime());
            Thread.sleep(2000);
    }
}
