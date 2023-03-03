package com.example.geektrust.command;

import com.example.geektrust.exception.InValidCommandException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.StationService;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory to get correct {@link CommandExecutor} from given {@link Command}
 */
public class CommandExecutorFactory {

    private final Map<String,CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(final StationService stationService){

        commands.put(BalanceCommandExecutor.COMMAND_NAME,new BalanceCommandExecutor(stationService));
        commands.put(CheckInCommandExecutor.COMMAND_NAME,new CheckInCommandExecutor(stationService));
        commands.put(PrintSummaryCommandExecutor.COMMAND_NAME,new PrintSummaryCommandExecutor(stationService));

    }


    public CommandExecutor getCommandExecutor(final Command command){

        if (!commands.containsKey(command.getCommandName()))
            throw new InValidCommandException("provided command is not a valid command");

        return commands.get(command.getCommandName());

    }

}
