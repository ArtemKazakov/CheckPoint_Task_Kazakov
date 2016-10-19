package com.epam.bicyclerental.dao.factory;


import com.epam.bicyclerental.dao.BRDao;
import com.epam.bicyclerental.dao.impl.FileBRDAO;

public class DAOFactory {
	private static final DAOFactory INSTANCE = new DAOFactory();
		
	private BRDao brDao = new FileBRDAO();;
	
	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
		return INSTANCE;
	}
	
	public BRDao getNBDao(){
		return brDao;
	}

}
