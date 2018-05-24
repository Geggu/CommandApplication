package com.geggu.commandapplication.commandsystem;

public interface Command {
    ParametersOperatorApi getParametersObject();
    void setParameters(ParametersOperatorApi parametersOperator);
    String getCommandName();
    void execute();
}
