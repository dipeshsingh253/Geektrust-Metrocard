package com.example.geektrust.command;

import com.example.geektrust.model.Command;
import com.example.geektrust.service.StationService;

/**
 * Executor for Handling BALANCE Command
 */

public class BalanceCommandExecutor extends CommandExecutor{
    public static final String COMMAND_NAME= "BALANCE";

    private static final Integer MIN_REQUIRED_ARGUMENTS = 2;

    public BalanceCommandExecutor(final StationService stationService){
        super(stationService);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public boolean validate(final Command command) {
        return command.getParams().size() == MIN_REQUIRED_ARGUMENTS;
    }


    /**
     *{@inheritDoc}
     */
    @Override
    public void execute(final Command command) {
        stationService.addBalanceToCard(command.getParams().get(0),Integer.valueOf(command.getParams().get(1)));
    }
}
