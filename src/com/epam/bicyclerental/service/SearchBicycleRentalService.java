package com.epam.bicyclerental.service;


import com.epam.bicyclerental.bean.entity.Product;
import com.epam.bicyclerental.bean.entity.ReportNode;
import com.epam.bicyclerental.service.exception.ServiceException;

import java.util.List;

/**
 * Created by ASUS on 19.10.2016.
 */
public interface SearchBicycleRentalService {

    List<Product> searchAllProducts() throws ServiceException;
    List<Product> searchProductByCategory(int categoryId) throws ServiceException;
    List<ReportNode> makeReport() throws ServiceException;
}
