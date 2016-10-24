package com.epam.bicyclerental.dao.factory;


import com.epam.bicyclerental.dao.BicycleRentalDAO;
import com.epam.bicyclerental.dao.impl.ProductDAO;

public class DAOFactory {
	private static final DAOFactory INSTANCE = new DAOFactory();
		
	private BicycleRentalDAO bicycleRentalDAO = new ProductDAO();
	
	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
		return INSTANCE;
	}
	
	public BicycleRentalDAO getProductDAO(){
		return bicycleRentalDAO;
	}

}
