package com.company;

import java.util.Scanner;

public class Publication {
    int [][] authors;
    String title;
    String conference;
    int year;
    public Publication(String title, String conference, int cases, int login, int year){
        this.title = title;
        this.conference = conference;
        this.year = year;
        this.authors = new int[5][1000];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j< 1000; j++){
                this.authors[i][j] = 0;
            }
        }
        this.authors[cases-1][login] = 1;
        while (true){
            java.lang.System.out.print("another author?\n Yes - 1 No - 2\n");
            Scanner input = new Scanner(java.lang.System.in);
            int resp = input.nextInt();
            int classes, newLog;
            if (resp == 1){
                java.lang.System.out.print("insert the class:\n Researcher - 1 Teacher - 2 PhD - 3 Mastering - 4 Undergraduate -5\n");
                classes = input.nextInt();
                java.lang.System.out.print("insert the login\n");
                newLog = input.nextInt();
                this.authors[classes-1][newLog] = 1;
            }else{
                break;
            }
        }
    }
}
