package com.company;

import java.util.Scanner;

public class Phd {
    String name;
    String email;
    int login;
    Project[] projects;
    boolean admin;
    Publication[] publications;
    public Phd(String name, String email, int login, boolean admin){
        this.name = name;
        this.email = email;
        this.login = login;
        this.admin = admin;
        this.projects = new Project[100];
        this.publications = new Publication[100];
    }
    public void pInfo (){
        java.lang.System.out.print("name: "+this.name+"\n");
        java.lang.System.out.print("email: "+this.email+"\n");
        java.lang.System.out.print("your projects:\n");
        for (int i = 0; i<100; i++){
            if(this.projects[i] != null){
                java.lang.System.out.print("title: "+ this.projects[i].title+"\n");
                java.lang.System.out.print("Status"+this.projects[i].status+"\n");
                java.lang.System.out.printf("End (ddmmyyyy): %d\n",this.projects[i].end);
                java.lang.System.out.print("-------\n");
            }
        }
        java.lang.System.out.print("your publications:\n");
        for (int i = 0; i<100; i++){

            if(this.publications[i] != null){
                java.lang.System.out.print("title: "+ this.publications[i].title+"\n");
                java.lang.System.out.printf("Year: %d\n",this.publications[i].year);
                java.lang.System.out.print("-------\n");
            }

        }
    }
}
