package com.epam.bicyclerental.command.impl;

import com.epam.bicyclerental.bean.Request;
import com.epam.bicyclerental.bean.Response;
import com.epam.bicyclerental.bean.entity.ReportNode;
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
public class MakeReport implements Command{
    public final  static Logger LOGGER = Logger.getRootLogger();
    @Override
    public Response execute(Request request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        SearchBicycleRentalService searchService = factory.getSearchBicycleRentalService();

        List<ReportNode> reportNodeList;
        Response response = new Response();
        try{
            reportNodeList = searchService.makeReport();
            response.setErrorStatus(false);
            response.setReportNodes(reportNodeList);
            LOGGER.info("make report is success");

        } catch (ServiceException e) {

            response.setErrorStatus(true);
            response.setErrorMessage(MessageConstant.NOTSUCCESS_REPORT_MSG);
            LOGGER.info("make report is unsuccess");
        }

        return response;

    }
}
