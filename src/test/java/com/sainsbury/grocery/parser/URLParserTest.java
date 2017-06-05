package com.sainsbury.grocery.parser;

import com.sainsbury.grocery.ListOfProducts;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by YENIGALAK on 05/06/2017.
 */
public class URLParserTest {

    private URLParser parser;

    @Before
    public void setup() {
        parser = new URLParser();
    }

    @Test
    public void testParse() throws Exception {
        String url = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";
        ListOfProducts productList = parser.parse(url);
        assertEquals(productList.getTotalPrice() , new BigDecimal("15.10"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullURLParse() throws Exception {
        ListOfProducts productList = parser.parse(null);
    }

}