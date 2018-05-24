package com.geggu.commandapplication.commands;

import com.geggu.commandapplication.commandsystem.Command;
import com.geggu.commandapplication.commandsystem.CommandAtribute;
import com.geggu.commandapplication.commandsystem.ParametersOperator;

public class PrintCommand extends CommandAtribute implements Command {
    public void execute(){
        StringBuilder textToPrint = new StringBuilder();
        for(int i = 0; i<(Integer) getParametersObject().getParameter(1); i++){
            textToPrint.append((String) getParametersObject().getParameter(0) + " ");
        }
        if(textToPrint.length() == 0){
            textToPrint.append((String) getParametersObject().getParameter(0));
        }
        console.writer(textToPrint.toString());
    }
    public PrintCommand(){
        super("Print", new ParametersOperator.Builder("String", true).addParameter("Number").build());
    }
}
