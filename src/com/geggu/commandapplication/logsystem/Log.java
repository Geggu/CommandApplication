package com.geggu.commandapplication.logsystem;

import com.geggu.commandapplication.ui.UserInterface;

public class Log {
    private final static LogFileOperator logOperator = new LogFileOperator();
    private static boolean fileExists = false;
    private final static UserInterface console = new UserInterface("Console");
    public static void add(String logNote){
        if(!logNote.trim().equals("") && fileExists) {
            logOperator.saveLogNote(logNote);
        }
    }
    public static void addAndPrint(String logNote){
        console.writer(logNote);
        add(logNote);
    }
    public static void start(){
        fileExists = logOperator.isFile();
        if(!fileExists) {
            UserInterface logConsole = new UserInterface("Log");
            logConsole.writer("The log file is not created!");
        }
    }
}
