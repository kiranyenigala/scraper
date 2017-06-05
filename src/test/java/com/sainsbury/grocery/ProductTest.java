package com.sainsbury.grocery;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by YENIGALAK on 05/06/2017.
 */
public class ProductTest {

    private Product product;

    @Before
    public void setup() {
        product = new Product();
        product.setSize("40Kb");
        product.setTitle("Avocado");
        product.setUnitPrice(new BigDecimal("2.80"));
        product.setDescription("Description avocado");
    }

    @Test
    public void testSimpleSetter() {
        assertEquals(product.getSize(), "40Kb");
        assertEquals(product.getTitle(), "Avocado");
        assertEquals(product.getUnitPrice(), new BigDecimal("2.80"));
        assertEquals(product.getDescription(), "Description avocado");
    }


}