package com.epam.bicyclerental.dao;

import com.epam.bicyclerental.bean.entity.Category;
import com.epam.bicyclerental.bean.entity.Product;
import com.epam.bicyclerental.bean.entity.ReportNode;
import com.epam.bicyclerental.dao.exception.DAOException;

import java.util.List;

/**
 * Created by ASUS on 19.10.2016.
 */
public interface BicycleRentalDAO {
    void addProduct(Product product) throws DAOException;

    List<Product> findProductsByCategory(Category category) throws DAOException;

    void deleteProduct(Product product) throws DAOException;

    void updateProduct(Product product) throws DAOException;

    List<Product> findAllProducts() throws DAOException;

    List<ReportNode> makeReport() throws DAOException;

}
