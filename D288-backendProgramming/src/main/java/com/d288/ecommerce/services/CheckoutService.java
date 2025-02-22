package com.d288.ecommerce.services;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
