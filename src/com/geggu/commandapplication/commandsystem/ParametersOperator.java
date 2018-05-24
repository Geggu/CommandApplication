package com.geggu.commandapplication.commandsystem;

import java.util.List;
import java.util.ArrayList;

public class ParametersOperator implements ParametersOperatorApi {
    private List<Parameter> parametersList;

    private boolean isDual(int idParameter){
        if(parametersList.size()>idParameter){
            return parametersList.get(idParameter).getParameterType().equalsIgnoreCase("Dual");
        }else{
            return false;
        }
    }
    private boolean rightParameter(Parameter parameter, String type){
        return type.equalsIgnoreCase(parameter.getParameterType());
    }

    public boolean parameterRequired(int idParameter){
        if(idParameter >= parametersList.size()){
            return false;
        }else{
            return parametersList.get(idParameter).isRequired();
        }
    }
    public String getParameterType(int idParameter){
        if(idParameter < parametersList.size()){
            return parametersList.get(idParameter).getParameterType();
        }else{
            return null;
        }
    }

    public boolean currentDualParameterIsInt(int idParameter){
        boolean outOfBoard = (parametersList.size() <= idParameter);
        if( !outOfBoard && isDual(idParameter)){
            return parametersList.get(idParameter).intTypeOfDualParameter();
        }else if( !outOfBoard ) {
            return parametersList.get(idParameter).getParameterType().equalsIgnoreCase("Number");
        }else{
            return false;
        }
    }

    public int getLengthParameters(){
        return parametersList.size();
    }
    public int getLengthRequiredParameters(){
        int n = 0;
        for(Parameter x: parametersList){
            if(x.isRequired())
                n++;
        }
        return n;
    }

    public boolean setParameter(String str, int idParameter){
        if(parametersList.size()>idParameter && (rightParameter(parametersList.get(idParameter), "String")|| rightParameter(parametersList.get(idParameter), "Dual"))){
            Parameter parameter = parametersList.get(idParameter);
            parameter.setParameter(str);
            parametersList.set(idParameter, parameter );
            return true;
        }else {
            return false;
        }
    }
    public boolean setParameter(int number, int idParameter){
        if(parametersList.size()>idParameter &&  (rightParameter(parametersList.get(idParameter), "Number") || rightParameter(parametersList.get(idParameter), "Dual"))){
            Parameter parameter = parametersList.get(idParameter);
            parameter.setParameter(number);
            parametersList.set(idParameter, parameter  );
            return true;
        }
        return false;
    }
    public void setNullParameter(int idParameter){
        if(parametersList.size() > idParameter){
            if(parametersList.get(idParameter).getParameterType().equalsIgnoreCase("Number") || parametersList.get(idParameter).getParameterType().equalsIgnoreCase("Dual") ) {
                Parameter parameter = parametersList.get(idParameter);
                parameter.setParameterIntNull();
                parametersList.set(idParameter, parameter );
            }
            if(parametersList.get(idParameter).getParameterType().equalsIgnoreCase("String") || parametersList.get(idParameter).getParameterType().equalsIgnoreCase("Dual")) {
                Parameter parameter = parametersList.get(idParameter);
                parameter.setParameter(null);
                parametersList.set(idParameter, parameter );
            }
        }
    }
    public <T> T getParameter(int idParameter){
        if(idParameter < parametersList.size()){
            if(getParameterType(idParameter).equalsIgnoreCase("Number") || (getParameterType(idParameter).equalsIgnoreCase("Dual") && currentDualParameterIsInt(idParameter))){
                return (T)((Integer) parametersList.get(idParameter).getParameter());

            }else if(getParameterType(idParameter).equalsIgnoreCase("String") || getParameterType(idParameter).equalsIgnoreCase("Dual")) {
                return (T) ((String) parametersList.get(idParameter).getParameter());
            }
        }
        return null;
    }

    private ParametersOperator(Builder builder){
        this.parametersList = builder.parametersList;
    }

    public static class Builder{
        private List<Parameter> parametersList = new ArrayList<>();

        public ParametersOperator build(){
            return new ParametersOperator(this);
        }


        public Builder addParameter(String type, boolean required ){
            if(type.equalsIgnoreCase("Number")){
                parametersList.add(new Parameter("Number", required) );
            }else if(type.equalsIgnoreCase("Dual")){
                parametersList.add(new Parameter("Dual", required));
            }else{
                parametersList.add(new Parameter("String", required));
            }
            return this;
        }
        public Builder addParameter(String type){
            return addParameter(type, false);
        }
        public Builder addParameter(boolean required){
            return addParameter("String", required);
        }
        public Builder addParameter(){
            return addParameter("String", false);
        }


        public Builder(String type, boolean required){
            addParameter(type, required);
        }
        public Builder(String type){
            this(type, false);
        }
        public Builder(boolean required){
            this("String", required);
        }
        public Builder(){
            this("String", false);
        }


    }
}
