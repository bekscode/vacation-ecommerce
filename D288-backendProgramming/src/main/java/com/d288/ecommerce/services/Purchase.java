package com.d288.ecommerce.services;

import com.d288.ecommerce.entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;
    private Set<CartItem> cartItems = new HashSet<>();
    private Cart cart;
    private Set<Excursion> excursions = new HashSet<>();

    public Customer getCustomer() {
        return customer;
    }

    // Generated getters and setters due to Lombok issue
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Set<Excursion> getExcursions() {
        return excursions;
    }

    public void setExcursions(Set<Excursion> excursions) {
        this.excursions = excursions;
    }
}

