package com.geggu.commandapplication.commandsystem;

public interface ParametersOperatorApi {
    boolean parameterRequired(int idParameter);
    boolean currentDualParameterIsInt(int idParameter);

    String getParameterType(int idParameter);
    int getLengthParameters();
    int getLengthRequiredParameters();
    <T> T getParameter(int idParameter);

    boolean setParameter(String str, int idParameter);
    boolean setParameter(int number, int idParameter);
    void setNullParameter(int idParameter);
}
