package com.geggu.commandapplication.commandsystem;

import com.geggu.commandapplication.logsystem.Log;
import com.geggu.commandapplication.ui.UserInterface;

public class CommandOperator {
    private Command[] commands;
    private UserInterface console = new UserInterface("CommandOperator");


    private String getParametersPattern(Command command){
        StringBuilder pattern = new StringBuilder();
        for(int i = 0; i < command.getParametersObject().getLengthParameters(); i++ ){
            if(command.getParametersObject().parameterRequired(i)){
                pattern.append("<(requested)");
            }else{
                pattern.append("<(optional)");
            }
            pattern.append(" ").append(command.getParametersObject().getParameterType(i)).append("> ");
        }
        if(pattern.length() == 0 ){
            pattern.append("(command without parameters)");
        }
        return pattern.toString();
    }


    private Command convertParameters(Command command, String[] parameters){
        ParametersOperatorApi pattern = command.getParametersObject();
        for(int i = 0; i < pattern.getLengthParameters(); i++){
            pattern.setNullParameter(i);
        }
        for(int i=1; i<parameters.length; i++){
            if(pattern.getParameterType(i-1).equalsIgnoreCase("Number")){
                try{
                    pattern.setParameter(Integer.parseInt(parameters[i]), i-1);
                }catch(NumberFormatException e){
                    console.writer("The wrong type of parameter! Try again!");
                    console.writer("The pattern of this command: " + command.getCommandName() + " " + getParametersPattern(command));
                    Log.add(e.getMessage());
                    return commandExist(console.reader());
                }

            }else if(pattern.getParameterType(i-1).equalsIgnoreCase("Dual")) {
                try{
                    pattern.setParameter(Integer.parseInt(parameters[i]), i-1);
                }catch(NumberFormatException e){
                    pattern.setParameter(parameters[i], i - 1);
                }
            }else{
                pattern.setParameter(parameters[i], i-1);
            }
        }
        command.setParameters(pattern);
        return command;
    }
    private Command amountParameters(Command command, String[] parameters){
        if(command.getParametersObject().getLengthRequiredParameters()> (parameters.length - 1) || (parameters.length-1)>command.getParametersObject().getLengthParameters()  ){
            console.writer("The amount of parameters is wrong! The command has " + (command.getParametersObject().getLengthRequiredParameters()) + " required parameters and " + (command.getParametersObject().getLengthParameters()-command.getParametersObject().getLengthRequiredParameters()) + " optional parameters. Try again!");
            console.writer("The pattern of this command: " + command.getCommandName() + " " + getParametersPattern(command));
            return commandExist(console.reader());
        }else{
            return convertParameters(command, parameters);
        }
    }
    private Command commandExist(String line){
        while(line.matches("(.*) {2}(.*)")){
            line = line.replaceAll(" {2}", " ");
        }
        String[] parameters = line.split(" ");
        Command command = null;
        for(Command x: commands){
            if(x.getCommandName().equalsIgnoreCase(parameters[0])) {
                command = x;
                break;
            }
        }
        if(command==null){
            console.writer("The command has not found! Try again!");
            return commandExist(console.reader());
        }else{
            return amountParameters(command, parameters);
        }
    }
    public Command convert(String line){
        return commandExist(line);
    }

    public CommandOperator(Command...commands){
        this.commands = commands;
    }
}
