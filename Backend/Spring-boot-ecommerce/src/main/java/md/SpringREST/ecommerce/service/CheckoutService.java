package md.SpringREST.ecommerce.service;

import md.SpringREST.ecommerce.dto.Purchase;
import md.SpringREST.ecommerce.dto.PurchaseResponse;

/**
 * @author Babin Sergiu
 */

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
