package com.geggu.commandapplication.commands;

import com.geggu.commandapplication.commandsystem.*;
import com.geggu.commandapplication.logsystem.Log;

public class ExitCommand extends CommandAtribute implements Command {
    public void execute(){
        console.writer("Goodbye");
        Log.add("The program finished");
        System.exit(0);
    }
    public ExitCommand(){
        super("exit", new EmptyParametersOperator());
    }

}
