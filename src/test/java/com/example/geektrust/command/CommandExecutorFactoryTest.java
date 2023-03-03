package com.example.geektrust.command;

import com.example.geektrust.model.Command;
import com.example.geektrust.service.StationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;


class CommandExecutorFactoryTest {

    private CommandExecutorFactory commandExecutorFactory;

    @BeforeEach
    void setUp(){
        final StationService stationService = mock(StationService.class);
        commandExecutorFactory = new CommandExecutorFactory(stationService);
    }

    @Test
    void testFetchingCommandExecutor(){
        final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(new Command("BALANCE METRO_CARD_NUMBER 500"));

        assertNotNull(commandExecutor);
        assertTrue(commandExecutor instanceof BalanceCommandExecutor);
    }


}