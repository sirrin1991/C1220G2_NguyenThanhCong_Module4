package com.example.additemtocart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> cart;

    public Cart() {
        this.cart = new HashMap<>();
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public void addToCart(Product product){
        if(cart.containsKey(product)){
            cart.replace(product,cart.get(product),cart.get(product)+1);
        }else {
            cart.put(product,1);
        }
    }

    public void changeQuantity(Product product,Integer quantity){
        cart.replace(product,cart.get(product),quantity);
    }

    public void removeProduct(Product product){
        cart.remove(product);
    }
    public Integer getQuantity(Product product){
        return cart.get(product);
    }

    public double getTotalCost(){
        double totalMoney=0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            totalMoney += entry.getKey().getPrice()*entry.getValue();
        }
        return totalMoney;
    }
}
