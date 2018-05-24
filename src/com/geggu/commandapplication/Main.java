package com.geggu.commandapplication;

import com.geggu.commandapplication.commands.*;

import com.geggu.commandapplication.commandsystem.CommandOperator;
import com.geggu.commandapplication.commands.HelloCommand;
import com.geggu.commandapplication.logsystem.Log;
import com.geggu.commandapplication.ui.UserInterface;



public class Main {
    private final static String aplicationName = "CommandAplication";
    public static void main(String[] args) {
        System.out.println("------------------------");
        System.out.println("[" + aplicationName + "]");
        Log.start();
        System.out.println("------------------------");
        CommandOperator converter = new CommandOperator(new HelloCommand(), new ExitCommand(), new SumCommand(), new PrintCommand(), new CreateNewFileCommand(), new TestCommand());
        UserInterface console = new UserInterface("Console");
        while(true) {
            converter.convert(console.reader()).execute();
        }
    }
}