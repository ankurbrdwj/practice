package metrodesign.service;

import metrodesign.domain.Station;
import metrodesign.domain.TravelCard;
import metrodesign.domain.TravelDetails;
import metrodesign.domain.Traveller;
import metrodesign.service.FareService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FareServiceTest {
    static FareService fareService;

    @BeforeAll
    public static void setUp() {
        fareService = new FareService();
    }

    @Test
    public void testSwipeIn() {
        Traveller traveller = new Traveller(101, "Ankur Bhardwaj");
        TravelCard card = new TravelCard(1000, new BigDecimal(10), traveller);
        TravelDetails travelDetails = new TravelDetails();
        travelDetails.setTravelCard(card);
        travelDetails.setId(1002);
        assertThrows(Exception.class, () -> fareService.cardSwipedIn(travelDetails, Station.A2));
    }

    @Test
    public void testSwipeOut() {
        Traveller traveller = new Traveller(101, "Ankur Bhardwaj");
        TravelCard card = new TravelCard(1000, new BigDecimal(10), traveller);
        TravelDetails travelDetails = new TravelDetails();
        travelDetails.setTravelCard(card);
        travelDetails.setId(1002);
        assertThrows(Exception.class, () -> fareService.cardSwipedOut(travelDetails, Station.A6));
    }

    @Test
    public void testBalanceUpdate() throws Exception {
        Traveller traveller = new Traveller(101, "Ankur Bhardwaj");
        TravelCard card = new TravelCard(1000, new BigDecimal(1000), traveller);
        TravelDetails travelDetails = new TravelDetails();
        travelDetails.setTravelCard(card);
        travelDetails.setId(1002);
        fareService.cardSwipedIn(travelDetails, Station.A2);
        fareService.cardSwipedOut(travelDetails, Station.A6);
        assertEquals(972, card.getBalance().doubleValue());
    }

    @Test
    void testFootFall() throws Exception {
        List<TravelDetails> details = new ArrayList<>();
        Traveller traveller = new Traveller(101, "Mr Bhardwaj");
        TravelCard card = new TravelCard(1000, new BigDecimal(1000), traveller);
        TravelDetails travelDetails = new TravelDetails();
        travelDetails.setTravelCard(card);
        travelDetails.setId(1002);
        details.add(fareService.cardSwipedIn(travelDetails, Station.A2));
        details.add(fareService.cardSwipedOut(travelDetails, Station.A6));
        Traveller traveller2 = new Traveller(103, "Mrs Bhardwaj");
        TravelCard card2 = new TravelCard(1003, new BigDecimal(500), traveller2);
        TravelDetails travelDetails2 = new TravelDetails();
        travelDetails2.setTravelCard(card2);
        travelDetails2.setId(1002);
        details.add(fareService.cardSwipedIn(travelDetails2, Station.A2));
        details.add(fareService.cardSwipedOut(travelDetails2, Station.A6));
        int footfall = fareService.getTotalFootFall(Station.A6);
        assertEquals(2, footfall);
        assertNotNull(fareService.getCardReport(card2));
    }
}
