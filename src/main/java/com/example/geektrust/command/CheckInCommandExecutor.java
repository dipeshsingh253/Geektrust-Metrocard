package com.example.geektrust.command;

import com.example.geektrust.model.Command;
import com.example.geektrust.model.enums.PassengerType;
import com.example.geektrust.model.enums.StationName;
import com.example.geektrust.service.StationService;

/**
 *  Executor for Handling CHECk_IN Command
 */

public class CheckInCommandExecutor extends CommandExecutor{

    public static final String COMMAND_NAME = "CHECK_IN";

    private static final Integer MIN_REQUIRED_ARGUMENTS = 3;

    public CheckInCommandExecutor(final StationService stationService) {
        super(stationService);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(final Command command) {
        return command.getParams().size() == MIN_REQUIRED_ARGUMENTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final Command command) {
        stationService.checkInTicket(command.getParams().get(0), PassengerType.valueOf(command.getParams().get(1)), StationName.valueOf(command.getParams().get(2)));
    }
}
