package com.company;

import java.util.ArrayList;

public class People {
    String name;
    String email;
    int login;
    boolean admin;
    ArrayList<Integer> myprojects;
    ArrayList<Publication> publications;
    int type;
    public void info (System labS){
        java.lang.System.out.print("name: "+this.name+"\n");
        java.lang.System.out.print("email: "+this.email+"\n");
        java.lang.System.out.print("your projects:\n");
        for (int i = 0; i<this.myprojects.size(); i++){
            java.lang.System.out.print("title: "+ labS.projects.get(this.myprojects.get(i)).title+"\n");
            java.lang.System.out.print("Status"+labS.projects.get(this.myprojects.get(i)).status+"\n");
            java.lang.System.out.printf("End : %d\n",labS.projects.get(this.myprojects.get(i)).end);
            java.lang.System.out.print("-------\n");
        }
        java.lang.System.out.print("your publications:\n");
        for (int i = 0; i<this.publications.size(); i++){
            java.lang.System.out.print("title: "+ this.publications.get(i).title+"\n");
            java.lang.System.out.printf("Year: %d\n",this.publications.get(i).year);
            java.lang.System.out.print("-------\n");

        }
    }
}
