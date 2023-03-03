package com.example.geektrust.command;

import com.example.geektrust.model.Command;
import com.example.geektrust.service.StationService;

/*

*  CommandExecutor : Command Executor Abstract Class
*  purpose of this class is to increase Scalability of this project
*  In order to add new command in future we just have to create a new Executor Class and extend this class and Override all the methods
* */

public abstract class CommandExecutor {

    protected StationService stationService;

    protected CommandExecutor(final StationService stationService){
        this.stationService = stationService;
    }

    /*
    * Validates whether a command is valid to be executed or not.
    *
    * @param command Command to be validated
    * @return Boolean whether command is valid or not
    * */

    public abstract boolean validate(final Command command);


    /*
    * Executes the command
    *
    * @param command Command to be executed
    * */
    public abstract void execute(final Command command);

}
