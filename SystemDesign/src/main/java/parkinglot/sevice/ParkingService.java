package parkinglot.sevice;

import parkinglot.domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingService {
    int[] levels = new int[5];
    private static final int TOTAL_CAPACITY=50;
    static Deque<ParkingSpot> parkingSpots = new ArrayDeque<>();
    static{
        for (int i=0;i<TOTAL_CAPACITY;i++) {
            parkingSpots.push(new ParkingSpot());
        }
    }
    static HashMap<Vehicle,ParkingSpot> vehiclesParked = new HashMap<>();

    public BigDecimal removeVehicle(Vehicle vehicle){
        ParkingSpot spot = vehiclesParked.get(vehicle);
        PaymentService paymentService =new PaymentService();
        BigDecimal amount= paymentService.calculateParkingCharges(spot.getVehicle().getDriver().getParkingTicket());
        spot.setAvailable(true);
        parkingSpots.push(spot);
        vehiclesParked.remove(vehicle);
        return amount;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot nextSpot = getNextAvailableSpot(vehicle);
        nextSpot.setAvailable(false);
        Driver driver = vehicle.getDriver();
        ParkingTicket ticket=new ParkingTicket(vehicle.getLicensePlate(),vehicle.getColor(), LocalDateTime.now());
        driver.setParkingTicket(ticket);
        vehicle.setDriver(driver);
        nextSpot.setVehicle(vehicle);
        vehiclesParked.put(vehicle,nextSpot);
        return nextSpot;
    }

    private ParkingSpot getNextAvailableSpot(Vehicle vehicle) {
       ParkingSpot spot=  parkingSpots.pop();
       switch (vehicle.getVehicleType()){
           case MOTORCYCLE:
               spot.setSize(1);
               break;
           case CAR:
               spot.setSize(2);
               break;
           case TRUCK:
               spot.setSize(5);
               break;
           default:
               spot.setSize(1);
       }
       return spot;
    }
}
