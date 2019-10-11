package parkinglot.service;

import org.junit.jupiter.api.Test;
import parkinglot.domain.*;
import parkinglot.sevice.ParkingService;
import parkinglot.sevice.PaymentService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotTest {

    @Test
    public void testParkingVehicle(){
        ParkingService service= new ParkingService();
        Driver driver=new Driver();
        Truck truck =new Truck("HR263245","White", VehicleType.TRUCK,5,driver);
        ParkingSpot spot =service.parkVehicle(truck);
        assertEquals(spot.getSize(),5);
    }

    @Test
    public void testParkingCharges() throws InterruptedException {
        ParkingService service= new ParkingService();
        Driver driver=new Driver();
        Truck truck =new Truck("HR263245","Red", VehicleType.TRUCK,5,driver);
        driver.setVehicle(truck);
        ParkingSpot spot =service.parkVehicle(truck);
        assertEquals(spot.getSize(),5);
        Thread.sleep(10000);
        BigDecimal amount = service.removeVehicle(truck);
        assertEquals(5,amount.intValue());
    }
}
