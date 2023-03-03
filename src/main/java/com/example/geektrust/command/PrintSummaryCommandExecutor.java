package com.example.geektrust.command;

import com.example.geektrust.model.Command;
import com.example.geektrust.service.StationService;

/**
 * Executor for PRINT_SUMMARY Command
 */

public class PrintSummaryCommandExecutor extends CommandExecutor{

    public static final String COMMAND_NAME = "PRINT_SUMMARY";

    public PrintSummaryCommandExecutor(StationService stationService) {
        super(stationService);
    }


    /**
     *{@inheritDoc}
     */
    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void execute(Command command) {
        stationService.printSummary();
    }
}
