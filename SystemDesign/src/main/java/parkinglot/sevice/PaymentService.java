package parkinglot.sevice;

import parkinglot.domain.ParkingTicket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentService {
    private static final double RATEPERSEC = .50;
    public BigDecimal calculateParkingCharges(ParkingTicket ticket){
        int duration = LocalDateTime.now().getSecond()-ticket.getParkedSince().getSecond();
        return new BigDecimal(RATEPERSEC*duration);
    }
}
