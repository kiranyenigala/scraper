package com.sainsbury.grocery;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by YENIGALAK on 05/06/2017.
 */
public class ListOfProductsTest {

    private Product product;
    private ListOfProducts listOfProducts;

    @Before
    public void setup() {
        product = new Product();
        product.setSize("40Kb");
        product.setTitle("Avocado");
        product.setUnitPrice(new BigDecimal("2.80"));
        product.setDescription("Descrption avocado");
        listOfProducts = new ListOfProducts();
    }

    @Test
    public void testGetTotalPrice() {
        listOfProducts.addProduct(product);
        assertEquals(listOfProducts.getTotalPrice(), new BigDecimal("2.80"));
    }

    @Test
    public void testGetTotalPriceVariousProducts() {
        listOfProducts.addProduct(product);
        listOfProducts.addProduct(product);
        listOfProducts.addProduct(product);

        assertEquals(listOfProducts.getTotalPrice(), new BigDecimal("8.40"));
    }

    @Test
    public void testGetTotalPriceNoProducts() {
        assertEquals(listOfProducts.getTotalPrice(), new BigDecimal("0"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetTotalPriceAddNullProduct() {
        listOfProducts.addProduct(null);
    }

}