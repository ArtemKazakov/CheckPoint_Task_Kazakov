package com.epam.bicyclerental.bean;

import com.epam.bicyclerental.bean.entity.Product;
import com.epam.bicyclerental.bean.entity.ReportNode;

import java.util.List;

/**
 * Created by ASUS on 19.10.2016.
 */
public class Response {
    private boolean errorStatus;
    private String errorMessage;
    private String simpleMessage;
    private List<Product> products;
    private List<ReportNode> reportNodes;

    public boolean isErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(boolean errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSimpleMessage() {
        return simpleMessage;
    }

    public void setSimpleMessage(String simpleMessage) {
        this.simpleMessage = simpleMessage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<ReportNode> getReportNodes() {
        return reportNodes;
    }

    public void setReportNodes(List<ReportNode> reportNodes) {
        this.reportNodes = reportNodes;
    }
}
