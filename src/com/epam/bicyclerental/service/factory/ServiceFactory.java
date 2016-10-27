package com.epam.bicyclerental.service.factory;

import com.epam.bicyclerental.service.EditBicycleRentalService;
import com.epam.bicyclerental.service.SearchBicycleRentalService;
import com.epam.bicyclerental.service.impl.EditBicycleRental;
import com.epam.bicyclerental.service.impl.SearchBicycleRental;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private EditBicycleRentalService editBicycleRentalService = new EditBicycleRental();
	private SearchBicycleRentalService searchBicycleRentalService = new SearchBicycleRental();
	
	private ServiceFactory(){}
	
	
	public static ServiceFactory getInstance(){
		return instance;
	}
	
	public EditBicycleRentalService getEditBicycleRentalService(){
		return editBicycleRentalService;
	}
	
	public SearchBicycleRentalService getSearchBicycleRentalService(){
		return searchBicycleRentalService;
	}

}
