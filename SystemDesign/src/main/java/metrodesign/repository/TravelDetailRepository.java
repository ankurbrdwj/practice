package metrodesign.repository;

import metrodesign.domain.TravelCard;
import metrodesign.domain.TravelDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TravelDetailRepository {
    private ConcurrentMap<TravelCard, TravelDetails> transientTravels = new ConcurrentHashMap<>();
    private ConcurrentMap<TravelCard, List<TravelDetails>> completedTravels = new ConcurrentHashMap<>();

    public void addCompletedTravel(TravelCard card, TravelDetails trx) {
        completedTravels.putIfAbsent(card, new ArrayList<>());
        completedTravels.get(card).add(trx);
    }

    public void addTransientTravel(TravelCard card, TravelDetails trx) {
        transientTravels.put(card, trx);
    }

    public TravelDetails getTransientTravel(TravelCard card) {
        return transientTravels.remove(card);
    }

    public List<TravelDetails> getCompletedTravel(TravelCard card) {
        return completedTravels.getOrDefault(card, Collections.emptyList());
    }
}
