package com.geggu.commandapplication.commands;

import com.geggu.commandapplication.commandsystem.Command;
import com.geggu.commandapplication.commandsystem.CommandAtribute;
import com.geggu.commandapplication.commandsystem.ParametersOperator;
import com.geggu.commandapplication.logsystem.Log;

import java.io.File;
import java.io.IOException;

public class CreateNewFileCommand extends CommandAtribute implements Command {
    public void execute(){
        String fileName = getParametersObject().getParameter(0) + "." + ((getParametersObject().getParameter(1)!=null)? getParametersObject().getParameter(1):"txt");
        File file = new File(fileName);
        if(file.exists()){
            console.writer("The file exists!");
            Log.add("The file \"" + fileName + "\" exists");
        }else {
            try {
                file.createNewFile();
                console.writer("The file has been created");
                Log.add("The file \"" + fileName + "\"  has been created");
            } catch (IOException e) {
                console.writer("Can't create this file!");
                Log.add("The file \"" + fileName + "\" can't be created");
                Log.add(e.getMessage());
            }
        }
    }
    public CreateNewFileCommand(){
        super("Create", new ParametersOperator.Builder(true).addParameter(false).build());
    }
}
