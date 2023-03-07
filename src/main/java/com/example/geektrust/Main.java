package com.example.geektrust;

import com.example.geektrust.command.CommandExecutorFactory;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.Station;
import com.example.geektrust.service.MetroCardServiceImpl;
import com.example.geektrust.service.StationServiceImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        if (args.length == 0)
            throw new FileNotFoundException("Input file not found");

        readInputFile(args[0]);

    }

    private static void readInputFile(final String fileName){

        // initializing mandatory variables needed to run the project
        final Station station = new Station();
        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(new StationServiceImpl(new MetroCardServiceImpl(station),station));

        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(fileName);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {

                final String inputLine = sc.nextLine();
                Command command = new Command(inputLine);
                commandExecutorFactory.getCommandExecutor(command).execute(command);
  
        }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
