package com.geggu.commandapplication.commandsystem;

public class Parameter {
    private int parameterInt;
    private boolean emptyInt = true;
    private String parameterString;
    private String parameterType;
    private boolean required;

    public String getParameterType() {
        return parameterType;
    }
    public boolean isRequired(){
        return required;
    }
    public boolean intTypeOfDualParameter(){
        return !emptyInt;
    }
    public <T> T getParameter(){
        if(parameterType.equalsIgnoreCase("Number") || (parameterType.equalsIgnoreCase("Dual") && intTypeOfDualParameter())){
            return (T)((Integer)parameterInt);
        }else{
            return (T)(parameterString);
        }
    }

    public void setParameter(int parameter){
        if(parameterType.equalsIgnoreCase("Number") || parameterType.equalsIgnoreCase("Dual")) {
            this.parameterInt = parameter;
            this.emptyInt = false;
        }
        if(parameterType.equalsIgnoreCase("Dual")){
            parameterString = null;
        }
    }
    public void setParameterIntNull(){
        if(parameterType.equalsIgnoreCase("Number") || parameterType.equalsIgnoreCase("Dual")){
            this.parameterInt = 0;
            this.emptyInt = true;
        }
    }
    public void setParameter(String parameter){
        if(parameterType.equalsIgnoreCase("String") || parameterType.equalsIgnoreCase("Dual")) {
            this.parameterString = parameter;
        }
        if(parameterType.equalsIgnoreCase("Dual")){
            setParameterIntNull();
        }
    }


    public Parameter(String parameterType, boolean required ){
        this.required = required;
        this.parameterType = parameterType;
    }
    public Parameter(){
        this("String", false);
    }
}