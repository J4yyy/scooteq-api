package de.scooteq.api.price;

import de.scooteq.api.model.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

@Service
public class PriceService {
    private final PriceRepository repository;

    public PriceService(PriceRepository repository) {
        this.repository = repository;
    }

    public Price addPrice(double price) {
        return this.repository.save(Price.builder().price(price).date(LocalDateTime.now()).build());
    }

    public double getCurrentPrice() {
        if(this.repository.findAll().stream().min(Comparator.comparingLong(x -> ChronoUnit.DAYS.between(x.getDate(), LocalDateTime.now()))).isPresent()) {
            return this.repository.findAll().stream().min(Comparator.comparingLong(x -> ChronoUnit.DAYS.between(x.getDate(), LocalDateTime.now()))).get().getPrice();
        } else {
            return 0.0;
        }
    }
}