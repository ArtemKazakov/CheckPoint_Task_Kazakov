package com.epam.bicyclerental.command;

import com.epam.bicyclerental.bean.Request;
import com.epam.bicyclerental.bean.Response;

/**
 * Created by ASUS on 19.10.2016.
 */
public interface Command {
    Response execute(Request request);
}
