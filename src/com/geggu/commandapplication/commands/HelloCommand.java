package com.geggu.commandapplication.commands;

import com.geggu.commandapplication.commandsystem.Command;
import com.geggu.commandapplication.commandsystem.CommandAtribute;
import com.geggu.commandapplication.commandsystem.ParametersOperator;

public class HelloCommand extends CommandAtribute implements Command {
    public void execute(){
        console.writer("Hello " + ((getParametersObject().getParameter(0) != null)?(getParametersObject().getParameter(0)):""));
    }
    public HelloCommand() {
         super("Hello", new ParametersOperator.Builder().build());
    }
}
