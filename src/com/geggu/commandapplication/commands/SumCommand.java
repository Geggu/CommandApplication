package com.geggu.commandapplication.commands;

import com.geggu.commandapplication.commandsystem.Command;
import com.geggu.commandapplication.commandsystem.CommandAtribute;
import com.geggu.commandapplication.commandsystem.ParametersOperator;

public class SumCommand extends CommandAtribute implements Command {
    public void execute(){
        console.writer("Sum: " + getParametersObject().getParameter(0) + " + " + getParametersObject().getParameter(1) + " = "+ ((Integer) getParametersObject().getParameter(0) + (Integer) getParametersObject().getParameter(1)));
    }
    public SumCommand(){
        super("Sum", new ParametersOperator.Builder("Number", true).addParameter("Number", true).build());
    }

}
