package com.d288.ecommerce.services;



import com.d288.ecommerce.dao.CartItemRepository;
import com.d288.ecommerce.dao.CartRepository;
import com.d288.ecommerce.dao.CustomerRepository;
import com.d288.ecommerce.dao.ExcursionRepository;
import com.d288.ecommerce.entities.Cart;
import com.d288.ecommerce.entities.CartItem;
import com.d288.ecommerce.entities.Customer;
import com.d288.ecommerce.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;


@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private ExcursionRepository excursionRepository;
    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository,
                               ExcursionRepository excursionRepository, CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.excursionRepository = excursionRepository;
        this.cartItemRepository = cartItemRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        try {
            // Retrieve the cart
            Cart cart = purchase.getCart();

            // Generate an order tracking number
            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);

            // Populate the cart with cart items
            Set<CartItem> cartItems = purchase.getCartItems();
            cartItems.forEach(item -> item.setCart(cart));

            // Set the cart items to the cart
            cart.setCartItem(cartItems);

            // Set the customer to the cart
            Customer customer = purchase.getCustomer();
            cart.setCustomer(customer);

            // Set the status type to ordered
            cart.setStatus(StatusType.ordered);

            // Save customer and cart to database
            customerRepository.save(customer);
            cartRepository.save(cart);


            // Empty cart validation
            if (cartItems.isEmpty()) {
                throw new IllegalArgumentException("Cart is empty, cannot place order.");
            }

            // Return a response
            return new PurchaseResponse(orderTrackingNumber);

        } catch (Exception e) {
            // Return error response
            return new PurchaseResponse(e.getMessage());
        }
    }

    // Create a random order tracking number
    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}