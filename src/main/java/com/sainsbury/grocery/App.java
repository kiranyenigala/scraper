package com.sainsbury.grocery;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sainsbury.grocery.converter.JavaObjectConverter;
import com.sainsbury.grocery.parser.URLParser;

import java.io.IOException;

/**
 * Main class used to invoke the product parsing.
 * @author YENIGALAK
 */
public class App 
{
    public static void main( String[] args )
    {
        String urlValue = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";
//        String urlValue = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true";

        if (args.length == 1) {
            urlValue = args[0];
        }

        try {
            URLParser parser = new URLParser();
            ListOfProducts listOfProducts = parser.parse(urlValue);
            JavaObjectConverter converter = new JavaObjectConverter();
            System.out.println(converter.convertAsString(listOfProducts));
        } catch (JsonProcessingException ex) {
            System.out.println("Error While converting java object to json string");
        } catch (IOException ex) {
            System.out.println("The given address '" + urlValue + "' is not valid.");
        }

    }
}
