package com.geggu.commandapplication.logsystem;

import com.geggu.commandapplication.ui.UserInterface;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class LogFileOperator {
    private File file;
    private UserInterface console;

    private String generateDate(String pattern){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
    private String getDateToFile(){
        return generateDate("yyyy-MM-dd HH-mm-ss");
    }
    private String getDate(){
        return generateDate("yyyy-MM-dd HH:mm:ss");
    }
    private File createLogFile() {
        String fileName = "log ";
        File file;
        String dateToFile = getDateToFile();
        new File("log").mkdir();
        file = new File("log/" + "log " + dateToFile + ".log");
        int i = 0;
        while (file.exists()){
            file = new File("log/" + fileName + dateToFile + " (" + i + ").log");
            i++;
        }
        try{
            file.createNewFile();
            return file;

        }catch(IOException e){
            console.writer(e.getMessage());
            System.exit(1);
        }
        return null;
    }


    boolean isFile(){
        return (file!=null);
    }
    void saveLogNote(String note){
        try {
            PrintWriter writer = new PrintWriter(new FileWriter( this.file, true));
            writer.println("[" + getDate() + "] " + note);
            writer.close();
        }catch (IOException e) {
            console.writer(e.getMessage());
        }
    }

    LogFileOperator(){
        System.out.println(getDate());
        this.file = createLogFile();
        console = new UserInterface("LogOperator");
        saveLogNote("Program started");
    }
}
