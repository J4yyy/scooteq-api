package de.scooteq.api.ride;

import de.scooteq.api.model.Ride;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ride")
public class RideController {
    private final RideService service;

    public RideController(RideService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Ride addRide(@RequestParam() int duration) {
        return this.service.addRide(duration);
    }
}