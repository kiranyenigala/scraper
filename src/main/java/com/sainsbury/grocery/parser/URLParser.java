package com.sainsbury.grocery.parser;

import com.sainsbury.grocery.ListOfProducts;
import com.sainsbury.grocery.Product;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by YENIGALAK on 05/06/2017.
 */
public class URLParser {

    /**
     * Get the document and call parse products
     * @param url the url we want to analise
     * @return A productList
     * @throws IOException
     */
    public ListOfProducts parse(String url) throws IOException {
        ListOfProducts productList = new ListOfProducts();
        Document doc = Jsoup.connect(url).get();

        Elements elementsProduct = doc.select(".product");

        for (Element product: elementsProduct) {
            Product prod = parserProduct(product);
            productList.addProduct(prod);
        }

        return productList;

    }

    /**
     * Parse the document portion containing the product information
     * @param product An Element where the product information is located
     * @return a product with all the information filled
     * @throws IOException
     */
    private Product parserProduct(Element product) throws IOException {
        Product prod = new Product();

        Element price = product.select(".pricePerUnit").first();
        String priceText = price.text();
        priceText = priceText.replaceAll("&pound", "");
        priceText = priceText.replaceAll("/unit", "");
        prod.setUnitPrice(new BigDecimal(priceText));

        Element title = product.select(".productInfo h3 a").first();
        prod.setTitle(title.text());

        String url = title.attr("abs:href");
        parseSubPage(prod, url);
        return prod;
    }

    /**
     * Retrieve the information from the product page and parse it
     * @param prod The product we want to completed
     * @param url A string containing the url that we want to parse
     * @throws IOException
     */
    private void parseSubPage(Product prod, String url) throws IOException {
        Connection conn = Jsoup.connect(url);
        Connection.Response response = conn.execute();
        Document docElement = response.parse();

        String size = response.header("Content-Length") == null ? "Unknown" : (Integer.parseInt(response.header("Content-Length")) / 1024) + "kb";
        prod.setSize(size);

        Element descriptionElement = docElement.select("meta[name=description]").first();
        if (descriptionElement != null) {
            prod.setDescription(descriptionElement.attr("content"));
        }
    }
}
