package de.scooteq.api.price;

import de.scooteq.api.model.Price;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
public class PriceController {

    private final PriceService service;

    public PriceController(PriceService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Price addNewPrice(@RequestParam() double price) {
        return this.service.addPrice(price);
    }

    @GetMapping("/price")
    public double getCurrentPrice() {
        return this.service.getCurrentPrice();
    }
}