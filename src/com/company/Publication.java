package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Publication {
    ArrayList<Integer> authors;
    String title;
    String conference;
    int year;
    public Publication(String title, String conference, int login, int year){
        this.title = title;
        this.conference = conference;
        this.year = year;
        this.authors = new ArrayList<>();
        this.authors.add(login);
        while (true){
            java.lang.System.out.print("another author?\n Yes - 1 No - 2\n");
            Scanner input = new Scanner(java.lang.System.in);
            int resp = input.nextInt();
            int newLog;
            if (resp == 1){
                java.lang.System.out.print("insert the login\n");
                newLog = input.nextInt();
                if (!this.authors.contains(newLog)){
                    this.authors.add(newLog);
                }else{
                    java.lang.System.out.print("This author has already been registered\n");
                }
            }else{
                break;
            }
        }
    }
}
