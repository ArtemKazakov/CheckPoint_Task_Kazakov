package com.epam.bicyclerental.view;

import com.epam.bicyclerental.bean.Request;
import com.epam.bicyclerental.bean.Response;
import com.epam.bicyclerental.bean.entity.Category;
import com.epam.bicyclerental.bean.entity.Product;
import com.epam.bicyclerental.command.impl.AddProduct;
import com.epam.bicyclerental.controller.Controller;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ASUS on 19.10.2016.
 */
public class ConsoleView {

    private static final Logger LOGGER = Logger.getRootLogger();
    private static boolean active = true;
    private static Controller controller;

    public static void main(String[] args) {
        controller = new Controller();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            Menu menu = new Menu();
            while(active){
                menu.printMenu();
                int command = Integer.parseInt(in.readLine());
                handleCommand(command, in);
            }
        }
        catch (IOException e){
            LOGGER.error("error in main");
        }

    }

    public static void handleCommand(int command, BufferedReader in) throws IOException{
        switch(command){
            case 1:
                addProductHandler(in);
                break;
            case 2:
                editProductHandler(in);
                break;
            case 3:
                deleteProductHandler(in);
                break;
            case 4:
                showAllProductsHandler();
                break;
            case 5:
                showProductsByCategoryHandler(in);
                break;
            case 6:
                makeReportHandler();
                break;
            case 0:
                active = false;
                break;
            default:
                System.out.println("Unknown command");
        }
    }

    public static void addProductHandler(BufferedReader in) throws IOException{
        Request request = new Request();
        request.setCommandName("ADD_PRODUCT");

        System.out.println("Enter name: ");
        request.setName(in.readLine());

        System.out.println("Enter price: ");
        request.setPrice(Double.parseDouble(in.readLine()));

        System.out.println("Enter description: ");
        request.setDescription(in.readLine());

        System.out.println("Enter category id: ");
        request.setIdCategory(Integer.parseInt(in.readLine()));

        Response response = controller.doAction(request) ;

        if (!response.isErrorStatus()) {
            System.out.println(response.getSimpleMessage());
        } else {
            System.out.println(response.getErrorMessage());
        }
    }

    public static void editProductHandler(BufferedReader in) throws IOException{
        Request request = new Request();
        Response response;

        request.setCommandName("SEARCH_ALL_PRODUCTS");
        response = controller.doAction(request);
        response.getProducts().forEach(System.out::println);

        request = new Request();
        request.setCommandName("EDIT_PRODUCT");

        System.out.println("Enter product id:");
        request.setId(Integer.parseInt(in.readLine()));

        System.out.println("Enter new name: ");
        request.setName(in.readLine());

        System.out.println("Enter new price: ");
        request.setPrice(Double.parseDouble(in.readLine()));

        System.out.println("Enter new description: ");
        request.setDescription(in.readLine());

        System.out.println("Enter new category id: ");
        request.setIdCategory(Integer.parseInt(in.readLine()));

        response = controller.doAction(request) ;

        if (!response.isErrorStatus()) {
            System.out.println(response.getSimpleMessage());
        } else {
            System.out.println(response.getErrorMessage());
        }
    }

    public static void deleteProductHandler(BufferedReader in) throws IOException{
        Request request = new Request();
        Response response;

        request.setCommandName("SEARCH_ALL_PRODUCTS");
        response = controller.doAction(request);
        response.getProducts().forEach(System.out::println);

        request = new Request();
        request.setCommandName("DELETE_PRODUCT");

        System.out.println("Enter product id:");
        request.setId(Integer.parseInt(in.readLine()));

        response = controller.doAction(request) ;

        if (!response.isErrorStatus()) {
            System.out.println(response.getSimpleMessage());
        } else {
            System.out.println(response.getErrorMessage());
        }
    }

    public static void showAllProductsHandler() throws IOException{
        Request request = new Request();
        Response response;

        request.setCommandName("SEARCH_ALL_PRODUCTS");
        response = controller.doAction(request);
        response.getProducts().forEach(System.out::println);

        if (!response.isErrorStatus()) {
            System.out.println(response.getSimpleMessage());
        } else {
            System.out.println(response.getErrorMessage());
        }
    }

    public static void showProductsByCategoryHandler(BufferedReader in) throws IOException{
        Request request = new Request();
        Response response;

        request.setCommandName("SEARCH_PRODUCTS_BY_CATEGORY");

        System.out.println("Enter category id: ");
        request.setIdCategory(Integer.parseInt(in.readLine()));

        response = controller.doAction(request);
        response.getProducts().forEach(System.out::println);

        if (!response.isErrorStatus()) {
            System.out.println(response.getSimpleMessage());
        } else {
            System.out.println(response.getErrorMessage());
        }
    }

    public static void makeReportHandler() throws IOException{
        Request request = new Request();
        Response response;

        request.setCommandName("MAKE_REPORT");

        response = controller.doAction(request);
        response.getReportNodes().forEach(System.out::println);

        if (!response.isErrorStatus()) {
            System.out.println(response.getSimpleMessage());
        } else {
            System.out.println(response.getErrorMessage());
        }
    }
}
