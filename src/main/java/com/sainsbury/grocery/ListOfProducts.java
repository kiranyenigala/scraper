package com.sainsbury.grocery;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Product List.
 * @author YENIGALAK
 */
public class ListOfProducts {

    /**
     * List of products.
     */
    @JsonProperty("results")
    private List<Product> productList = new LinkedList<Product>();

    /**
     * Total price of all the products.
     */
    @JsonProperty("total")
    private BigDecimal totalPrice = new BigDecimal("0");

    public void addProduct(Product product) {
        productList.add(product);
        totalPrice = totalPrice.add(product.getUnitPrice());
    }


    /**
     * Gets Total price of all the products..
     *
     * @return Value of Total price of all the products..
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
