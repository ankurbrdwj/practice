package metrodesign.service;

import metrodesign.domain.Station;
import metrodesign.domain.TravelCard;
import metrodesign.domain.TravelDetails;
import metrodesign.repository.TravelDetailRepository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FareService {
    private ConcurrentMap<Station, AtomicInteger> footFall = new ConcurrentHashMap<>();
    TravelDetailRepository travelDetailRepository = new TravelDetailRepository();
    public TravelDetails cardSwipedIn(TravelDetails travelDetails, Station station) throws Exception {
        SwipeCommand command = new SwipeInCommand(travelDetails, station);
            command.execute();
        footFall.putIfAbsent(station, new AtomicInteger());
        footFall.get(station).incrementAndGet();
        travelDetailRepository.addTransientTravel(travelDetails.getTravelCard(),travelDetails);
        return travelDetails;
    }

    public TravelDetails cardSwipedOut(TravelDetails travelDetails, Station station) throws Exception {
        travelDetailRepository.getTransientTravel(travelDetails.getTravelCard());
        SwipeCommand command = new SwipeOutCommand(travelDetails,station);
            command.execute();
        footFall.putIfAbsent(station, new AtomicInteger());
        footFall.get(station).incrementAndGet();
        travelDetailRepository.addCompletedTravel(travelDetails.getTravelCard(),travelDetails);
        return travelDetails;
    }

    public int getTotalFootFall( Station a6) {
        return footFall.getOrDefault(a6, new AtomicInteger(0)).get();
    }

    public List<TravelDetails> getCardReport(TravelCard card2) {
        return travelDetailRepository.getCompletedTravel(card2);
    }
}
