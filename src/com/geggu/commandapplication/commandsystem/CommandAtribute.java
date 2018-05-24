package com.geggu.commandapplication.commandsystem;

import com.geggu.commandapplication.logsystem.Log;
import com.geggu.commandapplication.ui.UserInterface;

public class CommandAtribute {
    private final String commandName;
    private ParametersOperatorApi parameterOperator;
    protected UserInterface console;


    public ParametersOperatorApi getParametersObject(){
        return parameterOperator;
    }
    public void setParameters(ParametersOperatorApi parametersOperator){
        this.parameterOperator = parametersOperator;
    }
    public String getCommandName(){
        return commandName;
    }

    protected CommandAtribute(String commandName, ParametersOperatorApi parameterOperator){
        commandName = commandName.toLowerCase();
        Log.add("The command " + commandName + " has been created");
        this.parameterOperator = parameterOperator;
        this.commandName = commandName;
        this.console = new UserInterface("Command");
    }
}
