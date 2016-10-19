package com.epam.bicyclerental.bean;

import com.epam.bicyclerental.bean.entity.Category;
import com.epam.bicyclerental.bean.entity.Product;

/**
 * Created by ASUS on 19.10.2016.
 */
public class Request {
    private String commandName;
    private Product product;

    public Request(){
        product = new Product();
        product.setCategory(new Category());
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public int getId() {
        return product.getId();
    }

    public void setId(int id) {
        product.setId(id);
    }

    public int getIdCategory() {
        return product.getCategory().getId();
    }

    public void setIdCategory(int CategoryId) {
        product.getCategory().setId(CategoryId);
    }

    public String getName() {
        return product.getName();
    }

    public void setName(String name) {
        product.setName(name);
    }

    public double getPrice() {
        return product.getPrice();
    }

    public void setPrice(double price) {
        product.setPrice(price);
    }

    public String getDescription() {
        return product.getDescription();
    }

    public void setDescription(String description) {
        product.setDescription(description);
    }
}
