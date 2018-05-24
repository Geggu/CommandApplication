package com.geggu.commandapplication.ui;

import java.util.Scanner;

public class UserInterface {
    private String name;
    public String reader(){
        Scanner scan =  new Scanner(System.in);
        String read = "";
        System.out.print("> ");
        while(read.trim().equals("") )
            read = scan.nextLine();
        return read.trim();
    }
    public void writer(String str){
        System.out.println("[" + name +"]: " + str);
    }
    public UserInterface(String name){
        this.name = name;
    }
    public UserInterface(){
        this("Console");
    }
}