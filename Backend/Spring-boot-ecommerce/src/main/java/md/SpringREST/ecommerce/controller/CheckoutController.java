package md.SpringREST.ecommerce.controller;

import md.SpringREST.ecommerce.dto.Purchase;
import md.SpringREST.ecommerce.dto.PurchaseResponse;
import md.SpringREST.ecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Babin Sergiu
 */

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    private CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
