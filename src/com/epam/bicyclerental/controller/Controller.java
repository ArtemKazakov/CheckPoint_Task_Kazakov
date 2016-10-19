package com.epam.bicyclerental.controller;

import com.epam.bicyclerental.bean.Request;
import com.epam.bicyclerental.bean.Response;
import com.epam.bicyclerental.command.Command;

/**
 * Created by ASUS on 19.10.2016.
 */
public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public Response doAction(Request request) {
        String commandName = request.getCommandName();

        Command command = provider.getCommand(commandName);

        Response response = command.execute(request);

        return response;

    }
}
