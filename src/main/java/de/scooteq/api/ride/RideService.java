package de.scooteq.api.ride;

import de.scooteq.api.model.Ride;
import de.scooteq.api.price.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RideService {
    private final RideRepository repository;
    private final PriceService priceService;

    public RideService(RideRepository repository, PriceService priceService) {
        this.repository = repository;
        this.priceService = priceService;
    }

    public Ride addRide(int duration) {
        double priceForRide = this.priceService.getCurrentPrice()*duration;
        return this.repository.save(Ride.builder().duration(duration).price(priceForRide).date(LocalDateTime.now()).build());
    }
}