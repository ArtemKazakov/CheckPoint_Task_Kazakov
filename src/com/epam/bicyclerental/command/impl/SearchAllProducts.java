package com.epam.bicyclerental.command.impl;

import com.epam.bicyclerental.bean.Request;
import com.epam.bicyclerental.bean.Response;
import com.epam.bicyclerental.bean.entity.Product;
import com.epam.bicyclerental.command.Command;
import com.epam.bicyclerental.constants.MessageConstant;
import com.epam.bicyclerental.service.SearchBicycleRentalService;
import com.epam.bicyclerental.service.exception.ServiceException;
import com.epam.bicyclerental.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by ASUS on 19.10.2016.
 */
public class SearchAllProducts implements Command {// ну не именуются классы множественным числом
    public final  static Logger LOGGER = Logger.getRootLogger();

    @Override
    public Response execute(Request request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        SearchBicycleRentalService searchService = factory.getSearchBicycleRentalService();

        List<Product> products;
        Response response = new Response();
        try{
            products = searchService.searchAllProducts();
            response.setErrorStatus(false);
            response.setProducts(products);
            LOGGER.info("search all products is success");
        } catch (ServiceException e) {

            response.setErrorStatus(true);
            response.setErrorMessage(MessageConstant.NOTSUCCESS_SEARCH_ALL_MSG);
            LOGGER.info("search all products is unsuccess");
        }

        return response;

    }
}
