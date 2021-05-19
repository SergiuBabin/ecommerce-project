package md.SpringREST.ecommerce.dto;

import lombok.Data;
import md.SpringREST.ecommerce.entity.Address;
import md.SpringREST.ecommerce.entity.Customer;
import md.SpringREST.ecommerce.entity.Order;
import md.SpringREST.ecommerce.entity.OrderItem;

import java.util.Set;


/**
 * @author Babin Sergiu
 */

@Data
public class Purchase {

    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;

}
