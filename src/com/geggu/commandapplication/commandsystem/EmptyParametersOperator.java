package com.geggu.commandapplication.commandsystem;


public class EmptyParametersOperator implements ParametersOperatorApi {
    public boolean parameterRequired(int idParameter){
        return false;
    }

    public boolean currentDualParameterIsInt(int idParameter) { return false; }

    public String getParameterType(int idParameter){
        return "";
    }
    public int getLengthParameters(){
        return 0;
    }
    public int getLengthRequiredParameters(){
        return 0;
    }
    public <T> T getParameter(int idParameter){
        return (T)((String)"");
    }


    public boolean setParameter(String str, int idParameter){
        return false;
    }
    public boolean setParameter(int number, int idParameter){
        return false;
    }
    public void setNullParameter(int idParameter){}
}
