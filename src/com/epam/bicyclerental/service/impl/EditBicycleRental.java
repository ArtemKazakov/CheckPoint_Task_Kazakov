package com.epam.bicyclerental.service.impl;

import com.epam.bicyclerental.bean.entity.Category;
import com.epam.bicyclerental.bean.entity.Product;
import com.epam.bicyclerental.constants.ExceptionConstant;
import com.epam.bicyclerental.dao.BRDao;
import com.epam.bicyclerental.dao.factory.DAOFactory;
import com.epam.bicyclerental.dao.exception.DAOException;
import com.epam.bicyclerental.service.EditBicycleRentalService;
import com.epam.bicyclerental.service.exception.ServiceException;

/**
 * Created by ASUS on 19.10.2016.
 */
public class EditBicycleRental implements EditBicycleRentalService {
    @Override
    public void addProduct(String name, double price, String description, int categoryId) throws ServiceException {
        if(!Validator.validateId(categoryId) || !Validator.validatePrice(price)
                || !Validator.validateString(name) || !Validator.validateString(description)){
            throw new ServiceException(ExceptionConstant.INVALID_INPUT_DATA);
        }

        DAOFactory factory = DAOFactory.getInstance();
        BRDao dao = factory.getNBDao();

        Product product = this.createProduct(name, price, description, categoryId);
        try {
            dao.addProduct(product);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionConstant.OPERATION_ERROR, e);
        }

    }

    @Override
    public void editProduct(int productId, String name, double price, String description, int categoryId) throws ServiceException {
        if(!Validator.validateId(categoryId) || !Validator.validatePrice(price) ||
                !Validator.validateString(name) || !Validator.validateString(description) ||
                !Validator.validateId(productId)){
            throw new ServiceException(ExceptionConstant.INVALID_INPUT_DATA);
        }

        DAOFactory factory = DAOFactory.getInstance();
        BRDao dao = factory.getNBDao();

        Product product = this.createProduct(name, price, description, categoryId);
        product.setId(productId);
        try {
            dao.updateProduct(product);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionConstant.OPERATION_ERROR, e);
        }
    }

    @Override
    public void deleteProduct(int productId) throws ServiceException {
        if(!Validator.validateId(productId)){
            throw new ServiceException(ExceptionConstant.INVALID_INPUT_DATA);
        }

        DAOFactory factory = DAOFactory.getInstance();
        BRDao dao = factory.getNBDao();

        Product product = new Product();
        product.setId(productId);
        try {
            dao.deleteProduct(product);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionConstant.OPERATION_ERROR, e);
        }
    }


    private Product createProduct(String name, double price, String description, int categoryId){
        Product product = new Product();
        Category Category = new Category();

        Category.setId(categoryId);
        product.setCategory(Category);
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);

        return product;
    }
}
