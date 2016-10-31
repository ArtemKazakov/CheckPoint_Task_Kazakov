package com.epam.bicyclerental.controller;


import com.epam.bicyclerental.command.Command;
import com.epam.bicyclerental.command.impl.*;

import java.util.HashMap;
import java.util.Map;

class CommandProvider {
	private Map<String, Command> commands = new HashMap<String, Command>();
	
	CommandProvider() {
		commands.put("ADD_PRODUCT", new AddProduct());// целвй пакет констант создал, а про именования константных строк забыл
		commands.put("DELETE_PRODUCT", new DeleteProduct());
		commands.put("EDIT_PRODUCT", new EditProduct());
		commands.put("SEARCH_ALL_PRODUCTS", new SearchAllProducts());
		commands.put("SEARCH_PRODUCTS_BY_CATEGORY", new SearchProductsByCategory());
		commands.put("MAKE_REPORT", new MakeReport());
	}
	
	
	public Command getCommand(String commandName){
		Command command;
		command = commands.get(commandName);
		return command;
	}

}
