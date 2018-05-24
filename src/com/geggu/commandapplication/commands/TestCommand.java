package com.geggu.commandapplication.commands;

import com.geggu.commandapplication.commandsystem.Command;
import com.geggu.commandapplication.commandsystem.CommandAtribute;
import com.geggu.commandapplication.commandsystem.ParametersOperator;

public class TestCommand extends CommandAtribute implements Command {
    public void execute() {
        if(getParametersObject().currentDualParameterIsInt(0)){
            console.writer("This is int");
        }else{
            console.writer("This is String");
            console.writer(getParametersObject().getParameter(0));
        }
    }
    public TestCommand(){
        super("test", new ParametersOperator.Builder("Dual", true).build());
    }
}
