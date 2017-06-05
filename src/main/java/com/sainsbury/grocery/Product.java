package com.sainsbury.grocery;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Product class defines fields required for the product description and
 * product unit price.
 * @author YENIGALAK
 */
public class Product {

    /**
     * Product Title.
     */
    private String title;

    /**
     * Quantity of product.
     */
    private String size;

    /**
     * Product Description.
     */
    private String description;

    /**
     * Product unit price.
     */
    @JsonProperty("unit_price")
    private BigDecimal unitPrice;


    /**
     * Sets new Quantity of product..
     *
     * @param size New value of Quantity of product..
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Sets new Product Title..
     *
     * @param title New value of Product Title..
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets new Product unit price..
     *
     * @param unitPrice New value of Product unit price..
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Gets Product unit price..
     *
     * @return Value of Product unit price..
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Gets Product Description..
     *
     * @return Value of Product Description..
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets Quantity of product..
     *
     * @return Value of Quantity of product..
     */
    public String getSize() {
        return size;
    }

    /**
     * Gets Product Title..
     *
     * @return Value of Product Title..
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets new Product Description..
     *
     * @param description New value of Product Description..
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
