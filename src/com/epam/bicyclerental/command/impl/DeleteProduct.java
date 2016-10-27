package com.epam.bicyclerental.command.impl;

import com.epam.bicyclerental.bean.Request;
import com.epam.bicyclerental.bean.Response;
import com.epam.bicyclerental.command.Command;
import com.epam.bicyclerental.constants.MessageConstant;
import com.epam.bicyclerental.service.EditBicycleRentalService;
import com.epam.bicyclerental.service.exception.ServiceException;
import com.epam.bicyclerental.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

/**
 * Created by ASUS on 19.10.2016.
 */
public class DeleteProduct implements Command{
    public final  static Logger LOGGER = Logger.getRootLogger();
    @Override
    public Response execute(Request request) {

        ServiceFactory factory = ServiceFactory.getInstance();
        EditBicycleRentalService editService = factory.getEditBicycleRentalService();

        Response response= new Response();
        try{
            editService.deleteProduct(request.getId());
            response.setErrorStatus(false);
            response.setSimpleMessage(MessageConstant.SUCCESS_DELETE_MSG);
            LOGGER.info("delete product is success");
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(MessageConstant.NOTSUCCESS_DELETE_MSG);
            LOGGER.info("delete product is unsuccess");
        }

        return response;
    }

}
